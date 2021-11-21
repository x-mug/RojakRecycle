package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RedeemTouchNGo_MainActivity extends AppCompatActivity {
    Button All;
    Button Voucher;
    Button Donate;
    Button TouchnGo;

    CardView cv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_touch_ngo_main);

        All = findViewById(R.id.btn_All);
        All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemTouchNGo_MainActivity.this, RedeemPage_MainActivity.class);
                startActivity(intent_one);
            }
        });

        Voucher = findViewById(R.id.btn_Vouchers);
        Voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemTouchNGo_MainActivity.this, RedeemVoucher_MainActivity.class);
                startActivity(intent_one);
            }
        });

        Donate = findViewById(R.id.btn_Donate);
        Donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemTouchNGo_MainActivity.this, RedeemDonate_MainActivity.class);
                startActivity(intent_one);
            }
        });

        TouchnGo = findViewById(R.id.btn_TouchnGo);
        TouchnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemTouchNGo_MainActivity.this, RedeemTouchNGo_MainActivity.class);
                startActivity(intent_one);
            }
        });

        //touchngo
        cv4 = findViewById(R.id.cv_rd4);
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemTouchNGo_MainActivity.this, RedeemTNGVoucher_MainActivity.class);
                startActivity(intent_one);
            }
        });
    }
}