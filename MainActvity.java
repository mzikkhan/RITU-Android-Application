package com.example.ritu_app.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ritu_app.R;
import android.app.Activity;

public class MainActvity extends AppCompatActivity implements View.OnClickListener {

    private Button playButton;
    private TextView ritu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.playButton:
                Intent intent = new Intent(getApplicationContext(), LoginOrSignup.class);
                startActivity(intent);
                break;
        }

    }


}