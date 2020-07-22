package com.example.appstefanyponce;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appstefanyponce.model.Modelo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GaleriaFragment extends Fragment {
    private RecyclerView rvLista;
    private Adapter adapter;
    private RequestQueue respuesta;
    private ArrayList<Modelo> listaModelo;
    public GaleriaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galeria, container, false);
        rvLista = view.findViewById(R.id.rvLista);

        rvLista.setLayoutManager(new GridLayoutManager(getContext(),2));
        adapter = new Adapter(getContext());
        rvLista.setAdapter(adapter);
        listaModelo= new ArrayList<>();
        respuesta = Volley.newRequestQueue(getContext());
        ConsumirWebService();

        return view;
    }

    private void ConsumirWebService() {

        String url = "https://jsonplaceholder.typicode.com/photos";
        StringRequest peticion = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String respuesta) {
                        Gson gson= new Gson();
                        JsonParser jParser = new JsonParser();
                        JsonArray aJson= jParser.parse(respuesta).getAsJsonArray();
                        System.out.println(aJson);
                        listaModelo=new ArrayList<>();

                        for (JsonElement jElement:aJson) {
                            Modelo modelo = gson.fromJson(jElement,Modelo.class);

                            if (modelo.getAlbumId()==3 || modelo.getAlbumId()==8 || modelo.getAlbumId()==12
                                    || modelo.getAlbumId()==19 || modelo.getAlbumId()==26 || modelo.getAlbumId()==89)
                            {
                                listaModelo.add(modelo);
                            }
                        }

                        adapter.addLista(listaModelo);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );

        respuesta.add(peticion);

    }
}