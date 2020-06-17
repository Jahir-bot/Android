package com.android.jahir.appmovilnivelmedio;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class AreaTrianguloActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtBaseT, txtAlturaT;
    private Button btnCalcularTriangulo;
    private TextView txtCalcularTriangulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_triangulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtBaseT = (EditText) findViewById(R.id.txtBaseT);
        txtAlturaT = (EditText) findViewById(R.id.txtAlturaT);
        btnCalcularTriangulo = (Button) findViewById(R.id.btnCalcularTriangulo);
        txtCalcularTriangulo = (TextView) findViewById(R.id.txtCalcularTriangulo);
        btnCalcularTriangulo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCalcularTriangulo:{
                if (txtBaseT.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingrese la base",Snackbar.LENGTH_LONG).show();
                }else if (txtAlturaT.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingrese la altura",Snackbar.LENGTH_LONG).show();
                }else
                {
                    Double base, altura, area;
                    base= Double.parseDouble(txtBaseT.getText().toString());
                    altura=Double.parseDouble(txtAlturaT.getText().toString());

                    area=(base*altura)/2;
                    DecimalFormat formato=new DecimalFormat("#.00");
                    txtCalcularTriangulo.setText("El área del triángulo es: "+formato.format(area));
                    txtAlturaT.setText("");
                    txtBaseT.setText("");
                }
            }break;
        }
    }
}
