package com.android.jahir.appmovilnivelbasico;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.IllegalFormatCodePointException;

public class PromedioSimple2Activity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtNotaP1,txtNotaP2,txtNotaP3,txtNotaP4,txtNotaP5;
    private Button btnPromedioNota;
    private TextView txtPromedioNOta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promedio_simple2);
        txtNotaP1 = ( EditText) findViewById(R.id.txtNotaP1);
        txtNotaP2 = ( EditText) findViewById(R.id.txtNotaP2);
        txtNotaP3 = ( EditText) findViewById(R.id.txtNotaP3);
        txtNotaP4 = ( EditText) findViewById(R.id.txtNotaP4);
        txtNotaP5 = ( EditText) findViewById(R.id.txtNotaP5);
        btnPromedioNota = ( Button ) findViewById(R.id.btnPromedioNota);
        txtPromedioNOta = ( TextView ) findViewById(R.id.txtvPromedioNota);
        btnPromedioNota.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnPromedioNota: {
                if (txtNotaP1.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingrese la primera nota",Snackbar.LENGTH_LONG).show();
                }else if (txtNotaP2.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingrese la segunda nota",Snackbar.LENGTH_LONG).show();
                }else if (txtNotaP3.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingrese la tercera nota",Snackbar.LENGTH_LONG).show();
                }else if (txtNotaP4.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingrese la cuarte nota",Snackbar.LENGTH_LONG).show();
                }else if (txtNotaP5.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingrese la quinta nota",Snackbar.LENGTH_LONG).show();
                }else
                {
                    Double n1,n2,n3,n4,n5,res;
                    Double menor;
                    n1 = Double.parseDouble(txtNotaP1.getText().toString());
                    n2 = Double.parseDouble(txtNotaP2.getText().toString());
                    n3 = Double.parseDouble(txtNotaP3.getText().toString());
                    n4 = Double.parseDouble(txtNotaP4.getText().toString());
                    n5 = Double.parseDouble(txtNotaP5.getText().toString());

                    if (n1<n2 && n1<n3 && n1<n4 && n1<n5)
                    {
                        menor = n1;
                    }else if (n2<n1 && n2<n3 && n2<n4 && n2<n5)
                    {
                        menor = n2;
                    }else if (n3<n1 && n3<n2 && n3<n4 && n3<n5)
                    {
                        menor = n3;
                    }else if (n4<n1 && n4<n2 && n4<n3 && n4<n5)
                    {
                        menor = n4;
                    }else
                    {
                        menor =n5;
                    }

                    res=((n1+n2+n3+n4+n5)-menor)/4;
                    DecimalFormat formato=new DecimalFormat("#.00");
                    txtPromedioNOta.setText("El promedio es : "+formato.format(res));
                    txtNotaP1.setText("");
                    txtNotaP2.setText("");
                    txtNotaP3.setText("");
                    txtNotaP4.setText("");
                    txtNotaP5.setText("");

                }
            }break;
        }
    }
}
