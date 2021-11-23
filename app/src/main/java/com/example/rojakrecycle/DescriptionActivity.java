package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rojakrecycle.R;

public class DescriptionActivity extends AppCompatActivity {

    TextView tvDesc;
    TextView tvTitle;
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        tvTitle = findViewById(R.id.tvTitle);
        String title = extras.getString("title");
        tvTitle.setText(title);

        ivImage = findViewById(R.id.ivImage);
        Integer image = extras.getInt("image");
        ivImage.setImageResource(image);

        tvDesc = findViewById(R.id.tvDesc);
        String description = extras.getString("description");
        tvDesc.setText(description);
    }
}