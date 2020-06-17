package com.android.jahir.appradiocheckintent;

import android.content.Intent;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txtIdCheck;
    private CheckBox chkDeporte, chkVideoJuegos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        txtIdCheck = ( TextView ) findViewById(R.id.txtIdCheck);
        chkDeporte = ( CheckBox ) findViewById(R.id.chkDeporte);
        chkVideoJuegos = ( CheckBox ) findViewById(R.id.chkVideoJuegos);

        Intent intentCheck = getIntent();
        String titulo = intentCheck.getStringExtra("titulocheck");
        txtIdCheck.setText(titulo);

        chkDeporte.setOnClickListener(this);
        chkVideoJuegos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        CheckBox chk=null;
        boolean chekeando=false;
        switch (v.getId()){
            case R.id.chkDeporte:{
                chk = (CheckBox)v;
                chekeando=chk.isChecked();
                if (chekeando){
                    Snackbar.make(v,"Se ha marcado Deporte",Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(v,"Se ha desmarcado Deporte",Snackbar.LENGTH_LONG).show();
                }
            }break;
            case R.id.chkVideoJuegos:{
                chk = (CheckBox)v;
                chekeando=chk.isChecked();
                if (chekeando){
                    Snackbar.make(v,"Se ha marcado Video Juegos",Snackbar.LENGTH_LONG).show();
                }else{
                    Snackbar.make(v,"Se ha desmarcado Deporte",Snackbar.LENGTH_LONG).show();
                }
            }break;
        }
    }
}
