package com.example.ritu_app.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ritu_app.R;

public class Submission2 extends AppCompatActivity implements View.OnClickListener {

    private Button goTaskBtn;
    private Button submitBtn;
    private EditText url2;
    Player player = Player.getObject();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission2);
        goTaskBtn=findViewById(R.id.goTaskBtn);
        submitBtn=findViewById(R.id.submitBtn);
        goTaskBtn.setOnClickListener(this);
        submitBtn.setOnClickListener(this);
        TextView txtTitle = findViewById(R.id.textView);
        TextView txtTask = findViewById(R.id.textView2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.goTaskBtn:
                Intent intent=new Intent(getApplicationContext(),Task2.class);
                startActivity(intent);
                break;
            case R.id.submitBtn:
                String url = url2.getText().toString().trim();
                player.setTask2(url);
                player.setPoints(100);
                intent=new Intent(getApplicationContext(),Task3.class);
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