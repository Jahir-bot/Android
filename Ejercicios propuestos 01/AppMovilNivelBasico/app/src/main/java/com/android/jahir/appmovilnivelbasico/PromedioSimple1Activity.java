package com.android.jahir.appmovilnivelbasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class PromedioSimple1Activity extends AppCompatActivity {

    private EditText txtNota1, txtNota2, txtNota3;
    private Button btnPromedio;
    private TextView txtvPromedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promedio_simple1);

        txtNota1 = (EditText) findViewById(R.id.txtNota1);
        txtNota2 = (EditText) findViewById(R.id.txtNota2);
        txtNota3 = (EditText) findViewById(R.id.txtNota3);
        btnPromedio = (Button) findViewById(R.id.btnPromedio);
        txtvPromedio = (TextView) findViewById(R.id.txtvPromedio);

        btnPromedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtNota1.getText().toString().equals("")) {
                    txtNota1.setError("Ingrese la primera nota");
                } else if (txtNota2.getText().toString().equals("")) {
                    txtNota2.setError("Ingrese la segunda nota");
                } else if (txtNota3.getText().toString().equals("")) {
                    txtNota3.setError("Ingrese la tercera nota");
                } else {
                    Double nota1, nota2, nota3, prom;
                    nota1 = Double.parseDouble(txtNota1.getText().toString());
                    nota2 = Double.parseDouble(txtNota2.getText().toString());
                    nota3 = Double.parseDouble(txtNota3.getText().toString());

                    if (nota1 < 0 | nota1 > 20) {
                        txtNota1.setError("Ingrese nota de 0 a 20");
                    } else if (nota2 < 0 | nota2 > 20) {
                        txtNota2.setError("Ingrese nota de 0 a 20");
                    } else if (nota3 < 0 | nota3 > 20) {
                        txtNota3.setError("Ingrese nota de 0 a 20");
                    } else {
                        prom = (nota1 + nota2 + nota3) / 3;
                        DecimalFormat formato=new DecimalFormat("#.00");
                        txtvPromedio.setText("El promedio del alumno es: " +formato.format(prom) );
                        txtNota1.setText("");
                        txtNota2.setText("");
                        txtNota3.setText("");
                    }
                }
            }
        });
    }
}
