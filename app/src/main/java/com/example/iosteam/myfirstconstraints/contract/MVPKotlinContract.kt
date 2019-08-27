package com.example.iosteam.myfirstconstraints.contract

import android.content.Context
import org.json.JSONObject

interface MVPKotlinContract {

    interface KotlinView {

        fun getSuccessListener(successResponse: String)
        fun getFailureListener(failureResponse: String)

    }

    interface KotlinPresenter {
        fun getDataFromUrl(context: Context, stringUrl: String, jsonObject: JSONObject)
    }

    interface KotlinIntractor {
        fun initVolleyApiCall(context: Context, stringUrl: String, jsonObject: JSONObject)
    }

    interface KotlinGetDataListener {

        fun getDataFromSuccessMsg(successResponse: String)
        fun getDataFromFailureMsg(failureResponse: String)

    }


}