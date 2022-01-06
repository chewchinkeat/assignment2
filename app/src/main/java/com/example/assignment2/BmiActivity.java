package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BmiActivity extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fitex-48753-default-rtdb.firebaseio.com/");
    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;
    int counter = 0;

    String height;
    String weight;
    float intheight,intweight;
    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);




        intent=getIntent();

        mbmidisplay= findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategory);
        mgender = findViewById(R.id.genderdisplay);
        mbackground = findViewById(R.id.contentlayout);
        mimageview = findViewById(R.id.imageView);



        height= intent.getStringExtra("height");
        weight= intent.getStringExtra("weight");

        intheight= Float.parseFloat(height);
        intweight= Float.parseFloat(weight);

        intheight = intheight/100;

        intbmi = intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);


        String username = getIntent().getStringExtra("user3");

        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.child("users").child(username).child("bmi").setValue(mbmi);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        if(intbmi<16)
        {
            mbmicategory.setText("You are severe thinness");
            mbackground.setBackgroundColor(Color.RED);
        }
        else if(intbmi<16.9 && intbmi>=16 )
        {
            mbmicategory.setText("You are moderate thinness");
            mbackground.setBackgroundColor(Color.RED);
        }
        else if(intbmi<18.4 && intbmi>=17 )
        {
            mbmicategory.setText("You are mild thinness");
            mbackground.setBackgroundColor(Color.RED);
        }
        else if(intbmi<25 && intbmi>=18.4 )
        {
            mbmicategory.setText("You are normal congrats");
            mbackground.setBackgroundColor(Color.YELLOW);
        }
        else if(intbmi<29.4 && intbmi>=25 )
        {
            mbmicategory.setText("You are overweight");
            mbackground.setBackgroundColor(Color.RED);
        }
        else
        {
            mbmicategory.setText("You are obese");
            mbackground.setBackgroundColor(Color.RED);
        }

        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);

    }
}