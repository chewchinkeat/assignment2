package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class BeginnerActivity extends AppCompatActivity {

    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newArray = new int[]{

                R.id.exercise1_pose, R.id.exercise2_pose,R.id.exercise3_pose,R.id.exercise4_pose,R.id.exercise5_pose,R.id.exercise6_pose,
                R.id.exercise7_pose,R.id.exercise8_pose,R.id.exercise9_pose,R.id.exercise10_pose,R.id.exercise11_pose,R.id.exercise12_pose,

        };
    }

    public void Imagebuttonclicked(View view) {

        for(int i = 0; i < newArray.length; i++){
            if(view.getId() == newArray[i]){

                int value = i + 1;
                Log.i("FIRST", String.valueOf(value));
                Intent intent = new Intent(BeginnerActivity.this, ExerciseInfo.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);

            }
        }
    }
}