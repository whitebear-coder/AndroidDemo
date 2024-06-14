package com.example.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button start = (Button) findViewById(R.id.start_service);
        Button stop = (Button) findViewById(R.id.stop_service);
        
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

        Button bind = (Button) findViewById(R.id.bind_service);
        Button unbind = (Button) findViewById(R.id.unbind_service);

        bind.setOnClickListener(this);
        bind.setOnClickListener(this);

        Button startIntentService = (Button) findViewById(R.id.start_intent_service);
        startIntentService.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.start_service){
            Intent startIntent = new Intent(this, MyService.class);
            startService(startIntent);
        } else if (v.getId()==R.id.stop_service) {
            Intent stopIntent = new Intent(this, MyService.class);
            stopService(stopIntent);
        } else if (v.getId()==R.id.bind_service) {
            Intent intent = new Intent(this, MyService.class);
            bindService(intent, connection, BIND_AUTO_CREATE); //绑定服务
        } else if (v.getId()==R.id.unbind_service) {
            unbindService(connection);
        } else if(v.getId()==R.id.start_intent_service){
            Log.d("MainActivity", "Thread id is" + Thread.currentThread().getId());
            Intent intent = new Intent(this, MyIntentService.class);
            startService(intent);
        }
    }
}