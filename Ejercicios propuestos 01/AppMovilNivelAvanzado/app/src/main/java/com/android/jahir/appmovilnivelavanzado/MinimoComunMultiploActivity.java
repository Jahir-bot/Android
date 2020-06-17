package com.android.jahir.appmovilnivelavanzado;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MinimoComunMultiploActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtMCM1, txtMCM2;
    private Button btnMCM;
    private TextView txtResMCM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minimo_comun_multiplo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtMCM1 = (EditText) findViewById(R.id.txtMCM1);
        txtMCM2 = (EditText) findViewById(R.id.txtMCM2);
        btnMCM = (Button) findViewById(R.id.btnMCM);
        txtResMCM = (TextView) findViewById(R.id.txtResMCM);
        btnMCM.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnMCM:{
                if (txtMCM1.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar primer número",Snackbar.LENGTH_LONG).show();
                }else if (txtMCM2.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar el segundo número",Snackbar.LENGTH_LONG).show();;
                }else
                {
                    int num1,num2,mcm=0;
                    num1 = Integer.parseInt(txtMCM1.getText().toString());
                    num2 = Integer.parseInt(txtMCM2.getText().toString());
                    int min=Math.min(num1,num2);
                    for (int i=1;i<=min;i++)
                    {
                        if (num1%i==0 && num2%i==0)
                        {
                            int mcd=i;
                            mcm=(num1*num2)/mcd;
                        }
                    }
                    txtResMCM.setText("El MCM de "+num1+" y "+num2+" es: "+mcm);
                    txtMCM2.setText("");
                    txtMCM1.setText("");
                }
            }break;
        }
    }
}
