package com.example.rojakrecycle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PartnerStore_MainActivity extends Fragment {

    View backArrow;
    TextView backText;
    CardView cd1;
    CardView cd2;
    CardView cd3;
    CardView cd4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.activity_partner_store_main, null);

        backArrow = v.findViewById(R.id.ps_vector_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new RecyclePage_MainActivity()).commit();
            }
        });

        backText = v.findViewById(R.id.tv_Back);
        backText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new RecyclePage_MainActivity()).commit();
            }
        });

        cd1 = v.findViewById(R.id.cv_pc1);
        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new Partner1_MainActivity()).commit();
            }
        });

        cd2 = v.findViewById(R.id.cv_pc2);
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new Partner2_MainActivity()).commit();
            }
        });

        cd3 = v.findViewById(R.id.cv_pc3);
        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new Partner3_MainActivity()).commit();
            }
        });

        cd4 = v.findViewById(R.id.cv_pc4);
        cd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new Partner4_MainActivity()).commit();
            }
        });

        return v;
    }
}