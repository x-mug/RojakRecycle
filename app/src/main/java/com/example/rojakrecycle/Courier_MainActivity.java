package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Courier_MainActivity extends AppCompatActivity {

    View backArrow;
    TextView backText;
    CardView cd1;
    CardView cd2;
    CardView cd3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courier_main);

        backArrow = findViewById(R.id.vector_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(Courier_MainActivity.this, RecyclePage_MainActivity.class);
                startActivity(intent_one);
            }
        });

        backText = findViewById(R.id.tv_Back);
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(Courier_MainActivity.this, RecyclePage_MainActivity.class);
                startActivity(intent_one);
            }
        });

        cd1 = findViewById(R.id.cv_pc1);
        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(Courier_MainActivity.this, Courier1_MainActivity.class);
                startActivity(intent_one);
            }
        });

        cd2 = findViewById(R.id.cv_pc2);
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(Courier_MainActivity.this, Courier2_MainActivity.class);
                startActivity(intent_one);
            }
        });
        cd3 = findViewById(R.id.cv_pc3);
        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(Courier_MainActivity.this, Courier3_MainActivity.class);
                startActivity(intent_one);
            }
        });
    }
}