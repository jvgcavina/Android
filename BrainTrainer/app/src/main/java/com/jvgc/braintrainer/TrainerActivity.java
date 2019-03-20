package com.jvgc.braintrainer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TrainerActivity extends AppCompatActivity implements View.OnClickListener {

    // Constrants
    private static final int FINAL_RANDOM_RANGE = 21;
    private static final int NUM_OF_OPTIONS = 4;
    private static final int EMPTY_OPTION = -1;
    private static final int OPTION_A_IDX = 0;
    private static final int OPTION_B_IDX = 1;
    private static final int OPTION_C_IDX = 2;
    private static final int OPTION_D_IDX = 3;
    private static final String NUMBER_TEXT_FORMAT = "%02d";
    private static final String NUMBER_TIME_FORMAT = "%02d s";
    private static final int TIME_TO_ANSWER = 30100;
    private static final int TIME_STEP_DURATION = 1000;

    // Views
    private TextView mRemainingTime;
    private TextView mScore;
    private TextView mExpression;
    private TextView mResult;
    private Button mOptionA;
    private Button mOptionB;
    private Button mOptionC;
    private Button mOptionD;
    private Button mPlayAgain;

    // Variables
    private int mExpressionResult;
    private int mTotalTests;
    private int mTotalHits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);

        initViews();

        resetTraining();
    }

    @Override
    public void onClick(View view) {
        if ((Integer)view.getTag() == mExpressionResult) {
            mResult.setText(getString(R.string.correct));
            mTotalHits++;
        } else {
            mResult.setText(getString(R.string.wrong));
        }

        mTotalTests++;
        refreshTraining();
    }

    private void initViews() {
        mRemainingTime = findViewById(R.id.tvRemaingTime);
        mScore = findViewById(R.id.tvScore);
        mExpression = findViewById(R.id.tvExpression);
        mResult = findViewById(R.id.tvResult);
        mOptionA = findViewById(R.id.btnOptionA);
        mOptionB = findViewById(R.id.btnOptionB);
        mOptionC = findViewById(R.id.btnOptionC);
        mOptionD = findViewById(R.id.btnOptionD);
        mPlayAgain = findViewById(R.id.btnPlayAgain);

        // Set listeners
        mOptionA.setOnClickListener(this);
        mOptionB.setOnClickListener(this);
        mOptionC.setOnClickListener(this);
        mOptionD.setOnClickListener(this);

        mPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayAgain.setVisibility(View.GONE);

                resetTraining();
            }
        });
    }

    private void refreshTraining() {
        final Random random = new Random();
        final int[] options = new int[NUM_OF_OPTIONS];

        // Generate two new random numbers
        int firstValue = random.nextInt(FINAL_RANDOM_RANGE);
        int secondValue = random.nextInt(FINAL_RANDOM_RANGE);

        // Update expression
        mExpressionResult = firstValue + secondValue;
        mExpression.setText(String.format(Locale.getDefault(),
                NUMBER_TEXT_FORMAT + " + " + NUMBER_TEXT_FORMAT, firstValue, secondValue));

        // Reset options array
        for (int i = 0; i < NUM_OF_OPTIONS; i++) {
            options[i] = EMPTY_OPTION;
        }

        // Sets the correct result in an aleatory position on options array
        options[random.nextInt(NUM_OF_OPTIONS)] = mExpressionResult;

        // Generates random values to the other positions on options array
        for (int i = 0; i < NUM_OF_OPTIONS; i++) {
            if (options[i] == EMPTY_OPTION) {
                firstValue = random.nextInt(FINAL_RANDOM_RANGE);
                secondValue = random.nextInt(FINAL_RANDOM_RANGE);
                final int sum = firstValue + secondValue;
                options[i] = sum != mExpressionResult ? sum : firstValue;
            }
        }

        // Update answer buttons
        mOptionA.setText(String.format(Locale.getDefault(), NUMBER_TEXT_FORMAT,
                options[OPTION_A_IDX]));
        mOptionA.setTag(options[OPTION_A_IDX]);

        mOptionB.setText(String.format(Locale.getDefault(), NUMBER_TEXT_FORMAT,
                options[OPTION_B_IDX]));
        mOptionB.setTag(options[OPTION_B_IDX]);

        mOptionC.setText(String.format(Locale.getDefault(), NUMBER_TEXT_FORMAT,
                options[OPTION_C_IDX]));
        mOptionC.setTag(options[OPTION_C_IDX]);

        mOptionD.setText(String.format(Locale.getDefault(), NUMBER_TEXT_FORMAT,
                options[OPTION_D_IDX]));
        mOptionD.setTag(options[OPTION_D_IDX]);

        // Update score
        mScore.setText(String.format(Locale.getDefault(),
                NUMBER_TEXT_FORMAT + " / " + NUMBER_TEXT_FORMAT, mTotalHits, mTotalTests));
    }

    private void resetTraining() {
        mTotalTests = 0;
        mTotalHits = 0;

        mResult.setText(null);

        // Set count down timer
        CountDownTimer countDownTimer = new CountDownTimer(TIME_TO_ANSWER, TIME_STEP_DURATION) {
            @Override
            public void onTick(long millisUntilFinished) {
                mRemainingTime.setText(String.format(Locale.getDefault(), NUMBER_TIME_FORMAT,
                        TimeUnit.SECONDS.convert(millisUntilFinished, TimeUnit.MILLISECONDS)));
            }

            @Override
            public void onFinish() {
                mOptionA.setEnabled(false);
                mOptionB.setEnabled(false);
                mOptionC.setEnabled(false);
                mOptionD.setEnabled(false);

                mPlayAgain.setVisibility(View.VISIBLE);
            }
        };

        countDownTimer.start();

        mOptionA.setEnabled(true);
        mOptionB.setEnabled(true);
        mOptionC.setEnabled(true);
        mOptionD.setEnabled(true);

        refreshTraining();
    }
}
