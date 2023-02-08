package com.example.pet_store;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.widget.TextView textView = (TextView) findViewById(R.id.textView);
        mButton = (Button) findViewById(R.id.button);


    }

    public void onClick(View view) {
        mButton.setVisibility(View.VISIBLE);



    }
}

