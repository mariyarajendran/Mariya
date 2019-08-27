package com.example.iosteam.myfirstconstraints.presenter

import android.content.Context
import com.example.iosteam.myfirstconstraints.contract.MVPKotlinContract
import com.example.iosteam.myfirstconstraints.intractor.MVPKotlinIntractor
import org.json.JSONObject


class MVPKotlinPresenter(mvpKotlinContractKotlinView: MVPKotlinContract.KotlinView) : MVPKotlinContract.KotlinPresenter, MVPKotlinContract.KotlinGetDataListener {

    val mvpKotlinContractKotlinView = mvpKotlinContractKotlinView
    var KotlinIntractor: MVPKotlinIntractor? = null

    init {
        intPresenter()
    }

    fun intPresenter() {
        KotlinIntractor = MVPKotlinIntractor(this)

    }

    override fun getDataFromSuccessMsg(successResponse: String) {
        mvpKotlinContractKotlinView.getSuccessListener(successResponse)
    }

    override fun getDataFromFailureMsg(failureResponse: String) {
        mvpKotlinContractKotlinView.getFailureListener(failureResponse)
    }

    override fun getDataFromUrl(context: Context, stringUrl: String, jsonObject: JSONObject) {
        KotlinIntractor?.initVolleyApiCall(context, stringUrl, jsonObject)
    }
}

