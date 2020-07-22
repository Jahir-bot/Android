package com.example.apppokemongo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apppokemongo.adapters.PokemonAdapters;
import com.example.apppokemongo.model.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    private Pokemon pokemon;
    private ArrayList<Pokemon> listPokemon;
    private RequestQueue requestQueue;

    private String urlPokemon = "https://pokeapi.co/api/v2/pokemon/";
    private RecyclerView rvPokemon;
    private PokemonAdapters pokemonAdapters;
    private boolean puedeCargar =false;
    private String nextUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPokemon = findViewById(R.id.rvPokemon);
        requestQueue = Volley.newRequestQueue(this);
        pokemonAdapters = new PokemonAdapters(this);
        rvPokemon.setAdapter(pokemonAdapters);
        rvPokemon.setLayoutManager(new GridLayoutManager(MainActivity.this,3));
        rvPokemon.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy>0)
                {
                    int itemsVisibles = rvPokemon.getLayoutManager().getChildCount();
                    int itemsTotales = rvPokemon.getLayoutManager().getItemCount();
                    int primerItemVisible = ((GridLayoutManager)rvPokemon.getLayoutManager())
                            .findFirstVisibleItemPosition();

                    if (puedeCargar)
                    {
                        if (itemsVisibles + primerItemVisible >= itemsTotales)
                        {
                            puedeCargar = false;
                            obtenerPokomones(nextUrl);
                        }
                    }
                }
            }
        });
        obtenerPokomones(urlPokemon);

    }

    public void obtenerPokomones(String urlPokemon)
    {
        JsonObjectRequest jsonObjectRequest=new
                JsonObjectRequest(Request.Method.GET, urlPokemon, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            nextUrl = response.getString("next");
                            JSONArray jsonArray = response.getJSONArray("results");
                            if (jsonArray.length()>0)
                            {
                                ArrayList<Pokemon> lstPokemon = new ArrayList<>();
                                puedeCargar=true;
                                for (int i=0;i<jsonArray.length();i++)
                                {
                                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                                    lstPokemon.add(new Pokemon(
                                            jsonObject.getString("name"),
                                            jsonObject.getString("url")
                                    ));
                                }
                                pokemonAdapters.addLista(lstPokemon);
                            }
                        }catch (JSONException e)
                        {
                            puedeCargar = false;
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}