package com.android.jahir.semana_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "App creado",Toast.LENGTH_SHORT).show();
        Log.i("Mensaje","Se ejecutó el método onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this, "App Iniciado",Toast.LENGTH_SHORT).show();
        Log.i("Mensaje","Se ejecutó el método onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(MainActivity.this, "App resumido",Toast.LENGTH_SHORT).show();
        Log.i("Mensaje","Se ejecutó el método onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this, "App destruido",Toast.LENGTH_SHORT).show();
        Log.i("Mensaje","Se ejecutó el método onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this, "App pausado",Toast.LENGTH_SHORT).show();
        Log.i("Mensaje","Se ejecutó el método onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this, "App parado",Toast.LENGTH_SHORT).show();
        Log.i("Mensaje","Se ejecutó el método onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(MainActivity.this, "App reiniciado",Toast.LENGTH_SHORT).show();
        Log.i("Mensaje","Se ejecutó el método onRestart");
    }
}
