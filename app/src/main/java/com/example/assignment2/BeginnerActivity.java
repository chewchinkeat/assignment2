package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fitextermsandconditions.blogspot.com/2021/12/fitex-terms-and-conditions.html"));
            startActivity(intent);
            return true;
        }

        if(id == R.id.privacy){

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://fitexprivacypolicies.blogspot.com/2021/12/privacy-policy-fitex-is-provided-by-llc.html"));
            startActivity(intent);
            return true;
        }
        return true;
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

