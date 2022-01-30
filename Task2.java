package com.example.ritu_app.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ritu_app.R;

public class Task2 extends AppCompatActivity implements View.OnClickListener {

    private Button continueButton;
    private Button goHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);
        continueButton=findViewById(R.id.continueButton);
        goHomeButton=findViewById(R.id.goHomeButton);
        continueButton.setOnClickListener(this);
        goHomeButton.setOnClickListener(this);
        TextView txtTitle = findViewById(R.id.textView);
        TextView txtTask = findViewById(R.id.textView2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.continueButton:
                Intent intent=new Intent(getApplicationContext(),Submission2.class);
                startActivity(intent);
                break;
            case R.id.goHomeButton:
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