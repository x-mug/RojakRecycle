package com.example.rojakrecycle.Redeem.TOOLS;

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

import com.example.rojakrecycle.R;

import java.util.ArrayList;

public class RedeemVouchersAdapter extends RecyclerView.Adapter <RedeemVouchersAdapter.MyViewHolder>{

    Context context;
    ArrayList<Redeem_VouchersThings> list;

    public RedeemVouchersAdapter(Context context, ArrayList<Redeem_VouchersThings> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RedeemVouchersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.redeemvouchers_things, parent, false);
        return new RedeemVouchersAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RedeemVouchersAdapter.MyViewHolder holder, int position) {
        Redeem_VouchersThings redeem_vouchersThings = list.get(position);
        holder.name.setText(redeem_vouchersThings.getRName());
        holder.subhead.setText(redeem_vouchersThings.getRPoints());
        holder.Album.setImageResource(redeem_vouchersThings.getRImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RedeemDescriptionActivity.class);
                Bundle extras = new Bundle();
                extras.putString("Name", list.get(holder.getAdapterPosition()).getRName());
                extras.putInt("Image", list.get(holder.getAdapterPosition()).getRImage());
                extras.putString("Location", list.get(holder.getAdapterPosition()).getRLocation());
                extras.putString("Exchange", list.get(holder.getAdapterPosition()).getRExchange());
                extras.putDoubleArray("LatLng", new double[]{
                        list.get(holder.getAdapterPosition()).getLatLng().latitude,
                        list.get(holder.getAdapterPosition()).getLatLng().longitude
                });
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

