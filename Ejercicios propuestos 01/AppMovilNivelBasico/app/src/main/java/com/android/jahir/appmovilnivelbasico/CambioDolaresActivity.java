package com.android.jahir.appmovilnivelbasico;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CambioDolaresActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtSoles,txtTipoCambio;
    private Button btnCalcularCambio;
    private TextView txtCalcularCambio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambio_dolares);
        txtSoles = (EditText) findViewById(R.id.txtSoles);
        txtTipoCambio = (EditText) findViewById(R.id.txtTipoCambio);
        btnCalcularCambio = (Button) findViewById(R.id.btnCalcularCambio);
        txtCalcularCambio = (TextView) findViewById(R.id.txtCalcularCambio);
        btnCalcularCambio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCalcularCambio:{
                if (txtSoles.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar el monto",Snackbar.LENGTH_LONG).show();
                }else if (txtTipoCambio.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar el tipo de cambio",Snackbar.LENGTH_LONG).show();
                }else
                {
                    Double soles,dolares,cambio;
                    soles = Double.parseDouble(txtSoles.getText().toString());
                    dolares = Double.parseDouble(txtTipoCambio.getText().toString());
                    cambio=soles/dolares;
                    DecimalFormat formato=new DecimalFormat("#.00");
                    txtCalcularCambio.setText("El cambio es : $"+formato.format(cambio));
                    txtTipoCambio.setText("");
                    txtSoles.setText("");
                }
            }break;
        }
    }
}
