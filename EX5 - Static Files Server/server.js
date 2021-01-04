const express = require('express');
const fs = require('fs');

let app = express();




app.on('request', (req, res) => {
	const src = fs.createReadStream('./big.file');
	src.pipe(res);
  
	// GET /file/javascripts/jquery.js
	console.dir(req.params[0])

});
