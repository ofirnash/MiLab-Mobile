package com.example.stocks_firebase_ex6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button monitorStkButton = (Button) findViewById(R.id.monitor_stock_btn);
        monitorStkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText stockSymbolEntered = (EditText) findViewById(R.id.stockSymbolEnteredByUser);
                // Symbol entered is a valid stock symbol!
                final String SYMBOL =  stockSymbolEntered.getText().toString();
                final String msg = "Monitoring stock: " + SYMBOL;
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                symbolToServer(SYMBOL);
            }
        });
    }


    /**
     * Send stock symbol to server
     *
     * @param symbol- Stock symbol
     */
    private void symbolToServer(String symbol){
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String token = instanceIdResult.getToken();
                sendSymbolTokenToServer(symbol, token);
            }
        });
    }


    /**
     * Send symbol and token to server
     *
     * @param symbol- Stock symbol
     * @param token - Firebase token
     */
    private void sendSymbolTokenToServer(String symbol, String token){
        JSONObject reqObject = new JSONObject();
        try {
            reqObject.put("token", token);
        } catch (JSONException e) {
            return;
        }

        String server_address = getResources().getString(R.string.server_ip_address);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.POST, server_address +
                "symbol/" + symbol,
                reqObject, response -> Log.i("symbolToServer", "Symbol updated successfully"),
                error -> Log.e("symbolToServer", "Failed to save symbol - " + error)
        );

        // Add request to queue
        RequestQueueC.getInstance(this).getQueue().add(req);
    }
}