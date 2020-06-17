package com.android.jahir.appcovid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnIninio,btnRegistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btnIninio = (Button) findViewById(R.id.btnInicio);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnIninio.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnInicio:
            {
                Intent op1 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(op1);
            }break;
            case R.id.btnRegistrar:{
                Intent op2 = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(op2);
            }break;
        }
    }
}
