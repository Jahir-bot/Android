package com.android.jahir.appmovilnivelavanzado;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MaximoComunDivisor2Activity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtMCD21, txtMCD22,txtMCD23;
    private Button btnMCD2;
    private TextView txtResMCD2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maximo_comun_divisor2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtMCD21 = (EditText) findViewById(R.id.txtMCD21);
        txtMCD22 = (EditText) findViewById(R.id.txtMCD22);
        txtMCD23 = (EditText) findViewById(R.id.txtMCD23);
        btnMCD2 = (Button) findViewById(R.id.btnMCD2);
        txtResMCD2 = (TextView) findViewById(R.id.txtResMCD2);
        btnMCD2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMCD2: {
                if (txtMCD21.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingresar primer número", Snackbar.LENGTH_LONG).show();
                } else if (txtMCD22.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingresar el segundo número", Snackbar.LENGTH_LONG).show();
                    ;
                } else {
                    int num1, num2,num3,c=2,mcd=1;
                    num1 = Integer.parseInt(txtMCD21.getText().toString());
                    num2 = Integer.parseInt(txtMCD22.getText().toString());
                    num3 = Integer.parseInt(txtMCD23.getText().toString());
                    while (c<=num1 && c<=num2 && c<=num3)
                    {
                        while (num1%c==0 && num2%c==0 && num3%c==0)
                        {
                            mcd=mcd*c;
                            num1=num1/c;
                            num2=num2/c;
                            num3=num3/c;
                        }
                        c=c+1;
                    }
                    txtResMCD2.setText("El MCD es: " +mcd);
                    txtMCD21.setText("");
                    txtMCD22.setText("");
                    txtMCD23.setText("");
                }
            } break;
        }
    }
}
