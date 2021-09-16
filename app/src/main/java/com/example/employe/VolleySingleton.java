package com.example.employe;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private RequestQueue requestQueue;
    private static VolleySingleton minstance;

    private VolleySingleton(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());

    }
    public static synchronized VolleySingleton getMinstance(Context context){
        if (minstance == null){
            minstance = new VolleySingleton(context);
        }
        return minstance;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
