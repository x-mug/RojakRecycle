package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.rojakrecycle.login.LoginActivity;

public class SplashScreen_MainActivity extends AppCompatActivity {

    private ImageView SplashEarth;
    private  static int Splash_TIMEOUT = 6000;

    View Title;
    View Bar1;
    View Bar2;
    View logoDescription;
    Animation titleFall;
    Animation BarFall1;
    Animation BarFall2;
    Animation LOGOdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_main);

        //To make the activity to splash screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        SplashEarth = findViewById(R.id.RecycleEarthLogo);
        Glide.with(this).load(R.drawable.recycleearth).into(SplashEarth);


        //Animation call
        titleFall = AnimationUtils.loadAnimation(this, R.anim.titlefall_anim);
        BarFall1 = AnimationUtils.loadAnimation(this, R.anim.titlefall_anim);
        BarFall2 = AnimationUtils.loadAnimation(this, R.anim.titlefall_anim);
        LOGOdescription = AnimationUtils.loadAnimation(this, R.anim.logodescription_anim);

        //Hook the animation
        Title = findViewById(R.id.FallTitle);
        Bar1 = findViewById(R.id.Splashline1);
        Bar2 = findViewById(R.id.Splashline2);
        logoDescription = findViewById(R.id.LogoDescription);

        //Start animation
        Title.setAnimation(titleFall);
        Bar1.setAnimation(BarFall1);
        Bar2.setAnimation(BarFall2);
        logoDescription.setAnimation(LOGOdescription);

        //Handler to run splash screen to direct to next activity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen_MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, Splash_TIMEOUT);
    }
}