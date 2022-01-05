package com.example.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {
    EditText username, password;
    Button registerBtn;
    TextView loginNowBtn;

    //creating object to access realtime database
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fitex-48753-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.editTextTextUsername);
        password = findViewById(R.id.editTextTextPassword);
        registerBtn = findViewById(R.id.button);
        loginNowBtn = findViewById(R.id.textView2);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get data from Edittext
                final String usernameTxt = username.getText().toString();
                final String passwordTxt = password.getText().toString();

                //Ensure user fill in all the data
                if(usernameTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(SignUp.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                }else{

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //check if username is not registered before
                            if(snapshot.hasChild(usernameTxt)){
                                Toast.makeText(SignUp.this, "This username is already registered", Toast.LENGTH_SHORT).show();
                            }else{
                                // send data to database

                                databaseReference.child("users").child(usernameTxt).child("password").setValue(passwordTxt);

                                Toast.makeText(SignUp.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignUp.this, Login.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });

    }
}