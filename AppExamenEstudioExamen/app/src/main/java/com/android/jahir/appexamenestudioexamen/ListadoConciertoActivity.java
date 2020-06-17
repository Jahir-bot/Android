package com.android.jahir.appexamenestudioexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.jahir.appexamenestudioexamen.adapters.conciertoAdapter;
import com.android.jahir.appexamenestudioexamen.model.concierto;

import java.util.ArrayList;

public class ListadoConciertoActivity extends AppCompatActivity {
    private RecyclerView rvConcierto;
    private conciertoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_concierto);
        rvConcierto = findViewById(R.id.rvConcierto);
        rvConcierto.setLayoutManager(new LinearLayoutManager(ListadoConciertoActivity.this));
        adapter = new conciertoAdapter(ListadoConciertoActivity.this);
        rvConcierto.setAdapter(adapter);

        ArrayList<concierto> lista = new ArrayList<>();
        lista.add(new concierto(
                lista.size()+1,
                R.drawable.toronto,
                "Toronto SARS Benefit",
                "The Rolling Stones, AC/DC y Justin Timberlake.",
                "01/05/2003"
        ));
        lista.add(new concierto(
                lista.size()+1,
                R.drawable.bts,
                "BTS – LOVE YOURSELF",
                "Concierto con artistas coreanos en el género K-POP",
                "14/04/2019"
        ));
        lista.add(new concierto(
                lista.size()+1,
                R.drawable.armonia10,
                "Concierto de Armonia 10 de Piura",
                "Orquestas que recorre el Peru y el muno",
                "30/05/2017"
        ));
        lista.add(new concierto(
                lista.size()+1,
                R.drawable.jhosimar,
                "Jhosimar y su Yambú",
                "Salsa Perucha",
                "01/10/2020"
        ));
        lista.add(new concierto(
                lista.size()+1,
                R.drawable.salserin,
                "Salserín",
                "Orquestas juvenil y su salsa romántica",
                "01/09/2016"
        ));
        lista.add(new concierto(
                lista.size()+1,
                R.drawable.aguamarina,
                "Agua Marina",
                "Orquesta de cumbia peruana",
                "14/05/2019"
        ));
        lista.add(new concierto(
                lista.size()+1,
                R.drawable.chacalon,
                "Chacalón",
                "Cuando chacalón canta los cerros bajan",
                "01/07/2001"
        ));
        lista.add(new concierto(
                lista.size()+1,
                R.drawable.bob,
                "Tributo al Regge",
                "El último concierto",
                "23/08/1980"
        ));
        lista.add(new concierto(
                lista.size()+1,
                R.drawable.rapper,
                "Rapper School",
                "Improvisando con la Lírica",
                "01/03/2002"
        ));
        lista.add(new concierto(
                lista.size()+1,
                R.drawable.anuel,
                "Anuel AA",
                "Concierto del Bebecito",
                "19/04/2019"
        ));
        adapter.agregarElemento(lista);
    }
}
