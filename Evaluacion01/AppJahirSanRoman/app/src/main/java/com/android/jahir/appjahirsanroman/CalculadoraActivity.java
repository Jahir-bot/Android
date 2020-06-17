package com.android.jahir.appjahirsanroman;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rbtnSuma, rbtnResta, rbtnMultiplicacion, rbtnDivision, rbtnTodos;
    private EditText txtPrimerNumero, txtSegundoNumero;
    private Button btnCalcularResultado;
    private TextView txtvCalculadora;

    private final int suma = 1;
    private final int resta = 2;
    private final int mul = 3;
    private final int div = 4;
    private final int todos = 5;
    private final int apagado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        rbtnSuma = (RadioButton) findViewById(R.id.rbtnSuma);
        rbtnResta = (RadioButton) findViewById(R.id.rbtnResta);
        rbtnMultiplicacion = (RadioButton) findViewById(R.id.rbtnMultiplicacion);
        rbtnDivision = (RadioButton) findViewById(R.id.rbtnDivision);
        rbtnTodos = (RadioButton) findViewById(R.id.rbtnTodos);
        txtPrimerNumero = (EditText) findViewById(R.id.txtPrimerNumero);
        txtSegundoNumero = (EditText) findViewById(R.id.txtSegundoNumero);
        btnCalcularResultado = (Button) findViewById(R.id.btnCalcularResultado);
        txtvCalculadora = (TextView) findViewById(R.id.txtvCalculadora);
        btnCalcularResultado.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalcularResultado: {
                int option = (rbtnSuma.isChecked()) ? suma : apagado | (rbtnResta.isChecked() ? resta : apagado) |
                        (rbtnMultiplicacion.isChecked() ? mul : apagado) | (rbtnDivision.isChecked() ? div : apagado) |
                        (rbtnTodos.isChecked() ? todos : apagado);

                switch (option) {
                    case 0: {
                        Snackbar.make(v,"Seleccione una opción",Snackbar.LENGTH_LONG).show();
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
                            DecimalFormat formato = new DecimalFormat("#.00");
                            txtvCalculadora.setText("La multiplicación de los números es: " + formato.format(res));
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
                            DecimalFormat formato = new DecimalFormat("#.00");
                            txtvCalculadora.setText("La división de los números es: " + formato.format(res));
                            txtSegundoNumero.setText("");
                            txtPrimerNumero.setText("");
                        }
                    }
                    break;
                    case 5: {
                        if (txtPrimerNumero.getText().toString().equals("")) {
                            txtPrimerNumero.setError("Ingrese el primer número");
                        } else if (txtSegundoNumero.getText().toString().equals("")) {
                            txtSegundoNumero.setError("Ingrese el segundo número");
                        } else {
                            Double num1, num2, suma, resta, multiplicacion, division;
                            num1 = Double.parseDouble(txtPrimerNumero.getText().toString());
                            num2 = Double.parseDouble(txtSegundoNumero.getText().toString());
                            suma = num1 + num2;
                            resta = num1 - num2;
                            multiplicacion = num1 * num2;
                            division = num1 / num2;
                            DecimalFormat formato = new DecimalFormat("#.00");
                            txtvCalculadora.setText("La suma es: " + formato.format(suma) + "\n"
                                    + "La resta es: " + formato.format(resta) + "\n"
                                    + "La multiplicación es: " + formato.format(multiplicacion) + "\n"
                                    + "La divisón es: " + formato.format(division));
                            txtSegundoNumero.setText("");
                            txtPrimerNumero.setText("");
                        }
                        break;
                    }
                }
                break;
            }
        }
    }
}
