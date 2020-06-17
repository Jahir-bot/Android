package com.android.jahir.appmovilnivelmedio;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeterminaNumeroActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtPrimo;
    private Button btnPrimo;
    private TextView txtDeterminaPrimo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determina_numero);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtPrimo = (EditText) findViewById(R.id.txtPrimo);
        btnPrimo = (Button) findViewById(R.id.btnPrimo);
        txtDeterminaPrimo = (TextView) findViewById(R.id.txtDeterminaPrimo);
        btnPrimo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPrimo: {
                if (txtPrimo.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar número",Snackbar.LENGTH_LONG).show();
                }else
                {
                    int num;
                    String res="";
                    num = Integer.parseInt(txtPrimo.getText().toString());
                    if (num%2!=0 || num==2)
                    {
                        res="El número ingresado es primo";
                        txtDeterminaPrimo.setText(res);
                    }else
                    {
                        res="El número ingresado no es primo";
                        txtDeterminaPrimo.setText(res);
                    }
                }
            }
            break;
        }
    }
}
