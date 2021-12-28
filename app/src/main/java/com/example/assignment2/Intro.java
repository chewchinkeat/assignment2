package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Intro extends AppCompatActivity {

    Animation down;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        TextView textView = findViewById(R.id.intro_name);

        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        textView.setAnimation(down);

        //new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
                finish();
            }
        }, 3500);

    }
}