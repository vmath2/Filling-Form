package com.example.fillform.mainActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fillform.googleForms.GreenTyreWeight;
import com.example.fillform.googleForms.MixingProduction;
import com.example.fillform.R;
import com.example.fillform.googleForms.Scrap;

public class MainActivity extends AppCompatActivity {
    private Button scrap;
    private Button mixingProduction;
    private Button greenTyreWeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrap = (Button) findViewById(R.id.scrap);
        scrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueScrap();
            }
        });

        mixingProduction=(Button) findViewById(R.id.mixingProduction);
        mixingProduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueMixingProduction();
            }
        });

        greenTyreWeight = (Button) findViewById(R.id.greenTyreWeight);
        greenTyreWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                continueGreenTyreWeight();
            }
        });

    }

    private void continueScrap(){
        Intent intent = new Intent(MainActivity.this, Scrap.class);
        startActivity(intent);
        return;


    }

    private void continueMixingProduction(){
        Intent intent = new Intent(MainActivity.this, MixingProduction.class);
        startActivity(intent);
        return;



    }

    private void continueGreenTyreWeight(){
        Intent intent = new Intent(MainActivity.this, GreenTyreWeight.class);
        startActivity(intent);
        return;
    }


}
