package com.jvgc.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private static final int TIMES_TABLE_ONE = 1;
    private static final int TIMES_TABLE_FIRST_ELEMENT = 1;
    private static final int TIMES_TABLE_LAST_ELEMENT = 10;

    private SeekBar mSeekBar;
    private ListView mListView;
    private List<Integer> mResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize members
        mSeekBar = findViewById(R.id.seekBar);
        mSeekBar.setOnSeekBarChangeListener(this);
        mSeekBar.setProgress(TIMES_TABLE_ONE);
        mListView = findViewById(R.id.listView);
        mResults = new ArrayList<>();

        // Add 1 times table to list
        updateListOfResults(TIMES_TABLE_ONE);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        // Add i times table to list
        updateListOfResults(i);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void updateListOfResults(int i) {
        mResults.clear();

        // Calc all elements of i times table
        for (int j = TIMES_TABLE_FIRST_ELEMENT; j <= TIMES_TABLE_LAST_ELEMENT; j++) {
            mResults.add(j * i);
        }

        // Initialize array adapter for listview
        ArrayAdapter<Integer> arrayAdapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mResults);

        // Set adapter on listview
        mListView.setAdapter(arrayAdapter);
    }
}
