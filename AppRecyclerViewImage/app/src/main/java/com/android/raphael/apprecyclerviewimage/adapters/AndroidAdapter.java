package com.android.raphael.apprecyclerviewimage.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.raphael.apprecyclerviewimage.DetalleAndroidActivity;
import com.android.raphael.apprecyclerviewimage.R;
import com.android.raphael.apprecyclerviewimage.model.Android;

import java.util.ArrayList;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Android> lista;

    public AndroidAdapter(Context context) {
        this.context = context;
        lista = new ArrayList<>();
    }

    @Override
    public AndroidAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(context).inflate(
               R.layout.item_android, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AndroidAdapter.ViewHolder holder, int position) {
        final Android item = lista.get(position);
        holder.txtNombreAndroid.setText(item.getNombre());
        holder.txtVersionAndroid.setText(item.getVersion());
        holder.imgAndroid.setImageResource(item.getImagen());
        holder.cvContenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAndroidDetalle = new Intent(context, DetalleAndroidActivity.class);
                intentAndroidDetalle.putExtra("android",item);
                context.startActivity(intentAndroidDetalle);
            }
        });
    }

    public void agregarElemento(ArrayList<Android> listaAndroid)
    {
        lista.clear();
        lista.addAll(listaAndroid);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAndroid;
        TextView txtNombreAndroid,txtVersionAndroid;
        CardView cvContenedor;
        public ViewHolder(View itemView) {
            super(itemView);
            imgAndroid = itemView.findViewById(R.id.imgAndroid);
            txtNombreAndroid = itemView.findViewById(R.id.txtNombreAndroid);
            txtVersionAndroid = itemView.findViewById(R.id.txtVersionAndroid);
            cvContenedor = itemView.findViewById(R.id.cvContenedor);
        }
    }
}