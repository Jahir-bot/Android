package com.android.jahir.prueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnGo;
    private TextView txtGo;
    private EditText txtEscribe,txtEscribe2;

    String aux1,aux2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGo = (Button) findViewById(R.id.btnGo);
        txtGo = (TextView) findViewById(R.id.txtGo);
        txtEscribe = (EditText) findViewById(R.id.txtEscribe);
        txtEscribe2 = (EditText) findViewById(R.id.txtEscribe2);
        btnGo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch (v.getId())
        {
            case R.id.btnGo:{
                hijo hijo1=new hijo();
              //  hijo hijo2=new hijo("Jahir","San Roman",21,1,18.5);
                aux1 = txtEscribe.getText().toString();
                hijo1.setNombre(aux1);
                aux2=hijo1.getNombre();

                txtGo.setText(aux2);
            }break;
        }
    }
}
