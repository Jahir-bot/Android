package com.android.jahir.apprecyclerviewsimple;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAndroid extends RecyclerView.Adapter<AdapterAndroid.ViewHolder>{

    ArrayList<String> listadatos;

    public AdapterAndroid(ArrayList<String> listadatos)
    {
        this.listadatos=listadatos;
    }

    @Override
    public AdapterAndroid.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vie = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list,null,false);
        return null;
    }

    @Override
    public void onBindViewHolder(AdapterAndroid.ViewHolder holder, int position) {
        holder.txtDatos.setText(listadatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listadatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtDatos;
        public ViewHolder(View itemView) {
            super(itemView);
            txtDatos = itemView.findViewById(R.id.txtInfo);
        }
    }
}
