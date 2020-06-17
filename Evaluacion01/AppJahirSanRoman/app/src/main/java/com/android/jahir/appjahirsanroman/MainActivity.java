package com.android.jahir.appjahirsanroman;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private RadioButton rdbtn1,rdbtn2,rdbtn3;
    private Button btnIngresar;

    private final int op0=0;
    private final int op1=1;
    private final int op2=2;
    private final int op3=3;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdbtn1 = (RadioButton) findViewById(R.id.rdbtn1);
        rdbtn2 = (RadioButton) findViewById(R.id.rdbtn2);
        rdbtn3 = (RadioButton) findViewById(R.id.rdbtn3);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnIngresar:{
                int option;
                option=(rdbtn1.isChecked() ? op1 : op0) | (rdbtn2.isChecked() ? op2 : op0) |
                        (rdbtn3.isChecked() ? op3 : op0);
                switch (option)
                {
                    case 0:{
                        Snackbar.make(v,"Seleccione una opción",Snackbar.LENGTH_LONG).show();
                    }break;
                    case 1:{
                        Intent op1 = new Intent(getApplicationContext(),CalculadoraActivity.class);
                        startActivity(op1);
                    }break;
                    case 2:{
                        Intent op2 = new Intent(getApplicationContext(),DeterminaAnioActivity.class);
                        startActivity(op2);;
                    }break;
                    case 3:{
                        Intent op3 = new Intent(getApplicationContext(),SumaNumerosPrimosActivity.class);
                        startActivity(op3);
                    }break;
                }
            }break;
        }
    }
}
