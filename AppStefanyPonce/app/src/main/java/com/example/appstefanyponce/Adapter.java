package com.example.appstefanyponce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import com.example.appstefanyponce.model.Modelo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Modelo> listaModelo;

    public Adapter(Context context)
    {
        this.context=context;
        listaModelo = new ArrayList<>();
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_galeria,parent,false);
        return new ViewHolder(view);
    }

    public void addLista(ArrayList<Modelo> lista)
    {
        listaModelo.clear();
        listaModelo.addAll(lista);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        final Modelo modelo = listaModelo.get(position);
        holder.tvCodAlbum.setText(String.valueOf(modelo.getAlbumId()));
        holder.tvId.setText(String.valueOf(modelo.getId()));
        holder.tvTitulo.setText(modelo.getTitle());
        Picasso.get().load(modelo.getThumbnailUrl()).into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        return listaModelo.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvId, tvTitulo,tvCodAlbum;
        ImageView ivFoto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvCodAlbum = itemView.findViewById(R.id.tvCodAlbum);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            ivFoto = itemView.findViewById(R.id.ivFoto);
        }
    }
}
