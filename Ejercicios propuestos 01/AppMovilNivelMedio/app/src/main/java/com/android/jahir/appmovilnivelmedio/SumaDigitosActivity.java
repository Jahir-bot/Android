package com.android.jahir.appmovilnivelmedio;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SumaDigitosActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtSumaDigitos;
    private Button btnSumaDigitos;
    private TextView txtDigitos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma_digitos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtSumaDigitos = (EditText) findViewById(R.id.txtSumaDigitos);
        btnSumaDigitos = (Button) findViewById(R.id.btnSumaDigitos);
        txtDigitos = (TextView) findViewById(R.id.txtDigitos);
        btnSumaDigitos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSumaDigitos:{
                if (txtSumaDigitos.getText().toString().equals(""))
                {
                    Snackbar.make(v, "Ingresar número por favor",Snackbar.LENGTH_LONG).show();
                }else
                {
                    int num;
                    int res=0;
                    num = Integer.parseInt(txtSumaDigitos.getText().toString());
                    if (num>99 && num<1000)
                    {
                        while (num>0)
                        {
                            res+=num%10;
                            num=num/10;
                        }
                        txtDigitos.setText("L suma de los digitos es: "+res);
                    }else
                    {
                        Snackbar.make(v,"Ingresar un número de 3 dígitos",Snackbar.LENGTH_LONG).show();
                    }
                }
            }break;
        }
    }
}
