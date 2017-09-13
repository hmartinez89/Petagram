package com.hmartinez.petagram.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hmartinez.petagram.R;
import com.hmartinez.petagram.db.ConstructorMascotas;
import com.hmartinez.petagram.pojo.DataSet;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{
    private Context context;
    private ArrayList<DataSet> alMascotas;

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
    public void onBindViewHolder(final MascotaViewHolder holder, final int position) {
        final DataSet mascota = alMascotas.get(position);

        holder.ivFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getsNombre());
        holder.tvLikes.setText(Integer.toString(mascota.getLikes()));
        holder.imgBtnHuesoLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(context);
                constructorMascotas.darLikeMascota(mascota);
                Toast.makeText(context, "Likes a: "+ alMascotas.get(position).getsNombre(), Toast.LENGTH_SHORT).show();

                holder.tvLikes.setText(Integer.toString(constructorMascotas.obtenerLikesMascotas(mascota)));
            }
        });
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
            ivFoto              = (ImageView)   itemView.findViewById(R.id.ivFoto_cardview);
            imgBtnHuesoLike     = (ImageButton) itemView.findViewById(R.id.imgBtnHuesoLike);
            tvNombre            = (TextView)    itemView.findViewById(R.id.tvNombre_cardview);
            tvLikes             = (TextView)    itemView.findViewById(R.id.tvLikes_cardview);
            ivHuesoLikes        = (ImageView)   itemView.findViewById(R.id.ivHuesoLikes);
        }
    }
}