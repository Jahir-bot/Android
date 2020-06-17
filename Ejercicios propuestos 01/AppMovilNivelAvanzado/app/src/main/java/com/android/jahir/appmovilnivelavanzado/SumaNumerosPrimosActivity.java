package com.android.jahir.appmovilnivelavanzado;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SumaNumerosPrimosActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtSerie;
    private Button btnSerie;
    private TextView txtSerieN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma_numeros_primos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtSerie = (EditText) findViewById(R.id.txtSerie);
        txtSerieN =(TextView) findViewById(R.id.txtSerieN);
        btnSerie = (Button) findViewById(R.id.btnSerie);
        btnSerie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSerie:{
                if (txtSerie.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar número",Snackbar.LENGTH_LONG).show();
                }else
                {
                    int num,suma=0;
                    num = Integer.parseInt(txtSerie.getText().toString());

                    for (int i=1;i<=num;i++)
                    {
                        if (i%2!=0 || i==2)
                        {
                            suma+=i;
                        }
                    }
                    txtSerieN.setText("La suma de la serie es : "+suma);
                    txtSerie.setText("");
                }
            } break;
        }
    }
}
