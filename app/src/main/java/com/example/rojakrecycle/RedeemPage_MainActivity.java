package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RedeemPage_MainActivity extends AppCompatActivity {

    Button All;
    Button Voucher;
    Button Donate;
    Button TouchnGo;

    CardView cv1;
    CardView cv2;
    CardView cv3;
    CardView cv4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_page_main);

        All = findViewById(R.id.btn_All);
        All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemPage_MainActivity.this, RedeemPage_MainActivity.class);
                startActivity(intent_one);
            }
        });

        Voucher = findViewById(R.id.btn_Vouchers);
        Voucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemPage_MainActivity.this, RedeemVoucher_MainActivity.class);
                startActivity(intent_one);
            }
        });

        Donate = findViewById(R.id.btn_Donate);
        Donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemPage_MainActivity.this, RedeemDonate_MainActivity.class);
                startActivity(intent_one);
            }
        });

        TouchnGo = findViewById(R.id.btn_TouchnGo);
        TouchnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemPage_MainActivity.this, RedeemTouchNGo_MainActivity.class);
                startActivity(intent_one);
            }
        });

        //jaya grocer
        cv1 = findViewById(R.id.cv_rd1);
        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemPage_MainActivity.this, RedeemJayaGrocer_MainActivity.class);
                startActivity(intent_one);
            }
        });

        //lotus
        cv2 = findViewById(R.id.cv_rd2);
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemPage_MainActivity.this, RedeemLotus_MainActivity.class);
                startActivity(intent_one);
            }
        });

        //h&m
        cv3 = findViewById(R.id.cv_rd3);
        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemPage_MainActivity.this, RedeemHM_MainActivity.class);
                startActivity(intent_one);
            }
        });

        //touchngo
        cv4 = findViewById(R.id.cv_rd4);
        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_one = new Intent(RedeemPage_MainActivity.this, RedeemTNGVoucher_MainActivity.class);
                startActivity(intent_one);
            }
        });
    }
}