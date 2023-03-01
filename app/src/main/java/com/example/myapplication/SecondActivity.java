package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = (Button) findViewById(R.id.main_button_second_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToMain(view);
            }
        });

        Bundle arguments = getIntent().getExtras();
        if (arguments != null){
            String city = arguments.get("city").toString();
            TextView textView = findViewById(R.id.textView);
            textView.setText("Ваш город: " + city);
            setResult(1);
        }
    }

    public void goToMain(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Log.i(TAG, "переход на MainActivity");
    }
}