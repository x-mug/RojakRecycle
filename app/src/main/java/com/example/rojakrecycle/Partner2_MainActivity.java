package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Partner2_MainActivity extends AppCompatActivity {
    View backArrow;
    TextView backText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner2_main);

        backArrow = findViewById(R.id.vector_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(Partner2_MainActivity.this, PartnerStore_MainActivity.class);
                startActivity(intent_one);
            }
        });

        backText = findViewById(R.id.tv_Back);
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(Partner2_MainActivity.this, PartnerStore_MainActivity.class);
                startActivity(intent_one);
            }
        });
    }
}