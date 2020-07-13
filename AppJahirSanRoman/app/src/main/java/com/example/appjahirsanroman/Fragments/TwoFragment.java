package com.example.appjahirsanroman.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.*;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appjahirsanroman.Data;
import com.example.appjahirsanroman.DataAdapter;
import com.example.appjahirsanroman.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TwoFragment extends Fragment {

    private RecyclerView rvDatos;
    private DataAdapter dataAdapter;
    private RequestQueue requestQueue;
    private ArrayList<Data> listaData;


    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        rvDatos = view.findViewById(R.id.rvDatos);

        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rvDatos.setLayoutManager(new GridLayoutManager(getContext(),2));
        dataAdapter = new DataAdapter(getContext());
        rvDatos.setAdapter(dataAdapter);
        //rvDatos.setLayoutManager(gridLayoutManager);
        listaData= new ArrayList<>();
        requestQueue = Volley.newRequestQueue(getContext());
        WS();

        return view;
    }
    public void WS()
    {
        String url = "https://jsonplaceholder.typicode.com/comments";
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
                        listaData=new ArrayList<>();

                        for (JsonElement jElement:aJson) {
                            Data datos = gson.fromJson(jElement,Data.class);
                            listaData.add(datos);
                        }
                        for (int i=0;i<listaData.size();i++)
                        {
                            Data evaluar = listaData.get(i);

                            if (evaluar.getPostId()%2==0 || evaluar.getPostId()!=2 || evaluar.getPostId()==1)
                            {
                                listaData.remove(i);

                            }
                        }

                        System.out.println("IMPRIMIENDO: "+listaData);
                        dataAdapter.addData(listaData);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }
        );

        requestQueue.add(peticion);
    }
}