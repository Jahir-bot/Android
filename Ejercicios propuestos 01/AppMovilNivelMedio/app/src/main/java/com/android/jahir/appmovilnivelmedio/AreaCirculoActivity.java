package com.android.jahir.appmovilnivelmedio;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class AreaCirculoActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtCirculo;
    private Button btnCalcularCirculo;
    private TextView txtCalcularCirculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_circulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtCirculo = (EditText) findViewById(R.id.txtCirculo);
        btnCalcularCirculo = (Button) findViewById(R.id.btnCalcularCirculo);
        txtCalcularCirculo = (TextView) findViewById(R.id.txtCalcularCirculo);
        btnCalcularCirculo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalcularCirculo: {
                if (txtCirculo.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingresar el radio", Snackbar.LENGTH_LONG).show();
                } else {
                    Double radio,area,pi;
                    pi=3.14;
                    radio = Double.parseDouble(txtCirculo.getText().toString());
                    area=(radio*radio)*pi;
                    DecimalFormat formato=new DecimalFormat("#.00");
                    txtCalcularCirculo.setText("El área del cículo es: "+formato.format(area));
                    txtCirculo.setText("");
                }
            }
            break;
        }
    }
}
