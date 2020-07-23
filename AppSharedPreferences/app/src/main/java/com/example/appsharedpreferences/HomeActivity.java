package com.example.appsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView tvUsuario;
    private Button btnCerrarSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tvUsuario = findViewById(R.id.tvUsuario);
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        SharedPreferences preferences= getSharedPreferences("appIDAT", MODE_PRIVATE);
        tvUsuario.setText(preferences.getString("usuario","usuario"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("appIDAT",MODE_PRIVATE).edit();
                editor.clear();
                editor.apply();
                startActivity(new Intent(HomeActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}