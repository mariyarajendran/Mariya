package com.example.iosteam.myfirstconstraints.data.webservice

interface ServiceConstant {

    companion object {
        var BASEURL: String = "https://open.rocket.chat/"
        var LOGINAPICALL: String = BASEURL + "api/v1/login"
    }

}