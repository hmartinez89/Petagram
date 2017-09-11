package com.hmartinez.petagram;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hmartinez.petagram.R;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{
    private Context context;
    ArrayList<DataSet> alMascotas;

    public MascotaAdapter(ArrayList<DataSet> mascotas, Context context){
        super();
        this.alMascotas = mascotas;
        this.context = context;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, final int position) {
        DataSet mascota = alMascotas.get(position);

        holder.ivFoto.setImageResource(mascota.getIntFoto());
        holder.tvNombre.setText(mascota.getsNombre());
        holder.tvLikes.setText(mascota.getsLikes());
    }

    @Override
    public int getItemCount() {
        return alMascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFoto, ivHuesoLikes;
        private ImageButton imgBtnHuesoLike;
        private TextView tvNombre, tvLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto_cardview);
            imgBtnHuesoLike = (ImageButton) itemView.findViewById(R.id.imgBtnHuesoLike);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre_cardview);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes_cardview);
            ivHuesoLikes = (ImageView) itemView.findViewById(R.id.ivHuesoLikes);
        }
    }
}