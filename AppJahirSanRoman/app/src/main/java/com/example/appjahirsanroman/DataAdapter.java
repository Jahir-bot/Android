package com.example.appjahirsanroman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appjahirsanroman.Fragments.TwoFragment;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Data> listaData;

    public DataAdapter(Context context)
    {
        this.context = context;
        listaData =new ArrayList<>();
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_data,parent,false);
        return new ViewHolder(view);
    }

    public void addData(ArrayList<Data> data)
    {
        listaData.clear();
        listaData.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        System.out.println("Tamaño de data: "+listaData.size());
        final Data data = listaData.get(position);
        holder.tvPostId.setText(data.getPostId().toString());
        holder.tvId.setText(data.getId().toString());
        holder.tvName.setText(data.getName());
        holder.tvEmail.setText(data.getEmail());
        holder.tvBody.setText(data.getBody());
    }

    @Override
    public int getItemCount() {
        return listaData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPostId, tvId, tvName, tvEmail, tvBody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPostId = itemView.findViewById(R.id.tvPostId);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);;
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvBody = itemView.findViewById(R.id.tvBody);
        }
    }
}
