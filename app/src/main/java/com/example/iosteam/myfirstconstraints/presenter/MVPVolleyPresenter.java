package com.example.iosteam.myfirstconstraints.presenter;

import android.content.Context;

import com.example.iosteam.myfirstconstraints.contract.MVPVolleyContract;
import com.example.iosteam.myfirstconstraints.intractor.MVPVolleyIntractor;

public class MVPVolleyPresenter implements MVPVolleyContract.VolleyPresenter, MVPVolleyContract.onGetDataListener {

    MVPVolleyIntractor mvpVolleyIntractor;
    MVPVolleyContract.VolleyView volleyView;


    public MVPVolleyPresenter(MVPVolleyContract.VolleyView volleyView) {
        this.volleyView = volleyView;
        mvpVolleyIntractor = new MVPVolleyIntractor(this);
    }

    @Override
    public void getDataFromUrl(Context context, String stringUrl) {
        mvpVolleyIntractor.initVolleyCall(context, stringUrl);
    }


    @Override
    public void onDataSuccessListener(String stringMsg, String stringData) {
        volleyView.onSuccessListener(stringMsg, stringData);
    }

    @Override
    public void onDataFailureListener(String stringError) {
        volleyView.onFailureListener(stringError);
    }
}
