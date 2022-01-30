package com.example.ritu_app.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ritu_app.R;
import android.app.Activity;
public class Home extends AppCompatActivity implements View.OnClickListener {

    private Button playGame;
    private Button goLeaderboard;
    private Button goInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        playGame=findViewById(R.id.playGame);
        playGame.setOnClickListener(this);
        goLeaderboard=findViewById(R.id.goLeaderboard);
        goLeaderboard.setOnClickListener(this);
        goInstructions=findViewById(R.id.goInstructions);
        goInstructions.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playGame:
                Intent intent=new Intent(getApplicationContext(),Task1.class);
                startActivity(intent);
                break;
            case R.id.goLeaderboard:
                intent=new Intent(getApplicationContext(),Leaderboard.class);
                startActivity(intent);
                break;
            case R.id.goInstructions:
                intent=new Intent(getApplicationContext(),Instructions.class);
                startActivity(intent);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}