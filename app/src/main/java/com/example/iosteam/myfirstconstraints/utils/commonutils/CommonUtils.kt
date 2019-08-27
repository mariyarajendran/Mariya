package com.example.iosteam.myfirstconstraints.utils.commonutils

import android.content.Context
import android.widget.Toast

class CommonUtils(context: Context) {

    var context = context


    fun showToast(stringMsg: String) {
        Toast.makeText(context, stringMsg, Toast.LENGTH_LONG).show()
    }


    fun validateLoginDetails(stringValues: String): Boolean {
        var booleanStatus: Boolean = false
        if (stringValues.equals("")) {
            booleanStatus = false
        } else {
            booleanStatus = true
        }
        return booleanStatus

    }


}