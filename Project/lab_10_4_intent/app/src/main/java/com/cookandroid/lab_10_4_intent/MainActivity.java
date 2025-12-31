package com.cookandroid.lab_10_4_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("call phone");

        android.util.Log.i("activity test", "onCreate()");

        Button btnDial = (Button) findViewById(R.id.btnDial);
        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:010-3241-8890");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        Button btnFinsih = (Button) findViewById(R.id.btnFinish);
        btnFinsih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();  android.util.Log.i("activity test", "onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause(); android.util.Log.i("activity test", "onPause()");
    }

    @Override
    protected void onRestart() {
        super.onRestart(); android.util.Log.i("activity test", "onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume(); android.util.Log.i("activity test", "onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart(); android.util.Log.i("activity test", "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop(); android.util.Log.i("activity test", "onStop()");
    }
}