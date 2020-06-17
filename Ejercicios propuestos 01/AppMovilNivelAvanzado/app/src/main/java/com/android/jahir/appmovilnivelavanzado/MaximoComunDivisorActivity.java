package com.android.jahir.appmovilnivelavanzado;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MaximoComunDivisorActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtMCD1, txtMCD2;
    private Button btnMCD;
    private TextView txtResMCD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maximo_comun_divisor);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtMCD1 = (EditText) findViewById(R.id.txtMCD1);
        txtMCD2 = (EditText) findViewById(R.id.txtMCD2);
        btnMCD = (Button) findViewById(R.id.btnMCD);
        txtResMCD = (TextView) findViewById(R.id.txtResMCD);
        btnMCD.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMCD: {
                if (txtMCD1.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingresar primer número", Snackbar.LENGTH_LONG).show();
                } else if (txtMCD2.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingresar el segundo número", Snackbar.LENGTH_LONG).show();
                    ;
                } else {
                    int num1, num2, res = 0;
                    num1 = Integer.parseInt(txtMCD1.getText().toString());
                    num2 = Integer.parseInt(txtMCD2.getText().toString());

                    while (num1 != num2) {
                        if (num1 > num2) {
                            num1 = num1 - num2;
                            res = num1;
                        }else
                        {
                            num2 = num2 - num1;
                        }
                    }

                    txtResMCD.setText("El MCD es: " + res);
                    txtMCD2.setText("");
                    txtMCD1.setText("");
                }
            } break;
        }
    }
}
