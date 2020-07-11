package com.example.apptiendavirtual;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apptiendavirtual.BaseDeDatos.BaseDatos_pmdm;

public class ActividadDireccion extends AppCompatActivity {
    private BaseDatos_pmdm baseDatos;
    private SQLiteDatabase operacionesBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_direccion);
        if (baseDatos==null){
            baseDatos = new BaseDatos_pmdm(getApplicationContext());
            operacionesBD = baseDatos.getWritableDatabase();
            baseDatos.asigarSQLiteDatabase(operacionesBD);

        }
    }
    public void finalizarPedido(View v){
        AlertDialog.Builder builder=null;
        EditText direccion1 = findViewById(R.id.editText);
        EditText ciudad1 = findViewById(R.id.editText2);
        EditText cp1 = findViewById(R.id.editText3);
        final String direccion = direccion1.getText().toString();
        final String ciudad = ciudad1.getText().toString();
        final String cp = cp1.getText().toString();
        Bundle extras = getIntent().getExtras();
        final String categoria = extras.getString("categoria");
        final String producto = extras.getString("producto");
        final String cantidad = extras.getString("cantidad");
        final int[] id = {0};
        if(ciudad.length()==0 || direccion.length()==0 || cp.length()==0) {
            Toast.makeText(this, "Rellena todos los datos de envío.", Toast.LENGTH_LONG).show();
        }
        else{
            builder = new AlertDialog.Builder(this)
                    .setTitle("Confirmación pedido")
                    .setMessage("RESUMEN PEDIDO:\n\t-Datos del pedido: "+producto+" "+cantidad
                    +"(cant.).\n\t-Dirección pedido: "+direccion+", "+ciudad+", "+cp+".\n\n¿DESEA CONFIRMAR EL PEDIDO?")

                    .setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Cursor cursor = operacionesBD.rawQuery("select indice from NombreLogin", null);
                            if (cursor.moveToFirst()) {
                                while (!cursor.isAfterLast()) {
                                    id[0] =cursor.getInt(0);
                                    cursor.moveToNext();
                                }
                            }


                            ContentValues nuevoRegistro = new ContentValues();
                            nuevoRegistro.put("categoria", categoria);
                            nuevoRegistro.put("producto", producto);
                            nuevoRegistro.put("cantidad", cantidad);
                            nuevoRegistro.put("idCliente", id[0]);
                            operacionesBD.insert("Pedidos", null, nuevoRegistro);
                            ContentValues nuevoRegistro2 = new ContentValues();
                            nuevoRegistro2.put("direccion", direccion);
                            nuevoRegistro2.put("ciudad", ciudad);
                            nuevoRegistro2.put("cp", cp);
                            nuevoRegistro2.put("idCliente", id[0]);
                            operacionesBD.insert("Direcciones", null, nuevoRegistro2);
                            Toast.makeText(getApplicationContext(), "¡Pedido confirmado, gracias!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), ActividadCliente.class);
                            startActivity(intent);
                        }
                    })

                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toast.makeText(getApplicationContext(),"Pedido cancelado.", Toast.LENGTH_LONG).show();
                        }
                    });

            builder.create();
            builder.show();

        }
    }
}
