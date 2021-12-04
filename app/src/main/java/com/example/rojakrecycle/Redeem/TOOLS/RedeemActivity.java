package com.example.rojakrecycle.Redeem.TOOLS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rojakrecycle.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class RedeemActivity extends Fragment {

    TabLayout tabLayout;
    TabItem AllTab, VouchersTab, DonateTab, TouchNGoTab;
    RedeemPageAdapter RedeemPageAdapter;
    ViewPager2 viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.activity_redeem, null);

        AllTab = v.findViewById(R.id.tabAll);
        VouchersTab = v.findViewById(R.id.tabVoucher);
        DonateTab = v.findViewById(R.id.tabDonate);
        TouchNGoTab = v.findViewById(R.id.tabTouchNGo);
        viewPager = v.findViewById(R.id.Redeemfragmentcontainer);
        tabLayout = v.findViewById(R.id.include);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
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

        return v;
    }
}