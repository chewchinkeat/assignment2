package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText emailid, password;
    Button signinbtn;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailid = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        signinbtn = findViewById(R.id.button);
        tvSignUp = findViewById(R.id.textView);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(Login.this, "Login successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Please login", Toast.LENGTH_SHORT).show();
                }

            }
        };

        signinbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailid.getText().toString();
                String passw = password.getText().toString();
                if (email.isEmpty()) {
                    emailid.setError("Please enter your email");
                    emailid.requestFocus();
                } else if (passw.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && passw.isEmpty()) {
                    Toast.makeText(Login.this, "The fields are empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && passw.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "Please login again", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intToHome = new Intent(Login.this, MainActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                } else {
                    Toast.makeText(Login.this, "Error has occurred!", Toast.LENGTH_SHORT).show();

                }
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSignUp = new Intent(Login.this, MainActivity.class);
                startActivity(intSignUp);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}