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

import com.example.rojakrecycle.Redeem.RedeemTouchNGoAdapter;
import com.example.rojakrecycle.Redeem.TOOLS.Redeem_TouchNGoThings;
import com.example.rojakrecycle.Redeem.TOOLS.Redeem_TouchNGoThingsData;

import java.util.ArrayList;

public class FragTouchNGo extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Redeem_TouchNGoThings> list;
    com.example.rojakrecycle.Redeem.RedeemTouchNGoAdapter RedeemTouchNGoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_redeem_touchngo, container, false);

        recyclerView = v.findViewById(R.id.RecyclerViewRedeemTouchNGo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        list = new ArrayList<>();
        for (int i = 0; i < Redeem_TouchNGoThingsData.RName.length; i++) {
            list.add(new Redeem_TouchNGoThings(Redeem_TouchNGoThingsData.RName[i], Redeem_TouchNGoThingsData.RLocation[i], Redeem_TouchNGoThingsData.RExchange[i], Redeem_TouchNGoThingsData.RImage[i], Redeem_TouchNGoThingsData.RPoints[i]));
        }

        RedeemTouchNGoAdapter = new RedeemTouchNGoAdapter(getActivity(), list);
        recyclerView.setAdapter(RedeemTouchNGoAdapter);

        return v;
    }
}
