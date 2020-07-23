package com.example.appsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
    private EditText etUsuario, etPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        //Definiendo el objeto Shared Preferences
        SharedPreferences preferences = getSharedPreferences("appIDAT",MODE_PRIVATE);
        if (preferences.contains("usuario"))
        {
            startActivity(new Intent(MainActivity.this, HomeActivity.class));
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();

                //Una vez obtenida la respuesta del WS autenticación

                SharedPreferences.Editor editor = getSharedPreferences("appIDAT",MODE_PRIVATE).edit();
                editor.putString("usuario",usuario);
                editor.putString("password",password);
                editor.apply();
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                finish();
            }
        });
    }
}