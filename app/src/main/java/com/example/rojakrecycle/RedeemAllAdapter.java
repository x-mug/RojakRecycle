package com.example.rojakrecycle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RedeemAllAdapter extends RecyclerView.Adapter <RedeemAllAdapter.MyViewHolder>{

    Context context;
    ArrayList<Redeem_AllThings> list;

    public RedeemAllAdapter (Context context, ArrayList<Redeem_AllThings> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RedeemAllAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.redeemall_things, parent, false);
        return new RedeemAllAdapter.MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Redeem_AllThings redeem_allThings = list.get(position);
        holder.name.setText(redeem_allThings.getRName());
        holder.subhead.setText(redeem_allThings.getRPoints());
        holder.Album.setImageResource(redeem_allThings.getRImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RedeemDescriptionActivity.class);
                Bundle extras = new Bundle();
                extras.putString("Name", list.get(holder.getAdapterPosition()).getRName());
                extras.putInt("Image", list.get(holder.getAdapterPosition()).getRImage());
                extras.putString("Location", list.get(holder.getAdapterPosition()).getRLocation());
                extras.putString("Exchange", list.get(holder.getAdapterPosition()).getRExchange());
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView name;
        ImageView Album;
        TextView subhead;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cv_rdAll);
            name = itemView.findViewById(R.id.textView1);
            subhead = itemView.findViewById(R.id.subhead1);
            Album = itemView.findViewById(R.id.Redeem_pic);
        }

    }
}

