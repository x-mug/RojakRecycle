package com.example.rojakrecycle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class PagerAdapter extends FragmentStateAdapter {

    int tabcount = 2;

    public PagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
            {
                fragment = new FrgRecyclables();
                break;
            }
            case 1:
            {
                fragment = new FrgUnrecyclables();
                break;
            }
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return tabcount;
    }
}
