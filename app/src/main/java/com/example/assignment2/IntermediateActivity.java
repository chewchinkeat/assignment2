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

public class IntermediateActivity extends AppCompatActivity {

    int[] newArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newArray = new int[]{

                R.id.exercisei1_pose, R.id.exercisei2_pose,R.id.exercisei3_pose,R.id.exercisei4_pose,R.id.exercisei5_pose,R.id.exercisei6_pose,
                R.id.exercisei7_pose,R.id.exercisei8_pose,R.id.exercisei9_pose,R.id.exercisei10_pose,R.id.exercisei11_pose,R.id.exercisei12_pose,

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

    public void Imagebuttonclicked(View view) {

        for(int i = 0; i < newArray.length; i++){
            if(view.getId() == newArray[i]){

                int value = i + 1;
                Log.i("FIRST", String.valueOf(value));
                Intent intent = new Intent(IntermediateActivity.this, ExerciseInfo2.class);
                intent.putExtra("value",String.valueOf(value));
                startActivity(intent);

            }
        }
    }
}