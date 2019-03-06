package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends Activity {
    protected static final String EXTRA_RET = "com.example.myapplication.EXTRA_RET";
    protected static final String DEFAULT = "Default Bye";

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

        if(numRep == 0 || message.isEmpty()){
            TextView textView1 = findViewById(R.id.textView1);
            textView1.setText(DEFAULT);
        }else {
            message = new String(new char[numRep]).replace("\0", message);
            TextView textView1 = findViewById(R.id.textView1);
            textView1.setText(message);
        }
    }

    public void openWelcome(){
        Intent intent = new Intent(this, MainActivity.class);
        TextView text = findViewById(R.id.textView1);
        intent.putExtra(EXTRA_RET, text.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}
