package com.example.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static com.example.bmicalculator.MainActivity.h;
import static com.example.bmicalculator.MainActivity.w;
import static com.example.bmicalculator.MainActivity.ht;
import static com.example.bmicalculator.MainActivity.wt;

public class Display extends AppCompatActivity {

    public String status,BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        ht = Double.parseDouble(h);
        wt = Double.parseDouble(w);
        MainActivity.bmi = wt / (ht * ht);
        DecimalFormat df= new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        BMI=df.format(MainActivity.bmi);
        TextView BMIres = (TextView) findViewById(R.id.res);
        BMIres.setText(BMI);
        if(MainActivity.bmi<18.5)
            status = "Underweight";
        else if(MainActivity.bmi<25)
            status = "Normal";
        else
            status = "Overweight";
        TextView Stat = (TextView) findViewById(R.id.res2);
        Stat.setText(status);
    }
}