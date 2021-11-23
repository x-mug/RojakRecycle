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

import com.example.rojakrecycle.Redeem.RedeemVouchersAdapter;
import com.example.rojakrecycle.Redeem.TOOLS.Redeem_VouchersThings;
import com.example.rojakrecycle.Redeem.TOOLS.Redeem_VouchersThingsData;

import java.util.ArrayList;

public class FragVouchers extends Fragment {

    RecyclerView recyclerView;
    ArrayList<Redeem_VouchersThings> list;
    com.example.rojakrecycle.Redeem.RedeemVouchersAdapter RedeemVouchersAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_redeem_vouchers, container, false);

        recyclerView = v.findViewById(R.id.RecyclerViewRedeemVouchers);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        list = new ArrayList<>();
        for (int i = 0; i < Redeem_VouchersThingsData.RName.length; i++) {
            list.add(new Redeem_VouchersThings(Redeem_VouchersThingsData.RName[i], Redeem_VouchersThingsData.RLocation[i], Redeem_VouchersThingsData.RExchange[i], Redeem_VouchersThingsData.RImage[i],Redeem_VouchersThingsData.RPoints[i]));
        }

        RedeemVouchersAdapter = new RedeemVouchersAdapter(getActivity(), list);
        recyclerView.setAdapter(RedeemVouchersAdapter);

        return v;
    }
}
