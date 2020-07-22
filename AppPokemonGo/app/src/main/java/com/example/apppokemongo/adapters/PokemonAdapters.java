package com.example.apppokemongo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.apppokemongo.R;
import com.example.apppokemongo.model.Pokemon;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PokemonAdapters extends RecyclerView.Adapter<PokemonAdapters.ViewHolher> {

    private ArrayList<Pokemon> listPokemon;
    private Context context;

    public PokemonAdapters(Context context)
    {
        this.context=context;
        listPokemon = new ArrayList<>();
    }

    @NonNull
    @Override
    public PokemonAdapters.ViewHolher onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_pokemon,parent,false);
        return new ViewHolher(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapters.ViewHolher holder, int position) {
        final Pokemon pokemon = listPokemon.get(position);
        holder.tvNombrePokemon.setText(pokemon.getNombre());
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
                        +pokemon.getId()+".png")
                .into(holder.ivPokemon);
    }
    public void addLista(ArrayList<Pokemon> lista)
    {
        listPokemon.addAll(lista);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return listPokemon.size();
    }

    public class ViewHolher extends RecyclerView.ViewHolder {
        private ImageView ivPokemon;
        private TextView tvNombrePokemon;
        public ViewHolher(@NonNull View itemView) {
            super(itemView);
            ivPokemon = itemView.findViewById(R.id.ivPokemon);
            tvNombrePokemon = itemView.findViewById(R.id.tvNombrePokemon);
        }
    }
}
