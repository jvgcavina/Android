package com.jvgc.basiclistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        final List<String> myFriends = new ArrayList<>();
        myFriends.add("Tiago");
        myFriends.add("Anthony");
        myFriends.add("Pedro");
        myFriends.add("Sérgio");

        ArrayAdapter<String> arrayAdapter
                = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myFriends);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(this.getClass().getName(), "Friend selected: " + myFriends.get(i));
                Toast.makeText(getApplicationContext(), "Friend selected: " + myFriends.get(i),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
