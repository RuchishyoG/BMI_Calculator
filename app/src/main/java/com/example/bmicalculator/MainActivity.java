package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String h,w;
    EditText height,weight;
    Button cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height=(EditText)findViewById(R.id.height);
        weight=(EditText)findViewById(R.id.weight);
        cal=(Button)findViewById(R.id.calculate);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h = height.getText().toString();
                w = weight.getText().toString();
                if (h != null && !h.equals("") && w != null && !w.equals("")) {
                    Intent i=new Intent(MainActivity.this, Display.class);
                    i.putExtra("height", h);
                    i.putExtra("weight", w);
                    startActivity(i);
                } else
                    Toast.makeText(MainActivity.this, "Please Enter Height and Weight", Toast.LENGTH_SHORT).show();
            }
        });
    }
}