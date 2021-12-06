package com.example.rojakrecycle.navBar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rojakrecycle.Learn.LearnActivity;
import com.example.rojakrecycle.Profile.Profile_Activity;
import com.example.rojakrecycle.R;
import com.example.rojakrecycle.RecyclePage_MainActivity;
import com.example.rojakrecycle.Redeem.TOOLS.RedeemActivity;
import com.example.rojakrecycle.home.HomePage;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigationActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottom_navigation);
        setMain();

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setItemIconTintList(null);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new HomePage()).commit();
                        return true;

                    case R.id.navigation_learn:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new LearnActivity()).commit();
                        return true;

                    case R.id.navigation_recycle:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new RecyclePage_MainActivity()).commit();
                        return true;
                    case R.id.navigation_redeem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new RedeemActivity()).commit();
                        return true;

                    case R.id.navigation_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new Profile_Activity()).commit();
                        return true;
                }
                return false;
            }
        });
    }

    private void setMain() {
        this.getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment_activity_bottom_navigation, new HomePage()).commit();
    }

    // 第一次按下返回键的事件
    private long firstPressedTime;

    // System.currentTimeMillis() 当前系统的时间
    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - firstPressedTime < 2000) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, "Press One More to Quit", Toast.LENGTH_SHORT).show();
            firstPressedTime = System.currentTimeMillis();
        }
    }

}