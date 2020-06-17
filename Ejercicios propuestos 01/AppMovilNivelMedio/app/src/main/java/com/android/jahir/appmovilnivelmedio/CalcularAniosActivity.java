package com.android.jahir.appmovilnivelmedio;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CalcularAniosActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtFecha;
    private Button btnFecha;
    private TextView txtEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_anios);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        btnFecha = (Button) findViewById(R.id.btnFecha);
        txtEdad = (TextView) findViewById(R.id.txtEdad);
        btnFecha.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFecha: {
                if (txtFecha.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingrese la fecha por favor", Snackbar.LENGTH_LONG).show();
                } else {
                    //**********************************************
                    String fecha, dia, mes, anio;
                    int position, datodia, datomes, datoanio;
                    //Almacenamos las fechas en un String
                    fecha = txtFecha.getText().toString();
                    //Separamos las fechas
                    position = fecha.indexOf("/");
                    dia = fecha.substring(0, position);
                    fecha = fecha.substring(position + 1);
                    position = fecha.indexOf("/");
                    mes = fecha.substring(0, position);
                    fecha = fecha.substring(position + 1);
                    anio = fecha;
                    datodia = Integer.parseInt(dia);
                    datomes = Integer.parseInt(mes);
                    datoanio = Integer.parseInt(anio);

                    //Captamos la fecha actual
                    SimpleDateFormat fechahoy = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaHoyString = fechahoy.format(new Date());
                    String diahoy, meshoy, anioshoy;
                    int posicion, datodiahoy, datomeshoy, datoanioshoy;
                    posicion = fechaHoyString.indexOf("/");
                    diahoy = fechaHoyString.substring(0, posicion);
                    fechaHoyString = fechaHoyString.substring(posicion + 1);
                    posicion = fechaHoyString.indexOf("/");
                    meshoy = fechaHoyString.substring(0, posicion);
                    fechaHoyString = fechaHoyString.substring(posicion + 1);
                    anioshoy = fechaHoyString;

                    datodiahoy = Integer.parseInt(diahoy);
                    datomeshoy = Integer.parseInt(meshoy);
                    datoanioshoy = Integer.parseInt(anioshoy);
                    System.out.println(datodiahoy);
                    System.out.println(datomeshoy);
                    System.out.println(datoanioshoy);
                    int edad;
                    if (datodia >= datodiahoy && datomes <= datomeshoy) {
                        edad = datoanioshoy - datoanio;
                        txtEdad.setText("La edad es : " + edad);
                    } else if (datodia <= datodiahoy && datomes <= datomeshoy) {
                        edad = datoanioshoy - datoanio;
                        txtEdad.setText("La edad es : " + edad);
                    } else {
                        edad = (datoanioshoy - datoanio) - 1;
                        txtEdad.setText("La edad es : " + edad);
                    }
                }
            }
            break;
        }
    }
}
