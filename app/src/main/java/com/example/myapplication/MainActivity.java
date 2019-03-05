package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

//public class MainActivity extends Activity {
public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MSG = "com.example.myapplication.EXTRA_MSG";
    public static final String EXTRA_NUM = "com.example.myapplication.EXTRA_NUM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button actionButton = findViewById(R.id.button);
        actionButton.setOnClickListener(new Toaster());

    }

    private class Toaster implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            openGoodbye();
        }

        public void openGoodbye(){
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            EditText editText1 = findViewById(R.id.editText);
            String message = editText1.getText().toString();
            EditText editText2 = findViewById(R.id.editText2);

            try {
                int numRep = Integer.parseInt(editText2.getText().toString());
                intent.putExtra(EXTRA_NUM, numRep);
            }catch (NumberFormatException e1) {}

            intent.putExtra(EXTRA_MSG, message);

            startActivity(intent);
        }
    }
}
