package com.example.myapplication;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
//public class MainActivity extends AppCompatActivity {
    protected static final String EXTRA_MSG = "com.example.myapplication.EXTRA_MSG";
    protected static final String EXTRA_NUM = "com.example.myapplication.EXTRA_NUM";
    protected static final String HELLO = "Hello World!";
    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //System.out.println("Create");

    }

    @Override
    protected void onStart(){
        super.onStart();
        //System.out.println("Start");
        Button actionButton = findViewById(R.id.button);
        actionButton.setOnClickListener(new Toaster());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                String msg = intent.getStringExtra(Activity2.EXTRA_RET);
                TextView textView = findViewById(R.id.textView2);
                if(!msg.equals(Activity2.DEFAULT)) textView.setText(msg);
                else textView.setText(HELLO);
                editText1.getText().clear();
                editText2.getText().clear();
            }
        }
    }

    private class Toaster implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            openGoodbye();
        }

        public void openGoodbye(){
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            editText1 = findViewById(R.id.editText);
            String message = editText1.getText().toString();
            editText2 = findViewById(R.id.editText2);

            try {
                int numRep = Integer.parseInt(editText2.getText().toString());
                intent.putExtra(EXTRA_NUM, numRep);
            }catch (NumberFormatException e1) {}

            intent.putExtra(EXTRA_MSG, message);

            startActivityForResult(intent, 1);
        }
    }
}
