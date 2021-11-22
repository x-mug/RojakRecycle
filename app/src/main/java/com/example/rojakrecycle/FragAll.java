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

import java.util.ArrayList;

public class FragAll extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Redeem_AllThings> list;
    RedeemAllAdapter RedeemAllAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_redeem_all, container, false);

        recyclerView = v.findViewById(R.id.RecyclerViewRedeemAll);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        list = new ArrayList<>();
        for (int i = 0; i < Redeem_AllThingsData.RName.length; i++) {
            list.add(new Redeem_AllThings(Redeem_AllThingsData.RName[i], Redeem_AllThingsData.RLocation[i], Redeem_AllThingsData.RExchange[i], Redeem_AllThingsData.RImage[i],Redeem_AllThingsData.RPoints[i]));
        }

        RedeemAllAdapter = new RedeemAllAdapter(getActivity(), list);
        recyclerView.setAdapter(RedeemAllAdapter);


        return v;
    }
}
