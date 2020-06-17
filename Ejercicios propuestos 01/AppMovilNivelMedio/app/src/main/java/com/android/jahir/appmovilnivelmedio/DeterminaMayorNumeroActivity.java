package com.android.jahir.appmovilnivelmedio;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeterminaMayorNumeroActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtNumeroMayor1, txtNumeroMayor2, txtNumeroMayor3;
    private Button btnMayor;
    private TextView txtMayor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determina_mayor_numero);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtNumeroMayor1 = (EditText) findViewById(R.id.txtNumeroMayor1);
        txtNumeroMayor2 = (EditText) findViewById(R.id.txtNumeroMayor2);
        txtNumeroMayor3 = (EditText) findViewById(R.id.txtNumeroMayor3);
        btnMayor = (Button) findViewById(R.id.btnMayor);
        txtMayor = (TextView) findViewById(R.id.txtMayor);
        btnMayor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMayor: {
                if (txtNumeroMayor1.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingrese la primer número", Snackbar.LENGTH_LONG).show();
                } else if (txtNumeroMayor2.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingrese la segundo número", Snackbar.LENGTH_LONG).show();
                } else if (txtNumeroMayor3.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingrese la tercer número", Snackbar.LENGTH_LONG).show();
                } else {
                    int n1, n2, n3, mayor;
                    n1 = Integer.parseInt(txtNumeroMayor1.getText().toString());
                    n2 = Integer.parseInt(txtNumeroMayor2.getText().toString());
                    n3 = Integer.parseInt(txtNumeroMayor3.getText().toString());

                    if (n1 == n2 || n1 == n3 || n2 == n3) {
                        Snackbar.make(v, "No es posible realizar la operación debido a que algunos campos son iguales", Snackbar.LENGTH_LONG).show();
                        txtMayor.setText("");
                    } else {

                        if (n1 > n2 && n1 > n3) {
                            mayor = n1;
                        } else if (n2 > n1 && n2 > n3) {
                            mayor = n2;
                        } else {
                            mayor = n3;
                        }
                        txtMayor.setText("El número mayor es : " + mayor);
                        txtNumeroMayor1.setText("");
                        txtNumeroMayor2.setText("");
                        txtNumeroMayor3.setText("");
                    }
                }
            }
            break;
        }
    }
}
