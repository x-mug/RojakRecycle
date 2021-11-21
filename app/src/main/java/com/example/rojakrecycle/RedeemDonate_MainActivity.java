package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RedeemDonate_MainActivity extends AppCompatActivity {
    Button All;
    Button Voucher;
    Button Donate;
    Button TouchnGo;

    CardView cv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_donate_main);
        All = findViewById(R.id.btn_All);
        All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemDonate_MainActivity.this, RedeemPage_MainActivity.class);
                startActivity(intent_one);
            }
        });

        Voucher = findViewById(R.id.btn_Vouchers);
        Voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemDonate_MainActivity.this, RedeemVoucher_MainActivity.class);
                startActivity(intent_one);
            }
        });

        Donate = findViewById(R.id.btn_Donate);
        Donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemDonate_MainActivity.this, RedeemDonate_MainActivity.class);
                startActivity(intent_one);
            }
        });

        TouchnGo = findViewById(R.id.btn_TouchnGo);
        TouchnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemDonate_MainActivity.this, RedeemTouchNGo_MainActivity.class);
                startActivity(intent_one);
            }
        });

        //h&m
        cv3 = findViewById(R.id.cv_rd3);
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemDonate_MainActivity.this, RedeemHM_MainActivity.class);
                startActivity(intent_one);
            }
        });
    }
}