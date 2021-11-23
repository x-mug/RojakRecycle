package com.example.rojakrecycle.Redeem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.rojakrecycle.FragAll;
import com.example.rojakrecycle.FragDonate;
import com.example.rojakrecycle.FragTouchNGo;
import com.example.rojakrecycle.FragVouchers;

public class RedeemPageAdapter extends FragmentStateAdapter {

    int tabcount = 4;

    public RedeemPageAdapter(@NonNull FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0:
                return new FragAll();

            case 1:
                return new FragVouchers();

            case 2:
                return new FragDonate();

            case 3:
                return new FragTouchNGo();


            default:
                return null;
        }

    }

    @Override
    public int getItemCount() {
        return tabcount;
    }
}
