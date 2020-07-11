package com.example.apptiendavirtual.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apptiendavirtual.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.DatosPedidosViewHolder> {
    private List<DatosVerPedidos> items;


    public static class DatosPedidosViewHolder extends RecyclerView.ViewHolder {
        TextView pedido;
        TextView direccion;
        public DatosPedidosViewHolder(View v) {
            super(v);
            pedido = (TextView) v.findViewById(R.id.pedido);
            direccion = (TextView) v.findViewById(R.id.direccion);
        }
    }

    public RecyclerViewAdapter(List<DatosVerPedidos> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public DatosPedidosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout_ver_pedidos, viewGroup, false);
        return new DatosPedidosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DatosPedidosViewHolder viewHolder, int i) {
        viewHolder.pedido.setText("Pedido: "+String.valueOf(items.get(i).getPedido()));
        viewHolder.direccion.setText("Dirección: "+String.valueOf(items.get(i).getDireccion()));
    }
}
