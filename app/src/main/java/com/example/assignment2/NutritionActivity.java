package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NutritionActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);


        String[] tstory = getResources().getStringArray(R.array.title_story);
        final String[] detail = getResources().getStringArray(R.array.details);

        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rows, R.id.textrow, tstory);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String t = detail[i];
                Intent intent = new Intent(NutritionActivity.this, NutritionDetailsActivity.class);
                intent.putExtra("story", t);
                startActivity(intent);
            }
        });

    }

    public void nutritionback(View view) {
        Intent intent = new Intent(NutritionActivity.this, MainActivity.class);
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
        Intent intent = new Intent(NutritionActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}