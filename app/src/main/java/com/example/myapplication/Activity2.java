package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goodbye_screen);

        Button actionButton = findViewById(R.id.button2);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcome();
            }
        });
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MSG);
        int numRep = intent.getIntExtra(MainActivity.EXTRA_NUM, 0);

        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText(new String(new char[numRep]).replace("\0", message));
    }

    public void openWelcome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
