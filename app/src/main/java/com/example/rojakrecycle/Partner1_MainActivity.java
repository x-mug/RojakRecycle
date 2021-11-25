package com.example.rojakrecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Partner1_MainActivity extends Fragment {
    View backArrow;
    TextView backText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.activity_partner1_main, null);

        backArrow = v.findViewById(R.id.vector_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new PartnerStore_MainActivity()).commit();
            }
        });

        backText = v.findViewById(R.id.tv_Back);
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new PartnerStore_MainActivity()).commit();
            }
        });
        return v;
    }
}