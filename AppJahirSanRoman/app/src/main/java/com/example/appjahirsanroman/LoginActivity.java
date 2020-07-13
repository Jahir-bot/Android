package com.example.appjahirsanroman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etUser, etPassword;
    private Button btnIngresar;
    private Alumno alumno=new Alumno();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUser = findViewById(R.id.etUser);
        etPassword = findViewById(R.id.etPassword);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnIngresar:{
                ArrayList<Alumno> lista = new ArrayList<>();
                lista.add(new Alumno("a1715389",
                        "75440415",
                        "Jahir San Roman",
                        "Desarrollo de Sistemas de Información",
                        "V"));
                lista.add(new Alumno("a1715390",
                        "75440426",
                        "Raphael Roman",
                        "Corte y Confección",
                        "IV"));
                lista.add(new Alumno("a1715391",
                        "75440437",
                        "Stefany Ponce",
                        "Arquitectura",
                        "VI"));

                String user = etUser.getText().toString();
                String pass = etPassword.getText().toString();
                boolean si=false;

                for (int i=0;i<lista.size();i++)
                {
                    Alumno alumno = lista.get(i);
                    if (alumno.getCodigo().equals(user) && alumno.getPassword().equals(pass))
                    {
                        Intent intent = new Intent(this,MainActivity.class);
                        startActivity(intent);
                        si=true;
                        break;
                    }
                }
                if (si==false)
                {
                    Toast.makeText(this,"El Usuario y/o Password ingresado son incorrectos",Toast.LENGTH_LONG).show();
                    etUser.setText("");
                    etPassword.setText("");
                }



            }break;
        }
    }
}