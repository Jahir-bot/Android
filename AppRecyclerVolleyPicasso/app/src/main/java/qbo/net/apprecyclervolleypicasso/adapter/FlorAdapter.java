package qbo.net.apprecyclervolleypicasso.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import qbo.net.apprecyclervolleypicasso.R;
import qbo.net.apprecyclervolleypicasso.model.Flor;

public class FlorAdapter
        extends RecyclerView.Adapter<FlorAdapter.ViewHolder>
{
    private Context context;
    private ArrayList<Flor> listflor;

    public FlorAdapter(Context context) {
        this.context = context;
        listflor = new ArrayList<>();
    }

    @NonNull
    @Override
    public FlorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_flor, parent, false);
        return new ViewHolder(view);
    }
    public void agregarelementos(ArrayList<Flor> data){
        listflor.clear();
        listflor.addAll(data);
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull FlorAdapter.ViewHolder holder, int position) {
        final Flor itemflor = listflor.get(position);
        holder.tvusuario.setText(itemflor.getUser());
        holder.tvtags.setText(itemflor.getTag());
        Picasso.get().load(itemflor.getImageurl()).into(holder.ivimagenflor);
    }
    @Override
    public int getItemCount() {
        return listflor.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivimagenflor;
        TextView tvtags, tvusuario;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivimagenflor = itemView.findViewById(R.id.ivimagenflor);
            tvtags = itemView.findViewById(R.id.tvtags);
            tvusuario = itemView.findViewById(R.id.tvusuario);
        }
    }
}
