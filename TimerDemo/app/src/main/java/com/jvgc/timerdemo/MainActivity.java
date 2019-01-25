package com.jvgc.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final int INTERVAL = 1000;
    private static final int DURATION = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fixed duration timer
        new CountDownTimer(DURATION, INTERVAL) {

            @Override
            public void onTick(long milliseconds) {
                Log.d("TimerDemo", "CountDownTimer...");
            }

            @Override
            public void onFinish() {
                Log.d("TimerDemo", "CountDownTimer is over!");
            }
        }.start();

        // Endless timer
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {

            @Override
            public void run() {
                Log.d("TimerDemo", "Runnable...");
                handler.postDelayed(this, INTERVAL);
            }
        };

        handler.post(runnable);
    }
}
