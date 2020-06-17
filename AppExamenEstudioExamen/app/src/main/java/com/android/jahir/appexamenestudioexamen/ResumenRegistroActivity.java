package com.android.jahir.appexamenestudioexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResumenRegistroActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtData1,txtData2,txtData3,txtData4,txtData5,txtData6;
    private Button btnIni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_registro);
        txtData1=findViewById(R.id.txtData1);
        txtData2=findViewById(R.id.txtData2);
        txtData3=findViewById(R.id.txtData3);
        txtData4=findViewById(R.id.txtData4);
        txtData5=findViewById(R.id.txtData5);
        txtData6=findViewById(R.id.txtData6);
        btnIni=findViewById(R.id.btnIni);
        btnIni.setOnClickListener(this);

        Intent var = getIntent();
        String nombre=var.getStringExtra("nombre").toString();
        String apellido=var.getStringExtra("apellido").toString();
        String direccion=var.getStringExtra("direccion").toString();
        String celular=var.getStringExtra("celular").toString();
        String deporte=var.getStringExtra("deporte").toString();
        String estado=var.getStringExtra("estado").toString();
        txtData1.setText(nombre);
        txtData2.setText(apellido);
        txtData3.setText(direccion);
        txtData4.setText(celular);
        txtData5.setText(deporte);
        txtData6.setText(estado);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnIni:{
                Intent inicio=new Intent(this,MainActivity.class);
                startActivity(inicio);
            }break;
        }
    }
}
