package com.jv.androidservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart;
    private Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        btnStop = (Button) findViewById(R.id.btnStop);
        btnStop.setOnClickListener(this);
    }

    public void startService() {
        Intent intent = new Intent(getApplicationContext(), ServiceTest.class);
        startService(intent);
    }

    public void stopService() {
        Intent intent = new Intent(getApplicationContext(), ServiceTest.class);
        stopService(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                startService();
                break;

            case R.id.btnStop:
                stopService();
                break;
        }
    }
}
