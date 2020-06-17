package com.android.jahir.appmovilnivelmedio;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CilindroActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtRadio1,txtRadio2;
    private Button btnCilindro;
    private TextView txtCilindro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtRadio1 = (EditText) findViewById(R.id.txtRadio1);
        txtRadio2 = (EditText) findViewById(R.id.txtRadio2);
        btnCilindro = (Button) findViewById(R.id.btnCilindro);
        txtCilindro = (TextView) findViewById(R.id.txtCilindro);
        btnCilindro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCilindro:{
                if (txtRadio1.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar el radio",Snackbar.LENGTH_LONG).show();
                }else if (txtRadio2.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingresar la altura",Snackbar.LENGTH_LONG).show();
                }else
                {
                    Double radio,area,altura,volumen;
                    Double pi=3.14;
                    radio = Double.parseDouble(txtRadio1.getText().toString());
                    altura = Double.parseDouble(txtRadio2.getText().toString());

                    area=((2*pi)*(radio*altura))+((2*pi)*(radio*radio));
                    volumen=((pi)*(radio*radio)*(altura));
                    DecimalFormat formato = new DecimalFormat("#.00");
                    txtCilindro.setText("El ára es: "+formato.format(area)+"  el volumen: "+formato.format(volumen));
                    txtRadio2.setText("");
                    txtRadio1.setText("");
                }
            }break;
        }
    }
}
