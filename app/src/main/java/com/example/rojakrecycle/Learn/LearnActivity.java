package com.example.rojakrecycle.Learn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.rojakrecycle.Learn.TOOLS.PagerAdapter;
import com.example.rojakrecycle.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class LearnActivity extends Fragment {

    TabLayout tabLayout;
    TabItem recyclableTab, unrecyclableTab;
    PagerAdapter pagerAdapter;
    ViewPager2 viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = View.inflate(getActivity(), R.layout.activity_learn, null);

        recyclableTab = v.findViewById(R.id.tabRecyclable);
        unrecyclableTab = v.findViewById(R.id.tabUnrecyclable);
        viewPager = v.findViewById(R.id.fragmentcontainer);
        tabLayout = v.findViewById(R.id.include);

        // TODO: Fragment Switch
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        pagerAdapter = new PagerAdapter(fragmentManager, getLifecycle());
        viewPager.setAdapter(pagerAdapter);

        // click to change tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1){
                    pagerAdapter.notifyDataSetChanged();
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