package com.example.rojakrecycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UnrecyclablesAdapter extends RecyclerView.Adapter <UnrecyclablesAdapter.MyViewHolder> {

    Context context;
    ArrayList<UnrecyclableThings> list;

    public UnrecyclablesAdapter(Context context, ArrayList<UnrecyclableThings> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.unrecyclablethings, parent, false);
        return new UnrecyclablesAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UnrecyclableThings unrecyclableThings = list.get(position);
        holder.name.setText(unrecyclableThings.getrMaterial());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);

            cardView = itemView.findViewById(R.id.cvUnrecyclable);
        }
    }
}
