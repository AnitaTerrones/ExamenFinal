package com.example.examenfinal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examenfinal.Peliculas;
import com.example.examenfinal.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PeliculasAdapter extends  RecyclerView.Adapter<PeliculasAdapter.PeliculaViewHolder> {

    private List<Peliculas>data;

    public PeliculasAdapter(List<Peliculas> data) {

        this.data = data;
    }

    @NonNull
    @Override
    public PeliculaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_peliculas,parent,false);
        return new PeliculaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaViewHolder holder, int position) {
        int i;
        Peliculas peliculas= data.get(position);
        TextView nombre = holder.itemView.findViewById(R.id.tvNombrePeli);
        nombre.setText(peliculas.getNombre());
        TextView vistas = holder.itemView.findViewById(R.id.tvVistas);
        vistas.setText(peliculas.getVistas());
        TextView fecha = holder.itemView.findViewById(R.id.tvFechaEstreno);
        fecha.setText(peliculas.getFechaEstreno());
        TextView tienda = holder.itemView.findViewById(R.id.tvTienda);
        tienda.setText(peliculas.getTiendas());

        ImageView imgPeli = holder.itemView.findViewById(R.id.imgPelicula);

        Picasso.get()
                .load(peliculas.getImagen())
                .into(imgPeli);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PeliculaViewHolder extends  RecyclerView.ViewHolder{
        public PeliculaViewHolder(@NonNull View itemView){
            super(itemView);

        }
    }

}
