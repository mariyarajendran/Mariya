package com.example.iosteam.myfirstconstraints.contract;


import android.view.View;

public interface MVPContract {


    interface Model {

        String getData();
    }


    interface Views {

        void initView();

        void setViewData(String string);
    }


    interface Presenter {

        void onClick(View view);

    }


}
