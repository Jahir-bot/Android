package com.android.jahir.appcovid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText txtNombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
    }

    @Override
    public void onClick(View v) {

    }
}
