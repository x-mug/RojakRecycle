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

public class FrgUnrecyclables extends Fragment {
    RecyclerView recyclerView;
    ArrayList<UnrecyclableThings> list;
    UnrecyclablesAdapter unrecyclablesAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_unrecyclables, container, false);

        recyclerView = v.findViewById(R.id.unrecyclablesList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        list = new ArrayList<>();
        for (int i = 0; i < UnrecyclableThingsData.rMaterialsName.length; i++) {
            list.add(new UnrecyclableThings(UnrecyclableThingsData.rMaterialsName[i]));
        }

        unrecyclablesAdapter = new UnrecyclablesAdapter(getActivity(), list);
        recyclerView.setAdapter(unrecyclablesAdapter);

        return v;
    }
}
