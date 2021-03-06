package com.example.rojakrecycle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rojakrecycle.Map.MapActivity;
import com.google.android.gms.maps.model.LatLng;

public class Partner4_MainActivity extends Fragment {
    View backArrow;
    TextView backText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = View.inflate(getActivity(), R.layout.activity_partner4_main, null);

        backArrow = v.findViewById(R.id.ps_vector_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation, new PartnerStore_MainActivity()).commit();
            }
        });

        CardView map = v.findViewById(R.id.cv_pc1);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_bottom_navigation
                        , new MapActivity(new LatLng(3.1054860462864577f, 101.46747831071785f), "")).commit();
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