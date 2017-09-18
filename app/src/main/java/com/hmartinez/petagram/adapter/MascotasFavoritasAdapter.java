package com.hmartinez.petagram.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hmartinez.petagram.R;
import com.hmartinez.petagram.pojo.DataSet;

import java.util.ArrayList;

public class MascotasFavoritasAdapter extends RecyclerView.Adapter<MascotasFavoritasAdapter.MascotasFavoritasViewHolder>{
    private ArrayList<DataSet> mascotasFavoritas;
    private Context context;

    public MascotasFavoritasAdapter(ArrayList<DataSet> mascotasFavoritas, Context context) {
        this.mascotasFavoritas = mascotasFavoritas;
        this.context = context;
    }

    @Override
    public MascotasFavoritasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotasfavoritas, parent, false);
        return new MascotasFavoritasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotasFavoritasViewHolder holder, int position) {
        DataSet mascota = mascotasFavoritas.get(position);
        //holder.ivFoto.setImageResource(mascota.getUrlFoto());
        holder.tvNombre.setText(mascota.getFullName());
        holder.tvLikes.setText(Integer.toString(mascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotasFavoritas.size();
    }

    public static class MascotasFavoritasViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFoto;
        private TextView tvNombre;
        private TextView tvLikes;

        public MascotasFavoritasViewHolder(View itemView){
            super(itemView);
            ivFoto      = (ImageView)   itemView.findViewById(R.id.ivFoto_mascotaFav_cardview);
            tvNombre    = (TextView)    itemView.findViewById(R.id.tvNombre_mascotaFav_cardview);
            tvLikes     = (TextView)    itemView.findViewById(R.id.tvLikes_mascotaFav_cardview);
        }
    }
}
