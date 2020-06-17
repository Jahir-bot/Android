package com.android.jahir.appjahirsanroman;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeterminaAnioActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtAnio;
    private Button btnAnio;
    private TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determina_anio);
        txtAnio = (EditText) findViewById(R.id.txtAnio);
        btnAnio = (Button) findViewById(R.id.btnAnio);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnAnio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnAnio:{
                if (txtAnio.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar año",Snackbar.LENGTH_LONG).show();
                }else
                {
                    int anio;
                    anio = Integer.parseInt(txtAnio.getText().toString());
                    if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 100 == 0 && anio % 400 == 0)) {
                        txtResultado.setText("El año "+anio+" es bisiesto");
                        txtAnio.setText("");
                    } else {
                        txtResultado.setText("El año "+anio+" no es bisiesto");
                        txtAnio.setText("");
                    }
                }
            }break;
        }
    }
}
