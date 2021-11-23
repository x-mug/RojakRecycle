package com.example.rojakrecycle.navBar;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.rojakrecycle.Learn.LearnActivity;
import com.example.rojakrecycle.Profile.Profile_Activity;
import com.example.rojakrecycle.R;
import com.example.rojakrecycle.home.HomePage;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottom_navigation);
        setMain();

        //Initialize And Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.nav_view);

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

}