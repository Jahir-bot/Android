package com.example.apptiendavirtual;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptiendavirtual.BaseDeDatos.BaseDatos_pmdm;

public class ActividadCliente extends AppCompatActivity {
    private BaseDatos_pmdm baseDatos;
    private SQLiteDatabase operacionesBD;
    String nombre;
    String apellidos;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_cliente);
        Toolbar toolbarCliente = (Toolbar) findViewById(R.id.toolbarCliente);
        setSupportActionBar(toolbarCliente);

        if (baseDatos==null){
            baseDatos = new BaseDatos_pmdm(getApplicationContext());
            operacionesBD = baseDatos.getWritableDatabase();
            baseDatos.asigarSQLiteDatabase(operacionesBD);
        }
        Cursor cursor = operacionesBD.rawQuery("select nombre, apellidos, indice from NombreLogin", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                nombre =cursor.getString(0);
                apellidos =cursor.getString(1);
                id =cursor.getInt(2);
                cursor.moveToNext();
            }
        }
        TextView textViewUCCabecera = findViewById(R.id.textView4);
        textViewUCCabecera.setText(nombre+ " " + apellidos );
        /*Bundle extras = getIntent().getExtras();
        String nombreUsuCaC = extras.getString("nombreUsuCabecera");
        String apellidosUsuCaC = extras.getString("apellidosUsuCabecera");
        textViewUCCabecera.setText(nombreUsuCaC+ " " + apellidosUsuCaC );*/
    }

    public void hacerPedido(View v){
        Intent intent = new Intent(this, ActividadHacerPedidos.class);
        startActivity(intent);
    }
    public void verPedidos(View v){
        Intent intent = new Intent(this, ActividadVerPedidos.class);
        startActivity(intent);
    }
    public void verCompras(View v){
        Intent intent = new Intent(this, ActividadVerCompras.class);
        startActivity(intent);
    }
    public void Salir(View v){
        Toast.makeText(this, "Sesión cerrada.", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, TiendaVirtualPrincipal.class);
        startActivity(intent);
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items_actividad_cliente, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.accion_HacerPedido:
                Intent intent = new Intent(this, ActividadHacerPedidos.class);
                startActivity(intent);
                return true;

            case R.id.accion_VerPedidos:
                Intent intent2 = new Intent(this, ActividadVerPedidos.class);
                startActivity(intent2);
                return true;
            case R.id.accion_VerCompras:
                Intent intent3 = new Intent(this, ActividadVerCompras.class);
                startActivity(intent3);
                return true;
            case R.id.accion_CerrarSesion:
                Toast.makeText(this, "Sesión cerrada.", Toast.LENGTH_LONG).show();
                Intent intent4 = new Intent(this, TiendaVirtualPrincipal.class);
                startActivity(intent4);
                finish();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
