package com.example.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
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