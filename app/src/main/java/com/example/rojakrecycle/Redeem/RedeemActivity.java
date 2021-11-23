package com.example.rojakrecycle.Redeem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.rojakrecycle.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class RedeemActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem AllTab, VouchersTab, DonateTab, TouchNGoTab;
    RedeemPageAdapter RedeemPageAdapter;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeem);

        AllTab = findViewById(R.id.tabAll);
        VouchersTab = findViewById(R.id.tabVoucher);
        DonateTab = findViewById(R.id.tabDonate);
        TouchNGoTab = findViewById(R.id.tabTouchNGo);
        viewPager = findViewById(R.id.Redeemfragmentcontainer);
        tabLayout = findViewById(R.id.include);
        FragmentManager fragmentManager = getSupportFragmentManager();
        RedeemPageAdapter = new RedeemPageAdapter(fragmentManager, getLifecycle());
        viewPager.setAdapter(RedeemPageAdapter);

        // click to change tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1|| tab.getPosition() == 2|| tab.getPosition() == 3){
                    RedeemPageAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

    }
}