package com.example.iosteam.myfirstconstraints.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.iosteam.myfirstconstraints.R
import com.example.iosteam.myfirstconstraints.contract.MVPKotlinContract
import com.example.iosteam.myfirstconstraints.data.webservice.ServiceConstant
import com.example.iosteam.myfirstconstraints.presenter.MVPKotlinPresenter
import com.example.iosteam.myfirstconstraints.utils.commonutils.CommonUtils
import org.json.JSONObject
import java.lang.Exception

class RocketChatLoginActivity : AppCompatActivity(), MVPKotlinContract.KotlinView {

    var mvpKotlinPresenter: MVPKotlinPresenter? = null
    var mButtonHitApi: Button? = null
    var mEditTextUserName: EditText? = null
    var mEditTextPassword: EditText? = null
    var commonUtils: CommonUtils? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rocket_chat_login_activity)

        initObjects()
        initComponents()
        initClickListener()

    }


    fun initObjects() {
        mvpKotlinPresenter = MVPKotlinPresenter(this)
        commonUtils = CommonUtils(this)
    }


    fun initComponents() {
        mButtonHitApi = findViewById(R.id.activity_rc_login_btn_login) as Button
        mEditTextUserName = findViewById(R.id.activity_rc_login_et_username) as EditText
        mEditTextPassword = findViewById(R.id.activity_rc_login_et_password) as EditText

    }


    fun initClickListener() {
        mButtonHitApi!!.setOnClickListener {
            if (commonUtils!!.validateLoginDetails(mEditTextUserName?.text.toString()) && commonUtils!!.validateLoginDetails(mEditTextPassword?.text.toString())) {

                var jsonObjectLoginDetails: JSONObject = JSONObject()
                try {
                    jsonObjectLoginDetails.put("user", mEditTextUserName?.text.toString())
                    jsonObjectLoginDetails.put("password", mEditTextPassword?.text.toString())
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                mvpKotlinPresenter?.getDataFromUrl(this, ServiceConstant.LOGINAPICALL, jsonObjectLoginDetails)
            } else {
                commonUtils?.showToast(resources.getString(R.string.label_rc_login_enter_username_password))
            }
        }
    }


    override fun getSuccessListener(successResponse: String) {
        commonUtils?.showToast(successResponse)
    }

    override fun getFailureListener(failureResponse: String) {
        commonUtils?.showToast(failureResponse)
    }


}
