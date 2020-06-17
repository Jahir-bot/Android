package com.android.jahir.appradiocheckintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RadioActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtIdRadio;
    private RadioButton rdbtnHombre,rdbtnMujer,rdbtnOtro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        rdbtnHombre = (RadioButton) findViewById(R.id.rdbtnHombre);
        rdbtnMujer = (RadioButton) findViewById(R.id.rdbtnMujer);
        rdbtnOtro = (RadioButton) findViewById(R.id.rdbtnOtro);
        txtIdRadio = (TextView) findViewById(R.id.txtIdRadio);

        Intent intentRadio= getIntent();
        String titulo=intentRadio.getStringExtra("tituloradio").toString();
        txtIdRadio.setText(titulo);

        rdbtnHombre.setOnClickListener(this);
        rdbtnMujer.setOnClickListener(this);
        rdbtnOtro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.rdbtnMujer:{
                Toast.makeText(this,"Se ha seleccionado Mujer",Toast.LENGTH_LONG).show();
            }break;
            case R.id.rdbtnHombre:{
                Toast.makeText(this,"Se ha seleccionado Hombre",Toast.LENGTH_LONG).show();
            }break;
            case R.id.rdbtnOtro:{
                Toast.makeText(this,"Se ha seleccionado Otro",Toast.LENGTH_LONG).show();
            }break;
        }
    }
}
