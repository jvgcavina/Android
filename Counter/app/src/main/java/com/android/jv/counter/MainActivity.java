package com.android.jv.counter;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int count;
    private TextView tvCount;
    private ImageView ivZero;
    private ImageView ivIncrease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = (TextView) findViewById(R.id.tvResult);
        ivZero = (ImageView) findViewById(R.id.ivZero);
        ivZero.setOnClickListener(this);
        ivIncrease = (ImageView) findViewById(R.id.ivIncrease);
        ivIncrease.setOnClickListener(this);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("counter");
        } else {
            count = 0;
        }
        tvCount.setText(count + "");
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);

        bundle.putInt("counter", count);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ivZero:
                count = 0;
                tvCount.setText(count + "");
                break;

            case R.id.ivIncrease:
                count++;
                tvCount.setText(count + "");
                break;
        }
    }
}
