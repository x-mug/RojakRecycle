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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RedeemDonateAdapter extends RecyclerView.Adapter <RedeemDonateAdapter.MyViewHolder>{

    Context context;
    ArrayList<Redeem_DonateThings> list;

    public RedeemDonateAdapter(Context context, ArrayList<Redeem_DonateThings> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RedeemDonateAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.redeemdonata_things, parent, false);
        return new RedeemDonateAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RedeemDonateAdapter.MyViewHolder holder, int position) {
        Redeem_DonateThings redeem_donateThings = list.get(position);
        holder.name.setText(redeem_donateThings.getRName());
        holder.subhead.setText(redeem_donateThings.getRPoints());
        holder.Album.setImageResource(redeem_donateThings.getRImage());
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

