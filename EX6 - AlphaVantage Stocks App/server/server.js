"use strict";

const express = require('express');
const bodyParser = require('body-parser');
const https = require('https');
const fetch = require("node-fetch");
const FCM = require('fcm-push');

const PORT = 8080; // Port to listen to
const ALPHA_API_FUNCTION = 'GLOBAL_QUOTE';
const ALPHA_API_KEY = '2Y20MNLUY4ZKP67S';
const ALPHA_API_URL = 'https://www.alphavantage.co/query';
const ALPHA_API_FUNC_RESULT = 'Global Quote';
const ALPHA_API_PRICE_RESULT = '05. price';
const FCM_SERVER_KEY = 'AAAA5fjNY5Q:APA91bHr0pL4CvTxYpkLpeVspaVF520s-m0G4XKwDyEPsB-aimdD-4YsqrVLPDs89xu5sa2Svxbe-htieL7sJ90TarXdZZXNhDBnh0nvm1iOIHBMhQGBPVTXs94Tt0UC_irBSSFxkkyE';

let app = express();
app.use(bodyParser.json());

let fcm = new FCM(FCM_SERVER_KEY);

let token = '';
let stock_symbol = '';


// Token
app.post('/token/:token', (req, res) => {
    token = req.params.token;
    console.log("Got new token: " + token);
    res.json({result: "Success!"});
});


// Stock Symbol
app.post('/symbol/:symbol', (req, res) => {
	token = req.body.token;
    stock_symbol = req.params.symbol;
	
	if (!stock_symbol){
		 return res.send("Missing stock symbol!");
	}
	console.log(`Received stock symbol: ${stock_symbol}`);

    setInterval(() => {
        fetchJSONDataFromAPI(stock_symbol, (price, error) => {
            if(error){
                console.error(`Error fetching data: ${error}`);
            } else {
                sendResultToFirebase(token, stock_symbol, price);
            }
        })
    }, 15000);
    res.json({result: 'Success!'});
});


// Fetch stock price by symbol from Alpha Vantage API
const fetchJSONDataFromAPI = (stock_symbol, cb) => {
	let url = new URL(ALPHA_API_URL);
	let url_params = {function: ALPHA_API_FUNCTION, symbol: stock_symbol, apikey: ALPHA_API_KEY};
    Object.keys(url_params).forEach(key => url.searchParams.append(key, url_params[key]));
	
    fetch(url, {method: 'GET'})
    .then(response => response.json())
    .then((data) => {
        cb(data[ALPHA_API_FUNC_RESULT][ALPHA_API_PRICE_RESULT]);
    })
    .catch((error) => {
        console.error(`Error fetching data from API: ${error}`);
        cb('', error);
    });
}


// Send results received from Alpha Vantage API and send to FCM 
const sendResultToFirebase = (token, stock_symbol, price) => {
	fcm.send({
		to: token,
		data: {
			symbol: stock_symbol,
			price: price
		},
		notification: {
			title: `${stock_symbol} UPDATE!`,
			body: `${stock_symbol} just reached: ${price}`
		}
	}, (error, response) => {
		if (error) {
			console.error(`ERROR sending to FCM: ${error}`);
		}
		else{
			console.log('Success!');
		}
	});
}


app.listen(PORT, () => {
	console.log(`Listening at http://localhost:${PORT}`);
});

