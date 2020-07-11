package com.example.apptiendavirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.apptiendavirtual.BaseDeDatos.BaseDatos_pmdm;

import java.util.ArrayList;

public class TiendaVirtualPrincipal extends AppCompatActivity {
    private BaseDatos_pmdm baseDatos;
    private SQLiteDatabase operacionesBD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (baseDatos==null){
            baseDatos = new BaseDatos_pmdm(getApplicationContext());
            operacionesBD = baseDatos.getWritableDatabase();
            baseDatos.asigarSQLiteDatabase(operacionesBD);
        }

    }
    protected void onDestroy() {
        baseDatos.close();
        super.onDestroy();
    }

    public void registro (View v){
        Intent intent = new Intent(this, ActividadRegistrarse.class);
        startActivity(intent);
    }

    public void comprobarLogin (View v){

        //Bundle extras = getIntent().getExtras();
        /*String nombreUsuR = extras.getString("nombreUsuR");
        String apellUsuR = extras.getString("apellidosUsuR");
        ArrayList <String> usuariosRCL = (ArrayList<String>) getIntent().getSerializableExtra("usuariosCliente");
        ArrayList <String> contrasRCL = (ArrayList<String>) getIntent().getSerializableExtra("contrasCliente");
        ArrayList <String> usuariosRAd = (ArrayList<String>) getIntent().getSerializableExtra("usuariosAdministrador");
        ArrayList <String> contrasRAd = (ArrayList<String>) getIntent().getSerializableExtra("contrasAdministrador");*/
        EditText editUsu = findViewById(R.id.editUsuario);
        String usuario = editUsu.getText().toString();
        EditText editPws = findViewById(R.id.editContra);
        String contra = editPws.getText().toString();
        String nombreUsuario;
        ArrayList<String> todosLosNombresU= new ArrayList<String>();
        String contraBd;
        ArrayList<String> todasLasContras = new ArrayList<String>();
        ArrayList<String> todosLosId = new ArrayList<String>();
        String cliente="Cliente";
        String administrador ="Administrador";
        String tipoClienteBd;
        String id;
        String nombre;
        String apellidos;
        ArrayList<String> todosLosTipoCliente = new ArrayList<String>();
        ArrayList<String> todoNombres = new ArrayList<String>();
        ArrayList<String> todoApellidos = new ArrayList<String>();

        Cursor cursor = operacionesBD.rawQuery("select _id, usuario, contra, tipoCliente, nombre, apellidos from Usuarios", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                id =cursor.getString(0);
                todosLosId.add(id);
                nombreUsuario = cursor.getString(1);
                todosLosNombresU.add(nombreUsuario);
                contraBd = cursor.getString(2);
                todasLasContras.add(contraBd);
                tipoClienteBd = cursor.getString(3);
                todosLosTipoCliente.add(tipoClienteBd);
                nombre = cursor.getString(4);
                todoNombres.add(nombre);
                apellidos = cursor.getString(5);
                todoApellidos.add(apellidos);
                cursor.moveToNext();
             }
        }
        //Si el usuario y contraseña son correctos y el tipo de cliente introducido es "Cliente" se ejecuta la ActividadCliente.
        if(todosLosNombresU.contains(usuario) && contra.equals(todasLasContras.get(todosLosNombresU.indexOf(usuario)))
                && cliente.equals(todosLosTipoCliente.get(todosLosNombresU.indexOf(usuario)))){
            int id2=todosLosNombresU.indexOf(usuario);
            String nombre2= todoNombres.get(todosLosNombresU.indexOf(usuario));
            String apellidos2= todoApellidos.get(todosLosNombresU.indexOf(usuario));
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("nombre", nombre2);
            nuevoRegistro.put("apellidos", apellidos2);
            nuevoRegistro.put("indice", id2);
            String condicionwhere = "_id=?";
            String[] parametros = new String[]{String.valueOf(0)};
            operacionesBD.update("NombreLogin",nuevoRegistro,condicionwhere,parametros);
            Toast.makeText(this, "Login correcto.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ActividadCliente.class);
            //intent.putExtra("nombreUsuCabecera", nombreCompleto);
            startActivity(intent);
        }
        //Si el usuario y contraseña son correctos y el tipo de cliente introducido es "Administrador" se ejecuta la ActividadAdministrador.
        else if(todosLosNombresU.contains(usuario) && contra.equals(todasLasContras.get(todosLosNombresU.indexOf(usuario)))
                && administrador.equals(todosLosTipoCliente.get(todosLosNombresU.indexOf(usuario)))){
            int id2=todosLosNombresU.indexOf(usuario);
            String nombre2= todoNombres.get(todosLosNombresU.indexOf(usuario));
            String apellidos2= todoApellidos.get(todosLosNombresU.indexOf(usuario));
            ContentValues nuevoRegistro = new ContentValues();
            nuevoRegistro.put("nombre", nombre2);
            nuevoRegistro.put("apellidos", apellidos2);
            nuevoRegistro.put("indice", id2);
            String condicionwhere = "_id=?";
            String[] parametros = new String[]{String.valueOf(0)};
            operacionesBD.update("NombreLogin",nuevoRegistro,condicionwhere,parametros);
            Toast.makeText(this, "Login correcto.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ActividadAdministrador.class);
            //intent.putExtra("nombreUsuCabecera", nombreUsuR);
            //intent.putExtra("apellidosUsuCabecera", apellUsuR);
            startActivity(intent);
        }
        else if(usuario.length()==0 || contra.length()==0) {
            Toast.makeText(this, "Introduce el usuario y contraseña para hacer login.",
                    Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Usuarios y/o contraseña incorrecto/s. Vuelve a intentarlo.",
                    Toast.LENGTH_LONG).show();
            editUsu.setText("");
            editPws.setText("");
        }
    }
}
