package com.android.jahir.appmovilnivelbasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class CalculadoraActivity extends AppCompatActivity {

    private RadioButton rbtnSuma, rbtnResta, rbtnMultiplicacion, rbtnDivision;
    private EditText txtPrimerNumero, txtSegundoNumero;
    private Button btnCalcularResultado;
    private TextView txtvCalculadora;

    public static final int suma = 1;
    public static final int resta = 2;
    public static final int mul = 3;
    public static final int div = 4;
    public static final int apagado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        rbtnSuma = (RadioButton) findViewById(R.id.rbtnSuma);
        rbtnResta = (RadioButton) findViewById(R.id.rbtnResta);
        rbtnMultiplicacion = (RadioButton) findViewById(R.id.rbtnMultiplicacion);
        rbtnDivision = (RadioButton) findViewById(R.id.rbtnDivision);
        txtPrimerNumero = (EditText) findViewById(R.id.txtPrimerNumero);
        txtSegundoNumero = (EditText) findViewById(R.id.txtSegundoNumero);
        btnCalcularResultado = (Button) findViewById(R.id.btnCalcularResultado);
        txtvCalculadora = (TextView) findViewById(R.id.txtvCalculadora);

        btnCalcularResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int option = (rbtnSuma.isChecked()) ? suma : apagado | (rbtnResta.isChecked() ? resta : apagado) |
                        (rbtnMultiplicacion.isChecked() ? mul : apagado) | (rbtnDivision.isChecked() ? div : apagado);

                switch (option) {
                    case 0: {
                        Toast.makeText(CalculadoraActivity.this, "Seleccione un calculo", Toast.LENGTH_LONG).show();
                    }
                    break;
                    case 1: {
                        if (txtPrimerNumero.getText().toString().equals("")) {
                            txtPrimerNumero.setError("Ingrese el primer número");
                        } else if (txtSegundoNumero.getText().toString().equals("")) {
                            txtSegundoNumero.setError("Ingrese el segundo número");
                        } else {
                            Double num1, num2, res;
                            num1 = Double.parseDouble(txtPrimerNumero.getText().toString());
                            num2 = Double.parseDouble(txtSegundoNumero.getText().toString());
                            res = num1 + num2;
                            txtvCalculadora.setText("La suma de los números es: " + res.toString());
                            txtSegundoNumero.setText("");
                            txtPrimerNumero.setText("");
                        }
                    }
                    break;
                    case 2: {
                        if (txtPrimerNumero.getText().toString().equals("")) {
                            txtPrimerNumero.setError("Ingrese el primer número");
                        } else if (txtSegundoNumero.getText().toString().equals("")) {
                            txtSegundoNumero.setError("Ingrese el segundo número");
                        } else {
                            Double num1, num2, res;
                            num1 = Double.parseDouble(txtPrimerNumero.getText().toString());
                            num2 = Double.parseDouble(txtSegundoNumero.getText().toString());
                            res = num1 - num2;
                            txtvCalculadora.setText("La resta de los números es: " + res.toString());
                            txtSegundoNumero.setText("");
                            txtPrimerNumero.setText("");
                        }
                    }
                    break;
                    case 3: {
                        if (txtPrimerNumero.getText().toString().equals("")) {
                            txtPrimerNumero.setError("Ingrese el primer número");
                        } else if (txtSegundoNumero.getText().toString().equals("")) {
                            txtSegundoNumero.setError("Ingrese el segundo número");
                        } else {
                            Double num1, num2, res;
                            num1 = Double.parseDouble(txtPrimerNumero.getText().toString());
                            num2 = Double.parseDouble(txtSegundoNumero.getText().toString());
                            res = num1 * num2;
                            DecimalFormat formato=new DecimalFormat("#.00");
                            txtvCalculadora.setText("La multiplicación de los números es: " +formato.format(res));
                            txtSegundoNumero.setText("");
                            txtPrimerNumero.setText("");
                        }
                    }
                    break;
                    case 4: {
                        if (txtPrimerNumero.getText().toString().equals("")) {
                            txtPrimerNumero.setError("Ingrese el primer número");
                        } else if (txtSegundoNumero.getText().toString().equals("")) {
                            txtSegundoNumero.setError("Ingrese el segundo número");
                        } else {
                            Double num1, num2, res;
                            num1 = Double.parseDouble(txtPrimerNumero.getText().toString());
                            num2 = Double.parseDouble(txtSegundoNumero.getText().toString());
                            res = num1 / num2;
                            DecimalFormat formato=new DecimalFormat("#.00");
                            txtvCalculadora.setText("La división de los números es: " + formato.format(res));
                            txtSegundoNumero.setText("");
                            txtPrimerNumero.setText("");
                        }
                    }
                    break;
                }
            }
        });

    }
}
