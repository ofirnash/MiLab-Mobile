package com.example.stocks_firebase_ex6;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestQueueC {
    private static RequestQueueC reqQInstance;
    private RequestQueue reqQ;

    public RequestQueueC(Context context){
        reqQ = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized RequestQueueC getInstance(Context context){
        if(reqQInstance == null){
            reqQInstance = new RequestQueueC(context);
        }

        return reqQInstance;
    }

    public RequestQueue getQueue(){
        return reqQ;
    }
}
