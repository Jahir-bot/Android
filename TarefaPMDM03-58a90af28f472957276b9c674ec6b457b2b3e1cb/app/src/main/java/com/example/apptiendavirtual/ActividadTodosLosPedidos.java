package com.example.apptiendavirtual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptiendavirtual.Adaptadores.DatosVerPedidos;
import com.example.apptiendavirtual.Adaptadores.RecyclerViewAdapterTodosLosPedidos;
import com.example.apptiendavirtual.BaseDeDatos.BaseDatos_pmdm;

import java.util.ArrayList;
import java.util.List;

public class ActividadTodosLosPedidos extends AppCompatActivity {
    private BaseDatos_pmdm baseDatos;
    private SQLiteDatabase operacionesBD;
    String direccion;
    String ciudad;
    String cp;
    String categoria;
    String producto;
    int cantidad;
    String nPedido;
    String direccion2;
    String idCliente;
    List<DatosVerPedidos> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_todos_los_pedidos);
        Button confirmar = findViewById(R.id.button13);
        Button rechazar = findViewById(R.id.button14);
        if (baseDatos==null){
            baseDatos = new BaseDatos_pmdm(getApplicationContext());
            operacionesBD = baseDatos.getWritableDatabase();
            baseDatos.asigarSQLiteDatabase(operacionesBD);
        }
        Cursor cursor = operacionesBD.rawQuery("select d.direccion, d.ciudad, d.cp," +
                " p.categoria, p.producto, p.cantidad, d._id, p._id from direcciones d, pedidos p where d._id=p._id", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                direccion =cursor.getString(0);
                ciudad =cursor.getString(1);
                cp =cursor.getString(2);
                categoria =cursor.getString(3);
                producto =cursor.getString(4);
                cantidad =cursor.getInt(5);
                nPedido = cursor.getString(6);
                items.add(new DatosVerPedidos(categoria+", "+producto+", "+cantidad+ "(cant.)",
                        direccion+", "+ciudad+", "+cp, nPedido));
                cursor.moveToNext();
            }
        }

        RecyclerViewAdapterTodosLosPedidos recycleAdapter2 = new RecyclerViewAdapterTodosLosPedidos(items);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,1);
        RecyclerView recyclerView2 = findViewById(R.id.rvwRecycleView2);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(recycleAdapter2);

    }
    public void actualizar(View v) {
         recreate();
         Toast.makeText(v.getContext(),"¡Actualizado!",Toast.LENGTH_SHORT).show();
    }

}
