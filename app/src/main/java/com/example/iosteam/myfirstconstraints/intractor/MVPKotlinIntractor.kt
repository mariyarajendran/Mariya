package com.example.iosteam.myfirstconstraints.intractor

import android.content.Context
import com.example.iosteam.myfirstconstraints.contract.MVPKotlinContract
import org.json.JSONObject
import com.android.volley.VolleyError
import com.example.iosteam.myfirstconstraints.data.webservice.ServiceRequest


class MVPKotlinIntractor(mvpKotlinContractKotlinGetDataListener: MVPKotlinContract.KotlinGetDataListener) : MVPKotlinContract.KotlinIntractor {

    val mvpKotlinContractKotlinGetDataListener = mvpKotlinContractKotlinGetDataListener
    var TAG: String = MVPKotlinIntractor::class.java.simpleName
    var serviceRequest: ServiceRequest? = null


    override fun initVolleyApiCall(context: Context, stringUrl: String, jsonObject: JSONObject) {
        serviceRequest = ServiceRequest(context)
        serviceRequest!!.apiWebServicePost(context, TAG, stringUrl, jsonObject, object : ServiceRequest.ResponseListeners {

            override fun onSuccessResponseListener(jsonObjectResponse: JSONObject?) {
                mvpKotlinContractKotlinGetDataListener.getDataFromSuccessMsg(jsonObjectResponse.toString())
            }

            override fun onFailureResponseListener(volleyError: VolleyError) {
                mvpKotlinContractKotlinGetDataListener.getDataFromSuccessMsg(volleyError.toString())

            }


        })

    }
}