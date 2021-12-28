package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
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

            Intent myIntent = new Intent(Intent.ACTION_SEND);
            myIntent.setType("text/plain");
            String sharebody = "This app is best. " + "https://play.google.com/store/apps/details?id=com.example.assignment2&hl=en";
            String sharehub = "FitEx App";
            myIntent.putExtra(Intent.EXTRA_SUBJECT, sharehub);
            myIntent.putExtra(Intent.EXTRA_TEXT, sharebody);
            startActivity(Intent.createChooser(myIntent, "Share using"));

            return true;
        }

        if(id == R.id.rate){

            try{

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName())));


            }catch(Exception ex){

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));

            }

            return true;
        }

        if(id == R.id.moreapps){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Mobilious+Limited"));
            startActivity(intent);
            return true;
        }

        if(id == R.id.term){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
            startActivity(intent);
            return true;
        }

        if(id == R.id.privacy){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(""));
            startActivity(intent);
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