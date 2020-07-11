package com.example.apptiendavirtual;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.apptiendavirtual.BaseDeDatos.BaseDatos_pmdm;

import java.util.ArrayList;

public class ActividadRegistrarse extends AppCompatActivity {
    private BaseDatos_pmdm baseDatos;
    private SQLiteDatabase operacionesBD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_registrarse);

        if (baseDatos==null){
            baseDatos = new BaseDatos_pmdm(getApplicationContext());
            operacionesBD = baseDatos.getWritableDatabase();
            baseDatos.asigarSQLiteDatabase(operacionesBD);

        }
    }
    /*ArrayList de los datos a guardar.
    ArrayList<String> usuariosRC = new ArrayList<>();
    ArrayList<String> contrasRC = new ArrayList<>();
    ArrayList<String> usuariosRA = new ArrayList<>();
    ArrayList<String> contrasRA = new ArrayList<>();*/

    public void comprobarUsuariosExistentes (View v) {
        EditText editNomR = findViewById(R.id.editText4);
        String nombreUs = editNomR.getText().toString();
        EditText editApeR = findViewById(R.id.editText5);
        String apellUs = editApeR.getText().toString();
        EditText editEmailR = findViewById(R.id.editText7);
        String emailUs = editEmailR.getText().toString();
        EditText editUsu2 = findViewById(R.id.editUsuR);
        String usuarioR = editUsu2.getText().toString();
        EditText editPwsR = findViewById(R.id.editContraR);
        String contraR = editPwsR.getText().toString();
        RadioButton radioCliente = findViewById(R.id.radioButton);
        RadioButton radioAdministrador = findViewById(R.id.radioButton2);
        String tipoCliente;
        String nombre;
        ArrayList<String> todosLosNombresU= new ArrayList<String>();
        String contraBd;
        ArrayList<String> todasLasContras = new ArrayList<String>();
        int id;
        ArrayList<Integer> todosLosId = new ArrayList<Integer>();
        int id1=1;
        int idPost;
        Cursor cursor = operacionesBD.rawQuery("select _id, nombre, contra from Usuarios", null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                id =cursor.getInt(0);
                todosLosId.add(id);
                nombre = cursor.getString(1);
                todosLosNombresU.add(nombre);
                contraBd = cursor.getString(2);
                todasLasContras.add(contraBd);
                cursor.moveToNext();
            }
        }
        if(radioCliente.isChecked() && usuarioR.length()!=0 &&
                contraR.length()!=0 && nombreUs.length()!=0 && apellUs.length()!=0 && emailUs.length()!=0 ||
                radioAdministrador.isChecked() && usuarioR.length()!=0 && contraR.length()!=0
                        && nombreUs.length()!=0 && apellUs.length()!=0 && emailUs.length()!=0 ) {
            if(todosLosNombresU.contains(usuarioR)/*|| usuariosRA.contains(usuarioR)*/) {
                Toast.makeText(this, "El usuario introducido ya existe." +
                        " Inténtelo de nuevo con otro nombre", Toast.LENGTH_LONG).show();
                editUsu2.setText("");
                editPwsR.setText("");
            }
            else{
                if (radioCliente.isChecked()) {
                    tipoCliente= "Cliente";
                    idPost= todosLosId.size()+ id1;
                    ContentValues nuevoRegistro = new ContentValues();
                    nuevoRegistro.put("_id", idPost);
                    nuevoRegistro.put("usuario",usuarioR);
                    nuevoRegistro.put("contra",contraR);
                    nuevoRegistro.put("nombre",nombreUs);
                    nuevoRegistro.put("apellidos",apellUs);
                    nuevoRegistro.put("email",emailUs);
                    nuevoRegistro.put("tipoCliente",tipoCliente);
                    operacionesBD.insert("Usuarios", null, nuevoRegistro);
                    //usuariosRC.add(usuarioR);
                    //contrasRC.add(contraR);
                }
                else if(radioAdministrador.isChecked()){
                    tipoCliente= "Administrador";
                    idPost= todosLosId.size()+ id1;
                    ContentValues nuevoRegistro = new ContentValues();
                    nuevoRegistro.put("_id", idPost);
                    nuevoRegistro.put("usuario",usuarioR);
                    nuevoRegistro.put("contra",contraR);
                    nuevoRegistro.put("nombre",nombreUs);
                    nuevoRegistro.put("apellidos",apellUs);
                    nuevoRegistro.put("email",emailUs);
                    nuevoRegistro.put("tipoCliente",tipoCliente);
                    operacionesBD.insert("Usuarios", null, nuevoRegistro);
                    //usuariosRA.add(usuarioR);
                    //contrasRA.add(contraR);
                }
                Intent intent = new Intent(this, TiendaVirtualPrincipal.class);
                Toast.makeText(this, "¡El usuario -"+ usuarioR+"- ha sido creado con éxito!"
                        ,Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        }
        else if(usuarioR.length()!=0 &&
                contraR.length()!=0 && nombreUs.length()!=0 && apellUs.length()!=0 && emailUs.length()!=0){
            Toast.makeText(this, "¡Selecciona también el tipo de usuario!",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "¡Introduce todos los datos!  ",Toast.LENGTH_LONG).show();
        }
    }
}
