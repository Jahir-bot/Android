package com.android.jahir.appradiocheckintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCheck, btnRadio,btnListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCheck = findViewById(R.id.btnCheck);
        btnRadio = findViewById(R.id.btnRadio);
        btnListView = findViewById(R.id.btnListView);
        btnCheck.setOnClickListener(this);
        btnRadio.setOnClickListener(this);
        btnListView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnCheck:
               // Toast.makeText(getApplicationContext(), "Hizo click en check", Toast.LENGTH_LONG).show();
                Intent ircheck = new Intent(MainActivity.this, CheckActivity.class);
                ircheck.putExtra("titulocheck", "Ejemplo CheckBox");
                startActivity(ircheck);

                break;
            case R.id.btnRadio:
                //Toast.makeText(getApplicationContext(), "Hizo click en radio", Toast.LENGTH_LONG).show();
                Intent irradio = new Intent(MainActivity.this, RadioActivity.class);
                irradio.putExtra("tituloradio", "Ejemplo RadioButton");
                startActivity(irradio);

                break;
            case R.id.btnListView:
                //Toast.makeText(getApplicationContext(), "Hizo click en radio", Toast.LENGTH_LONG).show();
                Intent irlista = new Intent(MainActivity.this, ListViewActivity.class);
                irlista.putExtra("titulolista", "Ejemplo ListView");
                startActivity(irlista);

                break;
            default:
                Toast.makeText(getApplicationContext(), "Error en la selección", Toast.LENGTH_LONG).show();

        }
    }
}
