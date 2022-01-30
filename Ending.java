package com.example.ritu_app.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ritu_app.R;

public class Ending extends AppCompatActivity implements View.OnClickListener {

    private Button goLeaderboard;
    private Button goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);
        goLeaderboard=findViewById(R.id.goLeaderboard);
        goHome=findViewById(R.id.goHome);
        goLeaderboard.setOnClickListener(this);
        goHome.setOnClickListener(this);
        TextView txtTitle = findViewById(R.id.textView);
        TextView txtTask = findViewById(R.id.textView2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goLeaderboard:
                Intent intent=new Intent(getApplicationContext(),Leaderboard.class);
                startActivity(intent);
                break;
            case R.id.goHome:
                intent=new Intent(getApplicationContext(),Home.class);
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