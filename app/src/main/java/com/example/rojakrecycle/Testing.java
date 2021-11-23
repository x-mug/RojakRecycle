package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.rojakrecycle.Learn.LearnActivity;

public class Testing extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        Intent intent = new Intent(Testing.this, LearnActivity.class);
        startActivity(intent);
    }
}