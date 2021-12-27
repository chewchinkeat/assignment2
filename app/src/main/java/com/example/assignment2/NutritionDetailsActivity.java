package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NutritionDetailsActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_details);

        textView = findViewById(R.id.txt);
        String details = getIntent().getStringExtra("story");
        textView.setText(details);

    }

    public void previous(View view) {

        Intent intent = new Intent(NutritionDetailsActivity.this, NutritionActivity.class);
        startActivity(intent);
        finish();

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
        Intent intent = new Intent(NutritionDetailsActivity.this, NutritionActivity.class);
        startActivity(intent);
        finish();
    }
}