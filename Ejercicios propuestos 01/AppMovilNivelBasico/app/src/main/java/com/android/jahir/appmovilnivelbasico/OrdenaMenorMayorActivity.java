package com.android.jahir.appmovilnivelbasico;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OrdenaMenorMayorActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtNumeroOrdenaMenor1, txtNumeroOrdenaMenor2, txtNumeroOrdenaMenor3;
    private Button btnOrdenaMenor;
    private TextView txtOrdenaMenor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordena_menor_mayor);

        txtNumeroOrdenaMenor1 = (EditText) findViewById(R.id.txtNumeroOrdenaMenor1);
        txtNumeroOrdenaMenor2 = (EditText) findViewById(R.id.txtNumeroOrdenaMenor2);
        txtNumeroOrdenaMenor3 = (EditText) findViewById(R.id.txtNumeroOrdenaMenor3);
        btnOrdenaMenor = (Button) findViewById(R.id.btnOrdenaMenor);
        txtOrdenaMenor = (TextView) findViewById(R.id.txtOrdenaMenor);
        btnOrdenaMenor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOrdenaMenor: {
                if (txtNumeroOrdenaMenor1.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingrese la primer número", Snackbar.LENGTH_LONG).show();
                } else if (txtNumeroOrdenaMenor2.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingrese la segundo número", Snackbar.LENGTH_LONG).show();
                } else if (txtNumeroOrdenaMenor3.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingrese la tercer número", Snackbar.LENGTH_LONG).show();
                } else {
                    int n1, n2, n3, mayor, menor, medio;
                    n1 = Integer.parseInt(txtNumeroOrdenaMenor1.getText().toString());
                    n2 = Integer.parseInt(txtNumeroOrdenaMenor2.getText().toString());
                    n3 = Integer.parseInt(txtNumeroOrdenaMenor3.getText().toString());

                    if (n1 == n2 || n1 == n3 || n2 == n3) {
                        Snackbar.make(v, "No es posible realizar la operación debido a que algunos campos son iguales", Snackbar.LENGTH_LONG).show();
                        txtOrdenaMenor.setText("");
                    } else {

                        if (n1 > n2 && n1 > n3) {
                            mayor = n1;
                        } else if (n2 > n1 && n2 > n3) {
                            mayor = n2;
                        } else {
                            mayor = n3;
                        }
                        if (n1 < n2 && n1 < n3) {
                            menor = n1;
                        } else if (n2 < n1 && n2 < n3) {
                            menor = n2;
                        } else {
                            menor = n3;
                        }

                        medio = (n1 + n2 + n3) - (mayor + menor);
                        txtOrdenaMenor.setText("Números : " + menor + " , " + medio + " , " + mayor);
                        txtNumeroOrdenaMenor1.setText("");
                        txtNumeroOrdenaMenor2.setText("");
                        txtNumeroOrdenaMenor3.setText("");
                    }
                }
            }
            break;
        }
    }
}
