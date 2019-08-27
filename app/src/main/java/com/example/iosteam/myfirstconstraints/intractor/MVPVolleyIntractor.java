package com.example.iosteam.myfirstconstraints.intractor;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.example.iosteam.myfirstconstraints.contract.MVPVolleyContract;

public class MVPVolleyIntractor implements MVPVolleyContract.VolleyIntractor {

    MVPVolleyContract.onGetDataListener onGetDataListener;

    public MVPVolleyIntractor(MVPVolleyContract.onGetDataListener onGetDataListener) {
        this.onGetDataListener = onGetDataListener;
    }


    @Override
    public void initVolleyCall(Context context, String stringUrl) {
        RequestQueue requestQueue;
        Cache cache = new DiskBasedCache(context.getCacheDir(), 1024 * 1024); // 1MB cap
        Network network = new BasicNetwork(new HurlStack());
        requestQueue = new RequestQueue(cache, network);
        requestQueue.start();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, stringUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        onGetDataListener.onDataSuccessListener(response, "success");
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        onGetDataListener.onDataFailureListener(error.toString());
                    }
                });
        requestQueue.add(stringRequest);
    }
}
