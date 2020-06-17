package com.android.jahir.semana_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class EjerciciosActivity extends AppCompatActivity {

    private EditText etTalla;
    private EditText etPeso;
    private Button btnCalcular;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicios);
        etTalla = (EditText) findViewById(R.id.etTalla);
        etPeso = (EditText) findViewById(R.id.etPeso);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        tvResultado = (TextView) findViewById(R.id.tvResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etTalla.getText().toString().equals("")) {
                    etTalla.setError("Ingrese su peso");
                } else if (etPeso.getText().toString().equals("")) {
                    etPeso.setError("Ingrese su talla");
                } else {
                    Double peso, talla, tallam, imc;
                    String resultadoIMC = "";
                    talla = Double.parseDouble(etTalla.getText().toString());
                    peso = Double.parseDouble(etPeso.getText().toString());
                    tallam = talla / 100;
                    imc = peso / (tallam * tallam);
                    if (imc <= 18.5) {
                        resultadoIMC = "Por debajo del peso";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCBajo));
                    } else if (imc <= 25) {
                        resultadoIMC = "Con peso normal";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCNormal));
                    } else if (imc <= 30) {
                        resultadoIMC = "Con sobrepeso";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCsOBREpESO));
                    } else if (imc <= 35) {
                        resultadoIMC = "Con sobrepeso leve";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCObesidad1));
                    } else if (imc <= 39) {
                        resultadoIMC = "Con sobrepeso media";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCObesidad2));
                    } else {
                        resultadoIMC = "Con sobrepeso morbida";
                        tvResultado.setTextColor(getResources().getColor(R.color.colorIMCObesidad3));
                    }
                    DecimalFormat formato=new DecimalFormat("#.00");
                    tvResultado.setText("Su IMC es : " + formato.format(imc) + " usted se encuentra : " + resultadoIMC.toString());
                }

            }
        });

    }
}
