    package com.android.jahir.appmovilnivelbasico;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

    public class VelocidadAutoActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtVelocidad;
    private Button btnCalcularVelocidad;
    private TextView txtCalcularVelocidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocidad_auto);
        txtVelocidad = (EditText) findViewById(R.id.txtVelocidad);
        btnCalcularVelocidad = (Button) findViewById(R.id.btnCalcularVelocidad);
        txtCalcularVelocidad = (TextView) findViewById(R.id.txtCalcularVelocidad);
        btnCalcularVelocidad.setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.btnCalcularVelocidad:{
                    if (txtVelocidad.getText().toString().equals(""))
                    {
                        Snackbar.make(v,"Ingresar la velocidad",Snackbar.LENGTH_LONG).show();
                    }else
                    {
                        Double km,ms;
                        km = Double.parseDouble(txtVelocidad.getText().toString());

                        ms=km/3.6;
                        DecimalFormat formato=new DecimalFormat("#.00");
                        txtCalcularVelocidad.setText(km.toString()+"Km/h es equivalente a "+formato.format(ms)+"m/s");
                        txtVelocidad.setText("");
                    }
                }break;
            }
        }
    }
