package com.example.apptiendavirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.apptiendavirtual.BaseDeDatos.BaseDatos_pmdm;

public class ActividadHacerPedidos extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerCat, spinnerPro;
    private BaseDatos_pmdm baseDatos;
    private SQLiteDatabase operacionesBD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_hacer_pedidos);
        if (baseDatos==null){
            baseDatos = new BaseDatos_pmdm(getApplicationContext());
            operacionesBD = baseDatos.getWritableDatabase();
            baseDatos.asigarSQLiteDatabase(operacionesBD);

        }
        spinnerCat =  findViewById(R.id.spinnerCategorias);
        spinnerPro = findViewById(R.id.spinnerProductos);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categorias_ud02_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCat.setAdapter(adapter);
        spinnerCat.setOnItemSelectedListener(this);
        //spinner para la cantidad a comprar
        Spinner spinnerCan = findViewById(R.id.spinnerCantidad);
        Integer[] items = new Integer[]{1,2,3,4,5};
        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item, items);
        spinnerCan.setAdapter(adapter2);

    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        int[] productos={R.array.productos_ud02_spinner, R.array.productos2_ud02_spinner,
                R.array.productos3_ud02_spinner};
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                productos[pos],android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerPro.setAdapter(adapter);
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void confirmarPedido (View v){
        int id = 0;
        Cursor cursor = operacionesBD.rawQuery("select indice from NombreLogin", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                id =cursor.getInt(0);
                cursor.moveToNext();
            }
        }
        Intent intent = new Intent(this, ActividadDireccion.class);
        Spinner spinner1 =  findViewById(R.id.spinnerCategorias);
        Spinner spinner2 =  findViewById(R.id.spinnerProductos);
        Spinner spinner3 =  findViewById(R.id.spinnerCantidad);
        String categoria = spinner1.getSelectedItem().toString();
        String producto = spinner2.getSelectedItem().toString();
        String cantidad = spinner3.getSelectedItem().toString();
        intent.putExtra("categoria", categoria);
        intent.putExtra("producto", producto);
        intent.putExtra("cantidad", cantidad);
        startActivity(intent);
    }



}
