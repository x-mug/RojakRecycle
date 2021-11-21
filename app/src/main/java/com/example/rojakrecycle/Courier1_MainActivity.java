package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Courier1_MainActivity extends AppCompatActivity {
    View backArrow;
    TextView backText;
    CardView PhoneCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courier1_main);

        backArrow = findViewById(R.id.vector_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(Courier1_MainActivity.this, Courier_MainActivity.class);
                startActivity(intent_one);
            }
        });

        backText = findViewById(R.id.tv_Back);
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(Courier1_MainActivity.this, Courier_MainActivity.class);
                startActivity(intent_one);
            }
        });

        PhoneCall = findViewById(R.id.cv_Phone1);
        PhoneCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: 012 - 3456789"));
                startActivity(intent);
            }
        });
    }
}