package com.android.jahir.appmovilnivelavanzado;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeterminarCapicuaActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtCapicua;
    private Button btnCapicua;
    private TextView txtResCapicua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determinar_capicua);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtCapicua = (EditText) findViewById(R.id.txtCapicua);
        btnCapicua = (Button) findViewById(R.id.btnCapicua);
        txtResCapicua = (TextView) findViewById(R.id.txtResCapicua);
        btnCapicua.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCapicua:{
                if (txtCapicua.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar número",Snackbar.LENGTH_LONG).show();
                }else
                {
                    int num,aux,inversa=0,cifra;
                    num = Integer.parseInt(txtCapicua.getText().toString());
                    if (num>99)
                    {
                        aux=num;
                        while (aux!=0)
                        {
                            cifra=aux%10;
                            inversa = inversa*10+cifra;
                            aux=aux/10;
                        }
                        if (num==inversa)
                        {
                            txtResCapicua.setText("El número " +num+" es capicúa" );
                            txtCapicua.setText("");
                        }else
                        {
                            txtResCapicua.setText("El número " +num+" no es capicúa" );
                            txtCapicua.setText("");
                        }
                    }else
                    {
                        Snackbar.make(v,"Ingresar un número por encima de 2 dígitos",Snackbar.LENGTH_LONG).show();
                    }
                }
            }break;
        }
    }
}
