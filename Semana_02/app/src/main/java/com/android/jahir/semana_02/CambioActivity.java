package com.android.jahir.semana_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CambioActivity extends AppCompatActivity {

    private Button btnEjercicios,btnCiclo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio);

        btnEjercicios =(Button) findViewById(R.id.btnEjercicios);
        btnCiclo =(Button) findViewById(R.id.btnCiclo);

        btnEjercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity (new Intent(CambioActivity.this,EjerciciosActivity.class));
            }
        });
        btnCiclo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity (new Intent(CambioActivity.this,MainActivity.class));
            }
        });
    }
}
