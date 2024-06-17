package com.example.activitytest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FirstActivity extends BaseActivity implements View.OnClickListener{

    private ImageView imageView;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layerout);
        Button button1 = (Button) findViewById(R.id.button_1);
        Log.d("FirstActivity", "TaskId is " + getTaskId());
        /*
        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        button1.setOnClickListener(this);
        imageView = (ImageView)findViewById(R.id.image_view);
         */

        /*
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.add_item){
            Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId()==R.id.remove_item){
            Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button_1){
            /*
            AlertDialog.Builder dialog = new AlertDialog.Builder(FirstActivity.this);
            dialog.setTitle("This is a dialog");
            dialog.setMessage("Something Important");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }

            });
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            */

            ProgressDialog progressDialog = new ProgressDialog(FirstActivity.this);
            progressDialog.setTitle("This is a dialog");
            progressDialog.setMessage("Something Important");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }
}