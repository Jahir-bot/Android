package com.android.jahir.appmovilnivelbasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CalculoHipotenusaActivity extends AppCompatActivity {
    private EditText txtCateto1, txtCateto2;
    private Button btnCalcular;
    private TextView txtvHipotenusa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_hipotenusa);
        txtCateto1 = (EditText) findViewById(R.id.txtCateto1);
        txtCateto2 = (EditText) findViewById(R.id.txtCateto2);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        txtvHipotenusa = (TextView) findViewById(R.id.txtvHipotenusa);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double cateto1, cateto2, hipotenusa;

                if (txtCateto1.getText().toString().equals("")) {
                    txtCateto1.setError("Ingrese el primer cateto");
                }else  if(txtCateto2.getText().toString().equals("")){
                    txtCateto2.setError("Ingrese el segundo cateto");
                }else {
                    cateto1 = Double.parseDouble(txtCateto1.getText().toString());
                    cateto2 = Double.parseDouble(txtCateto2.getText().toString());
                    hipotenusa =Math.sqrt((cateto1 * cateto1) + (cateto2 * cateto2));

                    DecimalFormat formato=new DecimalFormat("#.00");
                    txtvHipotenusa.setText("La hipotenuza es equivalente a: " +formato.format( hipotenusa));
                    txtCateto2.setText("");
                    txtCateto1.setText("");
                }

            }
        });
    }
}
