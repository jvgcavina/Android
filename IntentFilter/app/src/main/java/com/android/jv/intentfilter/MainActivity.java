package com.android.jv.intentfilter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnIntentAction;
    private Button btnIntentActionCategory;
    private Button btnIntentActionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntentAction = (Button) findViewById(R.id.btnIntentAction);
        btnIntentActionCategory = (Button) findViewById(R.id.btnIntentActionCategory);
        btnIntentActionView = (Button) findViewById(R.id.btnIntentActionView);

        btnIntentAction.setOnClickListener(this);
        btnIntentActionCategory.setOnClickListener(this);
        btnIntentActionView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.btnIntentAction:
                intent = new Intent("ACTION_SCREEN");
                startActivity(intent);
                break;

            case R.id.btnIntentActionCategory:
                intent = new Intent("ACTION_SCREEN");
                intent.addCategory("SCREEN_CATEGORY");
                startActivity(intent);
                break;

            case R.id.btnIntentActionView:
                Uri uri = Uri.parse("http://www.xnxx.com");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;
        }
    }
}
