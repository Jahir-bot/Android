package com.example.apptiendavirtual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.apptiendavirtual.Adaptadores.DatosVerPedidos;
import com.example.apptiendavirtual.Adaptadores.RecyclerViewAdapter;
import com.example.apptiendavirtual.BaseDeDatos.BaseDatos_pmdm;

import java.util.ArrayList;
import java.util.List;

public class ActividadVerCompras extends AppCompatActivity {
    private BaseDatos_pmdm baseDatos;
    private SQLiteDatabase operacionesBD;
    String direccion;
    String ciudad;
    String cp;
    String categoria;
    String producto;
    int cantidad;

    List<DatosVerPedidos> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_ver_compras);

        if (baseDatos==null){
            baseDatos = new BaseDatos_pmdm(getApplicationContext());
            operacionesBD = baseDatos.getWritableDatabase();
            baseDatos.asigarSQLiteDatabase(operacionesBD);
        }
        Cursor cursor = operacionesBD.rawQuery("select c.direccion, c.ciudad, c.cp," +
                " c.categoria, c.producto, c.cantidad," +
                "  c._id, c.idCliente, n.indice from Confirmados c, NombreLogin n " +
                "where n.indice = c.idCliente ", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                direccion =cursor.getString(0);
                ciudad =cursor.getString(1);
                cp =cursor.getString(2);
                categoria =cursor.getString(3);
                producto =cursor.getString(4);
                cantidad =cursor.getInt(5);
                items.add(new DatosVerPedidos(categoria+", "+producto+", "+cantidad+ "(cant.)" ,
                        direccion+", "+ciudad+", "+cp, null));
                cursor.moveToNext();
            }
        }

        RecyclerViewAdapter recycleAdapter = new RecyclerViewAdapter(items);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        RecyclerView recyclerView = findViewById(R.id.rvwRecycleView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recycleAdapter);
    }

}
