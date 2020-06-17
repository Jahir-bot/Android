package com.android.jahir.appexamenestudioexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnRegistro, btnFormulario, btnListados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegistro = (Button) findViewById(R.id.btnRegistrar);
        btnFormulario = findViewById(R.id.btnFormulario);
        btnListados = findViewById(R.id.btnListados);
        btnRegistro.setOnClickListener(this);
        btnFormulario.setOnClickListener(this);
        btnListados.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnRegistrar: {
                Intent registro = new Intent(this,RegistroActivity.class);
                startActivity(registro);
            }break;
            case R.id.btnFormulario:{
                Intent formulario = new Intent(this,CuestionarioCovidActivity.class);
                startActivity(formulario);
            }break;
            case R.id.btnListados:{
                Intent listados = new Intent(this, ListadoConciertoActivity.class);
                startActivity(listados);
            }break;
        }
    }
}
