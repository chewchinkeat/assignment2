package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonBeginner, buttonIntermediate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonBeginner = findViewById(R.id.start_beginner);
        buttonIntermediate = findViewById(R.id.start_intermediate);

        buttonBeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BeginnerActivity.class);
                startActivity(intent);
            }
        });

        buttonIntermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntermediateActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ellipsis, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.share){
            return true;
        }

        if(id == R.id.rate){
            return true;
        }

        if(id == R.id.moreapps){
            return true;
        }

        if(id == R.id.term){
            return true;
        }

        if(id == R.id.privacy){
            return true;
        }
        return true;
    }

    public void beginner_level(View view) {

        Intent intent = new Intent(MainActivity.this, BeginnerActivity.class);
        startActivity(intent);

    }

    public void intermediate_level(View view) {
        Intent intent = new Intent(MainActivity.this, IntermediateActivity.class);
        startActivity(intent);

    }

    public void nutrition(View view) {

        Intent intent = new Intent(MainActivity.this, NutritionActivity.class);
        startActivity(intent);
    }
}