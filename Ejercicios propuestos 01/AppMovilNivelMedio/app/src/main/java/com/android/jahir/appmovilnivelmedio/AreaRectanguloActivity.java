package com.android.jahir.appmovilnivelmedio;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class AreaRectanguloActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtBase, txtAltura;
    private Button btnCalcularRectangulo;
    private TextView txtCalcularRectangulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_rectangulo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtBase = (EditText) findViewById(R.id.txtBase);
        txtAltura = (EditText) findViewById(R.id.txtAltura);
        btnCalcularRectangulo = (Button) findViewById(R.id.btnCalcularRectangulo);
        txtCalcularRectangulo = (TextView) findViewById(R.id.txtCalcularRectangulo);
        btnCalcularRectangulo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnCalcularRectangulo:{
                if (txtBase.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingresar la base", Snackbar.LENGTH_LONG).show();
                } else if (txtAltura.getText().toString().equals("")) {
                    Snackbar.make(v, "Ingresar la altura", Snackbar.LENGTH_LONG).show();
                }else
                {
                    Double base,altura,area;
                    base = Double.parseDouble(txtBase.getText().toString());
                    altura = Double.parseDouble(txtAltura.getText().toString());
                    area=base*altura;
                    DecimalFormat formato=new DecimalFormat("#.00");
                    txtCalcularRectangulo.setText("El area del rectángulo es : "+formato.format(area));
                    txtAltura.setText("");
                    txtBase.setText("");
                }
            }break;
        }
    }
}
