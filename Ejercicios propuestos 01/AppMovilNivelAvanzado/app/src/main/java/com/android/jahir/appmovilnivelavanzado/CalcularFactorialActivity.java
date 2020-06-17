package com.android.jahir.appmovilnivelavanzado;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcularFactorialActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtFactorial;
    private Button btnFactorial;
    private TextView txtResFactorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_factorial);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtFactorial = (EditText) findViewById(R.id.txtFactorial);
        btnFactorial = (Button) findViewById(R.id.btnFactorial);
        txtResFactorial = (TextView) findViewById(R.id.txtResFactorial);
        btnFactorial.setOnClickListener(this);
;     }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnFactorial:{
                if (txtFactorial.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresa variable",Snackbar.LENGTH_LONG).show();
                }else
                {
                    long num,res=1;
                    long mostrar=0;
                    num = Integer.parseInt(txtFactorial.getText().toString());

                    mostrar=num;
                    while (num!=0)
                    {
                        res=res*num;
                        num--;
                    }
                    txtResFactorial.setText("El Factorial de "+mostrar+" es : "+res);
                    txtFactorial.setText("");
                }
            }break;
        }
    }
}
