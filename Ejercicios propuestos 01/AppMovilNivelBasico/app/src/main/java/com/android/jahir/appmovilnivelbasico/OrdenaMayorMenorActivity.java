package com.android.jahir.appmovilnivelbasico;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrdenaMayorMenorActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtNumeroOrdenaMayor1, txtNumeroOrdenaMayor2, txtNumeroOrdenaMayor3;
    private Button btnOrdenaMayor;
    private TextView txtOrdenaMayor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordena_mayor_menor);
        txtNumeroOrdenaMayor1 = (EditText) findViewById(R.id.txtNumeroOrdenaMayor1);
        txtNumeroOrdenaMayor2 = (EditText) findViewById(R.id.txtNumeroOrdenaMayor2);
        txtNumeroOrdenaMayor3 = (EditText) findViewById(R.id.txtNumeroOrdenaMayor3);
        btnOrdenaMayor = (Button) findViewById(R.id.btnOrdenaMayor);
        txtOrdenaMayor = (TextView) findViewById(R.id.txtOrdenaMayor);
        btnOrdenaMayor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOrdenaMayor: {
                if (txtNumeroOrdenaMayor1.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingrese la primer número", Snackbar.LENGTH_LONG).show();
                } else if (txtNumeroOrdenaMayor2.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingrese la segundo número", Snackbar.LENGTH_LONG).show();
                } else if (txtNumeroOrdenaMayor3.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingrese la tercer número", Snackbar.LENGTH_LONG).show();
                } else {
                    int n1, n2, n3, mayor, menor, medio;
                    n1 = Integer.parseInt(txtNumeroOrdenaMayor1.getText().toString());
                    n2 = Integer.parseInt(txtNumeroOrdenaMayor2.getText().toString());
                    n3 = Integer.parseInt(txtNumeroOrdenaMayor3.getText().toString());

                    if (n1 == n2 || n1 == n3 || n2 == n3) {
                        Snackbar.make(v, "No es posible realizar la operación debido a que algunos campos son iguales", Snackbar.LENGTH_LONG).show();
                        txtOrdenaMayor.setText("");
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
                        txtOrdenaMayor.setText("Números : " + mayor + " , " + medio + " , " + menor);
                        txtNumeroOrdenaMayor1.setText("");
                        txtNumeroOrdenaMayor2.setText("");
                        txtNumeroOrdenaMayor3.setText("");
                    }
                }
            }
            break;
        }
    }
}
