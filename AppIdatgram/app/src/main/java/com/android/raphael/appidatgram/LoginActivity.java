package com.android.raphael.appidatgram;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText txtUsuario, txtPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtPassword = findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario="a1715389",paswword="75440415";

                if (txtUsuario.getText().toString().equals("") && txtPassword.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingrese los campos requeridos por favor",Snackbar.LENGTH_LONG).show();
                    txtUsuario.setError("");
                    txtPassword.setError("");
                }else if (txtUsuario.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingrese su usario por favor",Snackbar.LENGTH_LONG).show();
                    txtUsuario.setError("");
                }else if (txtPassword.getText().toString().equals(""))
                {
                    Snackbar.make(v,"Ingrese su contraseña por favor",Snackbar.LENGTH_LONG).show();
                    txtPassword.setError("");
                }else
                {
                    String usu=txtUsuario.getText().toString();
                    String pas=txtPassword.getText().toString();

                    if (usu.equals(usuario)&&pas.equals(paswword))
                    {
                        startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                    }else
                    {
                        Snackbar.make(v,"Los datos ingresados son incorrectos, intente nuevamente"
                            ,Snackbar.LENGTH_LONG).show();
                        txtUsuario.setError("");
                        txtPassword.setError("");
                    }


                }

            }
        });
    }
}
