package com.example.appstefanyponce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appstefanyponce.model.Paciente;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnIngresar;
    private TextInputEditText tv1, tv2;
    private List<Paciente> pacientes = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnIngresar = findViewById( R.id.btnIngresar );
        tv1 = findViewById( R.id.tvUsuario );
        tv2 = findViewById( R.id.tvPassword );

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean existeUsuario = false;
                String clave = "";

                pacientes.add( new Paciente( 10001, "stefany","Stefany Ponce", "982165428" ) );
                pacientes.add( new Paciente( 10002, "paciente","Paciente 1", "991697521" ) );
                pacientes.add( new Paciente( 10003, "paciente1","Paciente 2", "987654321" ) );

                if( tv1.getText().toString().equals( "" ) ){
                    tv1.setError("Dato Obligatorio");
                }else if( tv2.getText().toString().equals( "" ) ){
                    tv2.setError("Dato Obligatorio");
                }else{

                    int codigo = Integer.parseInt( tv1.getText().toString() );
                    String password = tv2.getText().toString();

                    /*if( codigo == 10001 && password.equals("stefany")){
                        startActivity(new Intent(MainActivity.this, menu.class));
                    }*/

                    for ( int i = 0; i < pacientes.size() ; i++ ){

                        if( pacientes.get( i ).getCodPaciente() ==  codigo ){
                            existeUsuario = true;
                            clave = pacientes.get( i ).getClave();
                            break;
                        }

                    }

                    if( existeUsuario ){

                        if( !clave.equals( password ) ){
                            Toast.makeText( getApplicationContext(),"Clave Incorrecto",Toast.LENGTH_LONG).show();
                        }else {
                            startActivity(new Intent(MainActivity.this, menu.class));
                        }

                    }else{

                        Toast.makeText( getApplicationContext(),"Usuario Incorrecto",Toast.LENGTH_LONG).show();

                    }



                }

            }
        });

    }
}