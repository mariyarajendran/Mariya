package com.example.iosteam.myfirstconstraints;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class AndroidServices extends JobIntentService {

    Runner runner;
    Handler handler;

    @Override
    public void onCreate() {
        super.onCreate();
        runner = new Runner();
        handler = new Handler();
        Toast.makeText(this, "serviceStarted", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runner);
        Toast.makeText(this, "serviceStoped", Toast.LENGTH_LONG).show();
        Intent broadcastIntent = new Intent(this, SensorRestarterBroadcastReceiver.class);
        sendBroadcast(broadcastIntent);
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.i(AndroidServices.class.getSimpleName(), "android service on handlework");
        handler.post(runner);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        handler.post(runner);
        return START_STICKY;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public class Runner implements Runnable {

        @Override
        public void run() {

            handler.postDelayed(runner, 1000);
            Log.e("service in running", "service in running");
            //Toast.makeText(getApplicationContext(), "running", Toast.LENGTH_SHORT).show();

        }

    }
}
