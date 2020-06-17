package com.android.jahir.appmovilnivelavanzado;

import android.icu.lang.UCharacterEnums;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcularFibonacciActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtFibonacci;
    private Button btnFibonacci;
    private TextView txtResFibonacci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_fibonacci);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtFibonacci = (EditText) findViewById(R.id.txtFibonacci);
        btnFibonacci = (Button) findViewById(R.id.btnFibonacci);
        txtResFibonacci = (TextView) findViewById(R.id.txtResFibonacci);
        btnFibonacci.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFibonacci: {
                if (txtFibonacci.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingresar numero", Snackbar.LENGTH_LONG).show();
                } else {
                    Long serie;
                    int num1 = 0, num2 = 1, suma = 1;
                    String res = "";
                    serie = Long.parseLong(txtFibonacci.getText().toString());
                    for (int i = 1; i <= serie; i++) {
                        res += suma;
                        suma = num1 + num2;
                        num1 = num2;
                        num2 = suma;
                    }
                    txtResFibonacci.setText("La sere " + serie + " es: " + res);
                    txtFibonacci.setText("");
                }
            }
            break;
        }
    }
}
