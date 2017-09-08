package com.hmartinez.petagram.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hmartinez.petagram.pojo.Mascota;
import com.hmartinez.petagram.R;

import java.util.ArrayList;

public class CarreteAdapter extends RecyclerView.Adapter<CarreteAdapter.CarreteViewHolder> {

    private Context context;
    ArrayList<Mascota> alMascotas;
    private int intPosition;

    public CarreteAdapter(ArrayList<Mascota> mascotas, Context context, int position){
        super();
        this.alMascotas = mascotas;
        this.context = context;
        this.intPosition = position;
    }

    @Override
    public CarreteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_carrete, parent, false);
        return new CarreteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CarreteViewHolder holder, int position) {
        Mascota mascota = alMascotas.get(this.intPosition);
        holder.ivFotos.setImageResource(mascota.getAlCarrete().get(position));
        holder.tvLikesCarrete.setText(mascota.getAlLikesCarrete().get(position));
    }

    @Override
    public int getItemCount() {
        return alMascotas.get(intPosition).getAlCarrete().size();
    }

    public static class CarreteViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivFotos;
        private TextView tvLikesCarrete;

        public CarreteViewHolder(View itemView) {
            super(itemView);
            tvLikesCarrete = (TextView)itemView.findViewById(R.id.tvLikes_carrete_cardview);
            ivFotos = (ImageView)itemView.findViewById(R.id.ivFoto_carrete_cardview);
        }
    }
}