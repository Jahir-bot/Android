package com.android.jahir.appmovilnivelmedio;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioButton rdbtn1, rdbtn2, rdbtn3, rdbtn4, rdbtn5, rdbtn6, rdbtn7, rdbtn8,rdbtn9,rdbtn10;
    private Button btnIngresar;

    private final int neutro = 0;
    private final int op1 = 1;
    private final int op2 = 2;
    private final int op3 = 3;
    private final int op4 = 4;
    private final int op5 = 5;
    private final int op6 = 6;
    private final int op7 = 7;
    private final int op8 = 8;
    private final int op9 = 9;
    private final int op10 = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdbtn1 = (RadioButton) findViewById(R.id.rdbtn1);
        rdbtn2 = (RadioButton) findViewById(R.id.rdbtn2);
        rdbtn3 = (RadioButton) findViewById(R.id.rdbtn3);
        rdbtn4 = (RadioButton) findViewById(R.id.rdbtn4);
        rdbtn5 = (RadioButton) findViewById(R.id.rdbtn5);
        rdbtn6 = (RadioButton) findViewById(R.id.rdbtn6);
        rdbtn7 = (RadioButton) findViewById(R.id.rdbtn7);
        rdbtn8 = (RadioButton) findViewById(R.id.rdbtn8);
        rdbtn9 = (RadioButton) findViewById(R.id.rdbtn9);
        rdbtn10 = (RadioButton) findViewById(R.id.rdbtn10);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnIngresar: {
                int option;
                option = (rdbtn1.isChecked() ? op1 : neutro) | (rdbtn2.isChecked() ? op2 : neutro) | (rdbtn3.isChecked() ? op3 : neutro) |
                        (rdbtn4.isChecked() ? op4 : neutro) | (rdbtn5.isChecked() ? op5 : neutro) | (rdbtn6.isChecked() ? op6 : neutro) |
                        (rdbtn7.isChecked() ? op7 : neutro) | (rdbtn8.isChecked() ? op8 : neutro) | (rdbtn9.isChecked() ? op9 : neutro) |
                        (rdbtn10.isChecked() ? op10 : neutro);
                switch (option) {
                    case 0: {
                        Snackbar.make(v, "Seleccione una opcion", Snackbar.LENGTH_LONG).show();
                    }
                    break;
                    case 1: {
                        Intent op1 = new Intent(getApplicationContext(), AreaCirculoActivity.class);
                        startActivity(op1);
                    }
                    break;
                    case 2: {
                        Intent op2 = new Intent(getApplicationContext(), AreaRectanguloActivity.class);
                        startActivity(op2);
                    }
                    break;
                    case 3: {
                        Intent op3 = new Intent(getApplicationContext(), AreaTrianguloActivity.class);
                        startActivity(op3);
                    }
                    break;
                    case 4: {
                        Intent op4 = new Intent(getApplicationContext(), DeterminarAnioBiciestoActivity.class);
                        startActivity(op4);
                    }
                    break;
                    case 5: {
                        Intent op5 = new Intent(getApplicationContext(), SerieNumerosActivity.class);
                        startActivity(op5);
                    }
                    break;
                    case 6: {
                        Intent op6 = new Intent(getApplicationContext(), DeterminaMayorNumeroActivity.class);
                        startActivity(op6);
                    }
                    break;
                    case 7: {
                        Intent op7 = new Intent(getApplicationContext(), CalcularAniosActivity.class);
                        startActivity(op7);
                    }
                    break;
                    case 8: {
                        Intent op8 = new Intent(getApplicationContext(), SumaDigitosActivity.class);
                        startActivity(op8);
                    }
                    break;
                    case 9:{
                        Intent op9=new Intent(getApplicationContext(),DeterminaNumeroActivity.class);
                        startActivity(op9);
                    }break;
                    case 10:
                    {
                        Intent op10=new Intent(getApplicationContext(),CilindroActivity.class);
                        startActivity(op10);
                    }break;
                }
            }
            break;
        }
    }
}
