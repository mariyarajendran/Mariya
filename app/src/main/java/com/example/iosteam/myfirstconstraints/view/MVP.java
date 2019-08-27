package com.example.iosteam.myfirstconstraints.view;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.iosteam.myfirstconstraints.AndroidServices;
import com.example.iosteam.myfirstconstraints.R;
import com.example.iosteam.myfirstconstraints.contract.MVPVolleyContract;
import com.example.iosteam.myfirstconstraints.presenter.MVPVolleyPresenter;

public class MVP extends AppCompatActivity implements MVPVolleyContract.VolleyView {

    MVPVolleyPresenter mvpVolleyPresenter;
    String stringUrl = "https://api.androidhive.info/contacts/";
    Button mButtonStopService;
    Intent mServiceIntent;
   


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);


        AndroidServices mSensorService = new AndroidServices();
        mServiceIntent = new Intent(getApplicationContext(), mSensorService.getClass());
        if (!isMyServiceRunning(mSensorService.getClass())) {
            startService(mServiceIntent);
        }


        mButtonStopService = (Button) findViewById(R.id.btn_submit);
        mButtonStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(mServiceIntent);
            }
        });

        mvpVolleyPresenter = new MVPVolleyPresenter(this);
        mvpVolleyPresenter.getDataFromUrl(this, stringUrl);


    }


    @Override
    public void onSuccessListener(String stringMsg, String stringData) {
        //Toast.makeText(getApplicationContext(), stringMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFailureListener(String stringError) {
        //Toast.makeText(getApplicationContext(), stringError, Toast.LENGTH_LONG).show();
    }


    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i("isMyServiceRunning?", true + "");
                return true;
            }
        }
        Log.i("isMyServiceRunning?", false + "");
        return false;
    }


}