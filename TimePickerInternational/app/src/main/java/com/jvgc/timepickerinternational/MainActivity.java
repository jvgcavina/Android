package com.jvgc.timepickerinternational;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String SDF_24H = "HH:mm";
    private static final String SDF_12H = "hh:mm aa";

    private Button mInitialTimeButton;
    private Button mFinalTimeButton;
    private TextView mInitialTimeText;
    private TextView mFinalTimeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_initial_time:
                selectTime(mInitialTimeText);
                break;
            case R.id.btn_final_time:
                selectTime(mFinalTimeText);
                break;
        }
    }

    private void initViews() {
        mInitialTimeButton = (Button) findViewById(R.id.btn_initial_time);
        mInitialTimeButton.setOnClickListener(this);
        mFinalTimeButton = (Button) findViewById(R.id.btn_final_time);
        mFinalTimeButton.setOnClickListener(this);
        mInitialTimeText = (TextView) findViewById(R.id.tv_initial_time);
        mFinalTimeText = (TextView) findViewById(R.id.tv_final_time);
    }

    private void selectTime(final TextView label) {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minute = Calendar.getInstance().get(Calendar.MINUTE);

        TimePickerDialog.OnTimeSetListener timeSetListener
                = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                label.setText(formatTime(selectedHour, selectedMinute,
                        DateFormat.is24HourFormat(getApplicationContext())));
            }
        };

        new TimePickerDialog(this, AlertDialog.THEME_HOLO_LIGHT, timeSetListener, hour,
                minute, DateFormat.is24HourFormat(this)).show();
    }

    private String formatTime(int hour, int minute, boolean is24HourFormat) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        String sdf = is24HourFormat ? SDF_24H : SDF_12H;

        Log.i("TPI", "Hour: " + hour);
        Log.i("TPI", "Minute: " + minute);
        Log.i("TPI", "is24HourFormat: " + is24HourFormat);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(sdf);

        return simpleDateFormat.format(calendar.getTime());
    }
}
