package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RedeemDescriptionActivity extends AppCompatActivity {

    TextView tvTitle;
    TextView tv1;
    TextView tv3;
    ImageView RImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem_description);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        tvTitle = findViewById(R.id.tv_title3);
        String Name = extras.getString("Name");
        tvTitle.setText(Name);

        tv1 = findViewById(R.id.textView_Location);
        String Location = extras.getString("Location");
        tv1.setText(Location);

        RImage = findViewById(R.id.imageView);
        Integer Image = extras.getInt("Image");
        RImage.setImageResource(Image);

        tv3 = findViewById(R.id.tView_Exchange);
        String Exchange = extras.getString("Exchange");
        tv3.setText(Exchange);


    }
}