package com.example.rojakrecycle.Redeem.TOOLS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rojakrecycle.Map.MapActivity;
import com.example.rojakrecycle.R;
import com.google.android.gms.maps.model.LatLng;

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

        CardView cv = findViewById(R.id.cv_pc3);
        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RedeemDescriptionActivity.this, "Sorry, Your RojakPoint is not sufficient", Toast.LENGTH_SHORT).show();
            }
        });
    }
}