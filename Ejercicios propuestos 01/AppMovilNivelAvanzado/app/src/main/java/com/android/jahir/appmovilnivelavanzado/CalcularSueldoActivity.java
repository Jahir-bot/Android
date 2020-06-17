package com.android.jahir.appmovilnivelavanzado;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalcularSueldoActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtSueldo;
    private Button btnSueldo;
    private TextView txtResSueldo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_sueldo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtSueldo = (EditText) findViewById(R.id.txtSueldo);
        btnSueldo = (Button) findViewById(R.id.btnSueldo);
        txtResSueldo = (TextView) findViewById(R.id.txtResSueldo);
        btnSueldo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSueldo:{
                if (txtSueldo.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar sueldo por favor",Snackbar.LENGTH_LONG).show();
                }else
                {
                    Double suel,total,desc;
                    suel = Double.parseDouble(txtSueldo.getText().toString());

                    if (suel<=1000)
                    {
                        desc=suel*0.10;
                        total=suel-desc;
                        DecimalFormat formato = new DecimalFormat("#.00");
                        txtResSueldo.setText("Su descuento es de: "+formato.format(desc)+" \n"+"Su sueldo neto es de: "+formato.format(total));
                        txtSueldo.setText("");
                    }else if (suel>1000 && suel<=2000)
                    {
                        desc=suel*0.15;
                        total=suel-desc;
                        DecimalFormat formato = new DecimalFormat("#.00");
                        txtResSueldo.setText("Su descuento es de: "+formato.format(desc)+" \n"+"Su sueldo neto es de: "+formato.format(total));
                        txtSueldo.setText("");
                    }else
                    {
                        desc=suel*0.20;
                        total=suel-desc;
                        DecimalFormat formato = new DecimalFormat("#.00");
                        txtResSueldo.setText("Su descuento es de: "+formato.format(desc)+" \n"+"Su sueldo neto es de: "+formato.format(total));
                        txtSueldo.setText("");
                    }
                }
            }break;
        }
    }
}
