package com.android.jv.savedstate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private ArrayList<Bitmap> images = new ArrayList<Bitmap>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            ListImages lst = (ListImages) savedInstanceState.getSerializable("key");
            images = lst.images ;
        }
        if (images == null || images.size() == 0) {
            loadImages();
        } else {
            buildImages();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("key", new ListImages(images));
    }

    public void loadImages() {
        Log.i("TAG", "Baixando imagens...");
        new Thread() {
            public void run() {
                try {
                    for (int i = 0; i < 30; i++) {

                        URL url = new URL("http://www.thiengo.com.br/img/system/logo/thiengo-80-80.png");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        InputStream input = connection.getInputStream();
                        images.add(BitmapFactory.decodeStream(input));
                    }
                } catch (Exception e) {

                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        buildImages();
                    }
                });
            }
        }.start();
    }

    public void buildImages() {
        Log.i("TAG", "Building images...");
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);

        for (int i = 0; i < images.size(); i++) {
            ImageView iv = new ImageView(getBaseContext());
            iv.setImageBitmap(images.get(i));
            ll.addView(iv);
        }
    }
}
