package com.example.ritu_app.first;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ritu_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText getNameforsignup;
    private EditText getMailforsignup;
    private EditText getpasswordforsignup;
    private Button signUpconfirmButton;
    private ProgressBar signUpProgress;
    //Firebase Connection
    private FirebaseAuth signupAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getNameforsignup=findViewById(R.id.getName);
        getMailforsignup=findViewById(R.id.getMailId);
        getpasswordforsignup=findViewById(R.id.passwordField);
        signUpconfirmButton=findViewById(R.id.signUpConfirmationButton);
        signUpProgress=findViewById(R.id.signupProgressBar);
        signUpconfirmButton.setOnClickListener(this);


        //Firebase Work
        signupAuth=FirebaseAuth.getInstance();

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signUpConfirmationButton:
                userRegister();
                break;
        }
    }
    private void userRegister() {
        String email = getMailforsignup.getText().toString().trim();
        String name = getNameforsignup.getText().toString().trim();

        String password = getpasswordforsignup.getText().toString().trim();
        //Check Validity and Nullity of the Email
        if (email.isEmpty()) {
            getMailforsignup.setError("You must Enter an Email ID");
            getMailforsignup.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            getMailforsignup.setError("Enter a valid Email address!");
            getMailforsignup.requestFocus();
            return;
        }

        //Check Validity of the name
        if (name.isEmpty()) {
            getNameforsignup.setError("You must Enter your name!");
            getNameforsignup.requestFocus();
            return;
        }

        //check Validity of Number
        if (password.isEmpty()) {
            getpasswordforsignup.setError("You must Enter a password");
            getpasswordforsignup.requestFocus();
            return;
        }
        signUpProgress.setVisibility(View.VISIBLE);

        //Creating user in Firebase
        signupAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                signUpProgress.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(getApplicationContext(), "Registration is successful", Toast.LENGTH_SHORT).show();
                } else {
                    //If user already exist:
                    if(task.getException()instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(),"An user is already registered with this credential!",Toast.LENGTH_SHORT).show();
                    }



                    // If sign in fails, display a message to the user.


                    Toast.makeText(getApplicationContext(), "Registration is unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}