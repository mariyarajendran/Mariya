package com.example.iosteam.myfirstconstraints.contract;

import android.content.Context;

public interface MVPVolleyContract {

    interface VolleyModel {

    }


    interface VolleyView {

        void onSuccessListener(String stringMsg, String stringData);

        void onFailureListener(String stringError);

    }

    interface VolleyPresenter {
        void getDataFromUrl(Context context, String stringUrl);
    }


    interface VolleyIntractor {
        void initVolleyCall(Context context, String stringUrl);
    }


    interface onGetDataListener {

        void onDataSuccessListener(String stringMsg, String stringData);

        void onDataFailureListener(String stringError);
    }


}
