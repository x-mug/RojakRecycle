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

public class RedeemTouchNGoAdapter extends RecyclerView.Adapter <RedeemTouchNGoAdapter.MyViewHolder>{

    Context context;
    ArrayList<Redeem_TouchNGoThings> list;

    public RedeemTouchNGoAdapter(Context context, ArrayList<Redeem_TouchNGoThings> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RedeemTouchNGoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.redeemtouchngo_things, parent, false);
        return new RedeemTouchNGoAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RedeemTouchNGoAdapter.MyViewHolder holder, int position) {
        Redeem_TouchNGoThings redeem_touchNGoThings = list.get(position);
        holder.name.setText(redeem_touchNGoThings.getRName());
        holder.subhead.setText(redeem_touchNGoThings.getRPoints());
        holder.Album.setImageResource(redeem_touchNGoThings.getRImage());
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
        TextView subhead;
        ImageView Album;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cv_rdAll);
            name = itemView.findViewById(R.id.textView1);
            subhead = itemView.findViewById(R.id.subhead1);
            Album = itemView.findViewById(R.id.Redeem_pic);
        }

    }
}

