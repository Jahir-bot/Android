package com.android.jahir.appmovilnivelbasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DeterminaCalificacionActivity extends AppCompatActivity {

    private EditText txtNota;
    private Button btnCalidicacion;
    private TextView txtvClasificacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determina_calificacion);

        txtNota = ( EditText ) findViewById(R.id.txtNota);
        btnCalidicacion = ( Button ) findViewById(R.id.btnCalificacion);
        txtvClasificacion = ( TextView ) findViewById(R.id.txtvClasificacion);

        btnCalidicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double nota;
                if (txtNota.getText().toString().equals("")){
                    txtNota.setError("Ingrese la nota");
                }else{
                    nota = Double.parseDouble(txtNota.getText().toString());
                    if (nota >= 0 && nota <= 20){
                        if (nota <= 10.5)
                        {
                            txtvClasificacion.setText("La calificación del alumno es MALA");
                        }else if (nota <= 14){
                            txtvClasificacion.setText("La calificacion del alumno es REGULAR");
                        }else if (nota <= 18)
                            {
                            txtvClasificacion.setText("La calificacion del alumno es BUENA");
                        }else if (nota <= 20)
                        {
                            txtvClasificacion.setText("La calificacion del alumno es EXCELENTE");
                        }
                    }else{
                        txtNota.setError("Ingrese una nota entre 0 y 20");
                    }
                }
            }
        });

    }
}
