package com.example.rojakrecycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rojakrecycle.Redeem.RedeemDonateAdapter;
import com.example.rojakrecycle.Redeem.TOOLS.Redeem_DonateThings;
import com.example.rojakrecycle.Redeem.TOOLS.Redeem_DonateThingsData;

import java.util.ArrayList;

public class FragDonate extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Redeem_DonateThings> list;
    com.example.rojakrecycle.Redeem.RedeemDonateAdapter RedeemDonateAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_redeem_donate, container, false);

        recyclerView = v.findViewById(R.id.RecyclerViewRedeemDonate);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        list = new ArrayList<>();
        for (int i = 0; i < Redeem_DonateThingsData.RName.length; i++) {
            list.add(new Redeem_DonateThings(Redeem_DonateThingsData.RName[i], Redeem_DonateThingsData.RLocation[i], Redeem_DonateThingsData.RExchange[i], Redeem_DonateThingsData.RImage[i], Redeem_DonateThingsData.RPoints[i]));
        }

        RedeemDonateAdapter = new RedeemDonateAdapter(getActivity(), list);
        recyclerView.setAdapter(RedeemDonateAdapter);

        return v;
    }
}
