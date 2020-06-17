package com.android.raphael.appidatgram;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class HomeActivity extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Idatgram");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idItem=item.getItemId();
        String mensaje="";
        if (idItem==R.id.opcion_config)
        {
            mensaje="Click en la opcion configuración";
        }else if (idItem == R.id.opcion_camera)
        {
            mensaje="Click en la opcion camara";
        }
        Toast.makeText(this, mensaje,Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}
