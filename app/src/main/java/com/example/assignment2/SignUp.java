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

public class SignUp extends AppCompatActivity {
    EditText emailid, password;
    Button signupbtn;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailid = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        signupbtn = findViewById(R.id.button);
        tvSignIn = findViewById(R.id.textView);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailid.getText().toString();
                String passw = password.getText().toString();
                if(email.isEmpty()){
                    emailid.setError("Please enter your email");
                    emailid.requestFocus();
                }else if(passw.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }else if(email.isEmpty() && passw.isEmpty()){
                    Toast.makeText(SignUp.this, "The fields are empty!",Toast.LENGTH_SHORT).show();
                }else if(!(email.isEmpty() && passw.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(SignUp.this, "Sign up unsuccessful. Please try again.",Toast.LENGTH_SHORT).show();
                            }else{
                                startActivity(new Intent(SignUp.this, MainActivity.class));
                            }
                        }
                    });
                }else{
                    Toast.makeText(SignUp.this, "Error has occurred!",Toast.LENGTH_SHORT).show();

                }
            }
        });

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

    }
}