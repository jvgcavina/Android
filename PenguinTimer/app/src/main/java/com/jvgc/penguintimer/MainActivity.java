package com.jvgc.penguintimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private static final String TAG = "PenguinTimer";

    private static final int MAX_SECONDS = 900;
    private static final int INITIAL_TIME = 30;
    private static final int SECONDS_IN_MINUTE = 60;
    private static final long TIMER_STEP = 1000;

    private SeekBar mTimerSeekBar;
    private TextView mTimerTextView;
    private Button mTimerButton;
    private CountDownTimer mCountDownTimer;
    private boolean mIsStartButton = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate views
        mTimerSeekBar = findViewById(R.id.timerSeekBar);
        mTimerTextView = findViewById(R.id.timerTextView);
        mTimerButton = findViewById(R.id.timerButton);

        // Set initial values
        mTimerSeekBar.setMax(MAX_SECONDS);
        mTimerSeekBar.setProgress(INITIAL_TIME);

        // Set listeners
        mTimerSeekBar.setOnSeekBarChangeListener(this);
        mTimerButton.setOnClickListener(this);

        // Set initial timer's value on TextView
        updateTimerValue(mTimerSeekBar.getProgress());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        updateTimerValue(i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {
        if (mIsStartButton) {
            startTimer();
        } else {
            stopTimer();
            resetTimer();
        }
    }

    /**
     * Starts timer and update button state.
     */
    private void startTimer() {
        // Get time in milliseconds
        long remainingTime = mTimerSeekBar.getProgress() * TIMER_STEP;
        Log.d(TAG, "Start time: " + remainingTime);

        // Starts the timer
        mCountDownTimer = new CountDownTimer(remainingTime, TIMER_STEP) {
            @Override
            public void onTick(long l) {
                updateTimerValue((int) (l / TIMER_STEP));
            }

            @Override
            public void onFinish() {
                playTimerAlert();
                resetTimer();
            }
        };
        mCountDownTimer.start();

        // Disable SeekBar during count down
        mTimerSeekBar.setEnabled(false);

        // If "start" button is pressed, change text from start to stop
        mTimerButton.setText(getResources().getString(R.string.stop));
        mIsStartButton = false;

        Log.d(TAG, "Timer started!");
    }

    /**
     * Stops timer.
     */
    private void stopTimer() {
        // Stops the timer
        mCountDownTimer.cancel();

        Log.d(TAG, "Timer stopped!");
    }

    /**
     * Resets timer and update button state.
     */
    private void resetTimer() {
        // Set button's text as start
        mTimerButton.setText(getResources().getString(R.string.start));
        mIsStartButton = true;

        // Enable SeekBar when count down is stopped
        mTimerSeekBar.setEnabled(true);

        updateTimerValue(mTimerSeekBar.getProgress());

        Log.d(TAG, "Timer reseted!");
    }

    private void playTimerAlert() {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.alarm_sound);
        mediaPlayer.start();
    }

    /**
     * Updates timer's value on screen.
     * @param seconds_amount Integer containing the amount of seconds to be converted
     *                       in MM:ss format
     */
    private void updateTimerValue(int seconds_amount) {
        int minutes = seconds_amount / SECONDS_IN_MINUTE;
        int seconds = seconds_amount - (minutes * SECONDS_IN_MINUTE);

        final String time = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTimerTextView.setText(time);
    }
}
