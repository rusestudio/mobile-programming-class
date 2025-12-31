package com.cookandroid.layout_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams( //make bg layout
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.rgb(0,255,0));
        setContentView(baseLayout,params);

        //page 25-26
        //make button
        Button btn = new Button(this); //make button and declare details
        btn.setText("this is button");
        btn.setBackgroundColor(Color.MAGENTA);
        baseLayout.addView(btn); //add button to the layout/screen must!

        //add eventlistener button
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Toast.makeText(getApplicationContext(),
                        "button made by java code", Toast.LENGTH_SHORT).show();
            }
        });

        //page 27
        //edit text
        EditText edittxt = new EditText(this);
        edittxt.setHint("enter here");
        baseLayout.addView(edittxt);

        //button

        //text view

    }
}