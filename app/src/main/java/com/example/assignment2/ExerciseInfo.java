package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExerciseInfo extends AppCompatActivity {

    String button_value;
    Button startbutton;
    private CountDownTimer countDownTimer;
    TextView min_textview;
    private boolean mTimeRunning;
    private long mTimeMillisLeft;

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

        startbutton = findViewById(R.id.start_button);
        min_textview = findViewById(R.id.button_time);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mTimeRunning){

                    timeStop();

                }else{

                    timeStart();

                }

            }
        });

    }

    private void timeStop(){

        countDownTimer.cancel();
        mTimeRunning = false;
        startbutton.setText("START");

    }

    private void timeStart(){

        final CharSequence value1 = min_textview.getText();
        String number = value1.toString();
        String number1 = number.substring(0, 2);
        String number2 = number.substring(3, 5);

        final int num = Integer.valueOf(number1) * 60 + Integer.valueOf(number2);
        mTimeMillisLeft = num * 1000;

        countDownTimer = new CountDownTimer(mTimeMillisLeft, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                mTimeMillisLeft = millisUntilFinished;
                updateTimer();

            }

            @Override
            public void onFinish() {
                int newvalue = Integer.valueOf(button_value) + 1;
                if(newvalue <= 7){

                    Intent intent = new Intent(ExerciseInfo.this, ExerciseInfo.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);

                }else{

                    newvalue = 1;
                    Intent intent = new Intent(ExerciseInfo.this, ExerciseInfo.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.putExtra("value", String.valueOf(newvalue));
                    startActivity(intent);

                }
            }
        }.start();

        startbutton.setText("PAUSE");
        mTimeRunning = true;

    }

    private void updateTimer(){

        int minutes = (int) mTimeMillisLeft / 60000;
        int seconds = (int) mTimeMillisLeft % 60000 / 1000;

        String timeLeftText = "";
        if(minutes < 10)
            timeLeftText = "0";
        timeLeftText = timeLeftText + minutes + ":";

        if(seconds < 10)
            timeLeftText += "0";
        timeLeftText += seconds;

        min_textview.setText(timeLeftText);

    }

    /**
     * Called when the activity has detected the user's press of the back
     * key. The {@link #getOnBackPressedDispatcher() OnBackPressedDispatcher} will be given a
     * chance to handle the back button before the default behavior of
     * {@link Activity#onBackPressed()} is invoked.
     *
     * @see #getOnBackPressedDispatcher()
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
