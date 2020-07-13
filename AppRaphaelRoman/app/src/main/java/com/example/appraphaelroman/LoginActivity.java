package com.example.appraphaelroman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etUsuario, etContra;
    private Button btnIngresar;
    ArrayList<Administrador> listaAdmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etContra = findViewById(R.id.etContra);
        etUsuario = findViewById(R.id.etUsuario);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnIngresar:{

                listaAdmin = new ArrayList<>();

                listaAdmin.add(new Administrador("a01",
                        "12345678",
                        "Jose",
                        "Perez"));
                listaAdmin.add(new Administrador("a02",
                        "987654321",
                        "Andres",
                        "Hurtado"));
                listaAdmin.add(new Administrador("a03",
                        "654321987",
                        "Leaonel",
                        "Messi"));

                String user = etUsuario.getText().toString();
                String pass = etContra.getText().toString();
                String pasar="denegado";

                for (int i=0;i<listaAdmin.size();i++)
                {
                    Administrador busca=listaAdmin.get(i);
                    if (busca.getCodigo().equals(user) && busca.getPassword().equals(pass))
                    {
                        Intent intent = new Intent(this,MainActivity.class);
                        startActivity(intent);
                        pasar="acceso";
                        break;
                    }
                }
                if (pasar.equals("denegado"))
                {
                    Toast.makeText(this,"Codigo y Password incorrectos",Toast.LENGTH_LONG).show();
                }
            }break;
        }
    }
}