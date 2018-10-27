package com.jvgc.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    @Override
    public void onClick(View view) {
        Log.i("BP", "Button pressed: " + view.getTag().toString());
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                getResources().getIdentifier(view.getTag().toString(), "raw",
                        getPackageName()));
        mediaPlayer.start();
    }

    private void initViews() {
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        Log.i("BP", "Number of buttons: " + gridLayout.getChildCount());

        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            Button button = (Button) gridLayout.getChildAt(i);
            button.setOnClickListener(this);
            Log.i("BP", "setOnClickListener at button " + (i + 1));
        }
    }
}
