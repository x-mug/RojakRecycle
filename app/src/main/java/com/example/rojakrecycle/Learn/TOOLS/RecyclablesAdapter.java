package com.example.rojakrecycle.Learn.TOOLS;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rojakrecycle.DescriptionActivity;
import com.example.rojakrecycle.R;

import java.util.ArrayList;

public class RecyclablesAdapter extends RecyclerView.Adapter <RecyclablesAdapter.MyViewHolder> {

    Context context;
    ArrayList<RecyclableThings> list;

    public RecyclablesAdapter(Context context, ArrayList<RecyclableThings> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.recyclablethings, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RecyclableThings recyclableThings = list.get(position);
        holder.name.setText(recyclableThings.getrMaterial());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DescriptionActivity.class);
                Bundle extras = new Bundle();
                extras.putString("title", list.get(holder.getAdapterPosition()).getrMaterial());
                extras.putInt("image", list.get(holder.getAdapterPosition()).getrMaterialImg());
                extras.putString("description", list.get(holder.getAdapterPosition()).getrMaterialDesc());
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });

        startingAnim(holder.cardView);
    }

    private void startingAnim(View thisView) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.titlefall_anim);
        thisView.startAnimation(animation);

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

            cardView = itemView.findViewById(R.id.cvRecyclable);
        }
    }
}
