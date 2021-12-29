package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BMICalculator extends AppCompatActivity {

    EditText weight,height;
    TextView resulttext;
    String calculation, BMIResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        resulttext = findViewById(R.id.result);}



    public void calculateBMI(View view) {
            String w1 = weight.getText().toString();
            String h1 = height.getText().toString();

            float weightValue = Float.parseFloat(w1);
            float heightValue = Float.parseFloat(h1) /100;

            float bmi = weightValue / (heightValue * heightValue);

            if(bmi < 16){
                BMIResult = "You are severely Under Weight !";
            }
            else if(bmi < 18.5){
                BMIResult = "You are Under Weight !";
            }
            else if(bmi >= 18.5 && bmi <= 24.9){
                BMIResult = "You have Normal Weight";
            }
            else if(bmi >= 18.5 && bmi <= 24.9){
                BMIResult = "You are OverWeight !";
            }
            else {
                BMIResult = "You are Obese !";
            }

            calculation = "Result:\n\n" + String.format("%.2f",bmi) + "\n" + BMIResult;


            resulttext.setText(calculation);
        }

}