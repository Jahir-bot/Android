package com.android.jahir.appmovilnivelbasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IndentificaNumeroActivity extends AppCompatActivity {

    private EditText txtIdentificarNumero;
    private Button btnIdentificar;
    private TextView txtvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indentifica_numero);

        txtIdentificarNumero = (  EditText ) findViewById(R.id.txtIdentificaNumero);
        btnIdentificar = ( Button ) findViewById(R.id.btnIdentificaNumero);
        txtvResultado = ( TextView ) findViewById(R.id.txtvResultado);

        btnIdentificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtIdentificarNumero.getText().toString().equals("")){
                    txtIdentificarNumero.setError("Ingrese número a identificar");
                }else{
                    Double numero;
                    String resultado="";
                    numero=Double.parseDouble(txtIdentificarNumero.getText().toString());
                    if (numero % 2 == 0){
                        resultado="es par";
                    }else {
                        resultado="es impar";
                    }
                    txtvResultado.setText("El número ingresado "+resultado);
                    txtIdentificarNumero.setText("");
                }
            }
        });
    }
}
