package com.android.jahir.appexamenestudioexamen.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.jahir.appexamenestudioexamen.DetalleConciertosActivity;
import com.android.jahir.appexamenestudioexamen.R;
import com.android.jahir.appexamenestudioexamen.model.concierto;

import java.util.ArrayList;

public class conciertoAdapter extends RecyclerView.Adapter<conciertoAdapter.ViewHolder>{

    private Context context;
    private ArrayList<concierto> lista;

    public conciertoAdapter(Context context)
    {
        this.context=context;
        lista = new ArrayList<>();
    }

    @Override
    public conciertoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(
                R.layout.item_listados, parent,false);

            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(conciertoAdapter.ViewHolder holder, int position) {
        final concierto item = lista.get(position);
        holder.txtTituloConcierto.setText(item.getTitulo());
        holder.txtDescripcionConcierto.setText(item.getDescripcion());
        holder.txtFechaConcierto.setText(item.getFecha());
        holder.imgConcierto.setImageResource(item.getImagen());
        holder.cvContenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentConciertoDetalle = new Intent(context, DetalleConciertosActivity.class);
                intentConciertoDetalle.putExtra("concierto",item);
                context.startActivity(intentConciertoDetalle);
            }
        });

    }

    public void agregarElemento(ArrayList<concierto> listaConcierto)
    {
        lista.clear();
        lista.addAll(listaConcierto);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTituloConcierto,txtDescripcionConcierto, txtFechaConcierto;
        ImageView imgConcierto;
        CardView cvContenedor;
        public ViewHolder(View itemView) {
            super(itemView);
            txtTituloConcierto = itemView.findViewById(R.id.txtTituloConcierto);
            txtDescripcionConcierto = itemView.findViewById(R.id.txtDescripcionConcierto);
            txtFechaConcierto = itemView.findViewById(R.id.txtFechaConcierto);
            imgConcierto = itemView.findViewById(R.id.imgConcierto);
            cvContenedor = itemView.findViewById(R.id.cvContenedor);
        }
    }
}
