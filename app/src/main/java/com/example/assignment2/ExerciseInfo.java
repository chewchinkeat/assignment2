package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ExerciseInfo extends AppCompatActivity {

    String button_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_info);


        Intent intent = getIntent();
        button_value = intent.getStringExtra("value");

        int integervalue = Integer.valueOf(button_value);

        switch (integervalue){

            case 1:
                setContentView(R.layout.activity_exercise1);
                break;
            case 2:
                setContentView(R.layout.activity_exercise2);
                break;
            case 3:
                setContentView(R.layout.activity_exercise3);
                break;
            case 4:
                setContentView(R.layout.activity_exercise4);
                break;
            case 5:
                setContentView(R.layout.activity_exercise5);
                break;
            case 6:
                setContentView(R.layout.activity_exercise6);
                break;
            case 7:
                setContentView(R.layout.activity_exercise7);
                break;
            case 8:
                setContentView(R.layout.activity_exercise8);
                break;
            case 9:
                setContentView(R.layout.activity_exercise9);
                break;
            case 10:
                setContentView(R.layout.activity_exercise10);
                break;
            case 11:
                setContentView(R.layout.activity_exercise11);
                break;
            case 12:
                setContentView(R.layout.activity_exercise12);
                break;



        }
    }
}
