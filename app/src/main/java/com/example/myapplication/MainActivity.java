package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.d(TAG, "onActivityResult");
                    if (result.getResultCode() == 1){
                        TextView textView = findViewById(R.id.textView7);
                        textView.setText("Успешно");
                    }
                }
            }
    );

    public void goToSecond(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
        Log.i(TAG, "переход на SecondActivity");
    }

    public void sendCity(View v){
        Intent intent = new Intent(this , SecondActivity.class);
        EditText cityText = findViewById(R.id.input_name);
        String city = cityText.getText().toString();
        intent.putExtra("city" , city);
        activityResultLauncher.launch(intent);
    }


}