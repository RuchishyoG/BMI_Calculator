package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class Display extends AppCompatActivity {

    public double bmi, ht, wt;
    public String h,w,status,BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        Intent it=getIntent();
        h = it.getStringExtra("height");
        w = it.getStringExtra("weight");
        ht= Double.parseDouble(h);
        wt= Double.parseDouble(w);
        bmi = wt / (ht * ht);
        DecimalFormat df= new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        BMI=df.format(bmi);
        TextView BMIres = (TextView) findViewById(R.id.res);
        BMIres.setText(BMI);
        if(bmi<18.5)
            status = "Underweight";
        else if(bmi<25)
            status = "Normal";
        else
            status = "Overweight";
        TextView Stat = (TextView) findViewById(R.id.res2);
        Stat.setText(status);

    }
}