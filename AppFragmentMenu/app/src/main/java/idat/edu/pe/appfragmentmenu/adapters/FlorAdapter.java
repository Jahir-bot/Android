package idat.edu.pe.appfragmentmenu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import idat.edu.pe.appfragmentmenu.R;
import idat.edu.pe.appfragmentmenu.model.Flor;

public class FlorAdapter extends RecyclerView.Adapter<FlorAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Flor> lista;

    @NonNull
    @Override
    public FlorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context)
                .inflate(R.layout.item_flor,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FlorAdapter.ViewHolder holder, int position) {
        Flor objFlor= lista.get(position);
        holder.tvEtiqueta.setText(objFlor.getEtiqueta());
        Glide.with(context)
                .load(objFlor.getImgUrl())
                .into(holder.ivImagen);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImagen;
        TextView tvEtiqueta;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagen=itemView.findViewById(R.id.ivImagen);
            tvEtiqueta=itemView.findViewById(R.id.tvEtiqueta);
        }
    }
}
