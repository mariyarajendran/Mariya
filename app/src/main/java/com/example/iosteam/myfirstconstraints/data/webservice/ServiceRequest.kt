package com.example.iosteam.myfirstconstraints.data.webservice

import android.content.Context
import android.util.Log
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonObjectRequest
import com.example.iosteam.myfirstconstraints.utils.volley.MySingleton
import org.json.JSONObject

class ServiceRequest(context: Context) {

    fun apiWebServicePost(context: Context, TAG: String, stringUrl: String, jsonObject: JSONObject, responseListener: ResponseListeners) {

        Log.i(TAG, "apiUrl------>" + stringUrl)
        Log.i(TAG, "params------>" + jsonObject.toString())

        val jsonObjectRequest: JsonObjectRequest = object : JsonObjectRequest(
                Request.Method.POST, stringUrl, jsonObject,
                Response.Listener<JSONObject?> { response ->
                    responseListener.onSuccessResponseListener(response)
                    Log.i(TAG, "response------>" + response.toString())
                }, Response.ErrorListener { error ->
            Log.i(TAG, "error------>" + error.toString())
            responseListener.onFailureResponseListener(error)

        }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): Map<String, String> {
                val headers = HashMap<String, String>()
                headers.put("Content-Type", "application/json")
                headers.put("Accept", "application/json")
                headers.put("Accept-Encoding", "utf-8")
                Log.i(TAG, "headers------>" + headers.toString())
                return headers
            }
        }
        MySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest)
    }


    interface ResponseListeners {
        fun onSuccessResponseListener(jsonObjectResponse: JSONObject?)
        fun onFailureResponseListener(volleyError: VolleyError)

    }


}
