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

public class FrgRecyclables extends Fragment {

    RecyclerView recyclerView;
    ArrayList<RecyclableThings> list;
    RecyclablesAdapter recyclablesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclables, container, false);

        recyclerView = v.findViewById(R.id.recyclablesList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        list = new ArrayList<>();
        for (int i = 0; i < RecyclableThingsData.rMaterialsName.length; i++) {
            list.add(new RecyclableThings(RecyclableThingsData.rMaterialsName[i], RecyclableThingsData.rMaterialsDesc[i], RecyclableThingsData.rMaterialsImg[i]));
        }

        recyclablesAdapter = new RecyclablesAdapter(getActivity(), list);
        recyclerView.setAdapter(recyclablesAdapter);

        return v;
    }
}
