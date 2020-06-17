package com.android.jahir.apprecyclerviewsimple;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    ArrayList<String> listadatos;

    public MyAdapter(ArrayList<String> listadatos) {
        this.listadatos = listadatos;
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.txtInfo.setText(listadatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listadatos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtInfo;

        public ViewHolder(View itemView) {
            super(itemView);
            txtInfo = itemView.findViewById(R.id.txtInfo);
        }
    }
}