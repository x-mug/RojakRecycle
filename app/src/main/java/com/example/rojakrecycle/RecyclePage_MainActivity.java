package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RecyclePage_MainActivity extends AppCompatActivity {
    CardView firstCard;
    CardView secondCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_page_main);

        firstCard = findViewById(R.id.cv_CardView1);
        firstCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RecyclePage_MainActivity.this, PartnerStore_MainActivity.class);
                startActivity(intent_one);
            }
        });

        secondCard = findViewById(R.id.cv_CardView2);
        secondCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_two = new Intent(RecyclePage_MainActivity.this, Courier_MainActivity.class);
                startActivity(intent_two);
            }
        });
    }
}