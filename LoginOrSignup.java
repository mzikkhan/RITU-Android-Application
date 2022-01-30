package com.example.ritu_app.first;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ritu_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginOrSignup extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton;
    private TextView signUpButton,forgotPassword,loginStat;
    private EditText loginEmail,loginPassword;
    private ProgressBar loginProgressBar;
    Player player = Player.getObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginorsignup);
        signUpButton=findViewById(R.id.signupButton);
        loginButton=findViewById(R.id.loginButton);
        signUpButton.setOnClickListener(this);
        loginButton.setOnClickListener(this);
        loginEmail=findViewById(R.id.getEmailForLogin);
        loginPassword=findViewById(R.id.getPassForLogin);
        loginProgressBar=findViewById(R.id.loginprogressBar);
        forgotPassword=findViewById(R.id.forgotPassword);
        loginStat=findViewById(R.id.loginStatus);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signupButton:
                Intent intent=new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
                break;
            case R.id.loginButton:
                //Calling the function for user login
                userLogin();
                break;

        }

    }

    private void userLogin(){
        String mail=loginEmail.getText().toString().trim();
        String pass=loginPassword.getText().toString().trim();
        player.setPlayerEmail(mail);
        player.setPlayerPassword(pass);

        FirebaseAuth loginAuth = FirebaseAuth.getInstance();
        if(mail.isEmpty()){
            loginEmail.setError("You must enter the Email ID!");
            loginEmail.requestFocus();
            return;
        }
        if(pass.isEmpty()){
            loginPassword.setError("You must Enter the password");
            loginPassword.requestFocus();
            return;
        }
        loginProgressBar.setVisibility(View.VISIBLE);


        Task<AuthResult> task = loginAuth.signInWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent goToHome=new Intent(getApplicationContext(), Home.class);
                    startActivity(goToHome);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Login Unsuccessful", Toast.LENGTH_SHORT).show();
                    forgotPassword.setVisibility(View.VISIBLE);
                    loginStat.setText("Wrong Credentials!");
                    loginStat.setVisibility(View.VISIBLE);

                    loginProgressBar.setVisibility(View.GONE);
                }
            }
        });

    }
}