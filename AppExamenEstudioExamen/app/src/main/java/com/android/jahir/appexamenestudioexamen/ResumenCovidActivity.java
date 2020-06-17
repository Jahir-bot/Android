package com.android.jahir.appexamenestudioexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResumenCovidActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtCovid1, txtCovid2, txtCovid3, txtCovid4,txtCovid5;
    private Button btnInicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_covid);
        txtCovid1 = findViewById(R.id.txtCovid1);
        txtCovid2 = findViewById(R.id.txtCovid2);
        txtCovid3 = findViewById(R.id.txtCovid3);
        txtCovid4 = findViewById(R.id.txtCovid4);
        txtCovid5 = findViewById(R.id.txtCovid5);
        btnInicio = findViewById(R.id.btnInicio);
        btnInicio.setOnClickListener(this);


        Intent var= getIntent();
        String sintomas = var.getStringExtra("sintomas");
        String fiebre = var.getStringExtra("fiebre");
        String solo = var.getStringExtra("solo");
        String adulto = var.getStringExtra("adulto");
        String servicios = var.getStringExtra("servicios");
        txtCovid1.setText(sintomas);
        txtCovid2.setText(fiebre);
        txtCovid3.setText(solo);
        txtCovid4.setText(adulto);
        txtCovid5.setText(servicios);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnInicio:{
                Intent inicio = new Intent(this,MainActivity.class);
                startActivity(inicio);
            }break;
        }
    }
}
