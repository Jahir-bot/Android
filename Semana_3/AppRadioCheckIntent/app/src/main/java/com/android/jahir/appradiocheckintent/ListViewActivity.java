package com.android.jahir.appradiocheckintent;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private ListView ltversiones;
    private TextView txtIdListView;
    List<String> listaandroidversion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ltversiones = ( ListView ) findViewById(R.id.ltVersiones);
        txtIdListView = ( TextView ) findViewById(R.id.txtIdListView);

        Intent lista=getIntent();
        String ls = lista.getStringExtra("titulolista");
        txtIdListView.setText(ls);

        listaandroidversion = new ArrayList<>();
        listaandroidversion.add("Pie");
        listaandroidversion.add("Oreo");
        listaandroidversion.add("Nougat");
        listaandroidversion.add("Marshmallow");
        listaandroidversion.add("Kitkat");
        listaandroidversion.add("Jellybean");
        // Hacer instancia al adaptador por defecto del SO
        ArrayAdapter adapterverandroid= new ArrayAdapter(
            this,android.R.layout.simple_list_item_1,listaandroidversion
        );
        ltversiones.setAdapter(adapterverandroid);
        ltversiones.setOnItemClickListener(this);

    }
     @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if  (parent == ltversiones)
        {
            String versionandroid = listaandroidversion.get(position);
            Snackbar.make(view,"Seleccionó "+versionandroid,Snackbar.LENGTH_LONG).show();
        }
    }
}
