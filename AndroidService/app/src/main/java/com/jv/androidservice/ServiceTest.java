package com.jv.androidservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by josevictor on 09/10/2018.
 */

public class ServiceTest extends Service {

    public List<Worker> threads = new ArrayList<>();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("Service Worker", "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Service Worker", "onStartCommand()");
        Worker worker = new Worker(startId);
        worker.start();
        threads.add(worker);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).active = false;
        }
        Log.i("Service Worker", "onDestroy()");
    }

    class Worker extends Thread {
        public int count = 0;
        public int startId;
        public boolean active = true;

        public Worker(int startId) {
            this.startId = startId;
        }

        @Override
        public void run() {
            while (active && count < 20 ) {
                try {
                 Thread.sleep(1000);
                } catch (InterruptedException e) {
                 e.printStackTrace();
                }
                count++;
                Log.i("Service Worker", "Start ID: " + startId + " Count: " + count);
            }
            stopSelf(startId );
            Log.i("Service Worker", "Start ID: " + startId + " Thread finished!");
        }
    }
}
