package com.android.jahir.apprecyclerviewsimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvDatos;
    ArrayList<String> listadatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvDatos = findViewById(R.id.rvDatos);
        rvDatos.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL,
                        false)
        );
        listadatos = new ArrayList<>();
        for (int i = 0;i <= 50; i++)
        {
            listadatos.add("Información: "+i);
        }
        rvDatos.setAdapter(new MyAdapter(listadatos));
    }
}
