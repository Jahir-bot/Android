package com.android.jahir.appexamenestudioexamen;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class CuestionarioCovidActivity extends AppCompatActivity implements View.OnClickListener{
    private CheckBox chkGusto, chkTos, chkGarganta, chkNasal, chkFiebre, chkNinguno, chkLuz, chkAgua, chkInternet, chkCable;
    private RadioButton rdbtnFiebreSi, rdbtnFiebreNo, rdbtnSoloSi, rdbtnSoloNo, rdbtnAdultoSi, rdbtnAdultoNo;
    private Button btnResolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuestionario_covid);
        chkGusto = findViewById(R.id.chkGusto);
        chkTos = findViewById(R.id.chkTos);
        chkGarganta = findViewById(R.id.chkGarganta);
        chkNasal = findViewById(R.id.chkNasal);
        chkFiebre = findViewById(R.id.chkFiebre);
        chkNinguno = findViewById(R.id.chkNinguno);
        chkLuz = findViewById(R.id.chkLuz);
        chkAgua = findViewById(R.id.chkAgua);
        chkInternet = findViewById(R.id.chkInternet);
        chkCable = findViewById(R.id.chkCable);

        rdbtnFiebreSi = findViewById(R.id.rdbtnFiebreSi);
        rdbtnFiebreNo = findViewById(R.id.rdbtnFiebreNo);
        rdbtnSoloSi = findViewById(R.id.rdbtnSoloSi);
        rdbtnSoloNo = findViewById(R.id.rdbtnSoloNo);
        rdbtnAdultoSi = findViewById(R.id.rdbtnAdultoSi);
        rdbtnAdultoNo = findViewById(R.id.rdbtnAdultoNo);

        btnResolver = findViewById(R.id.btnResolver);
        btnResolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnResolver:{
                if (chkGusto.isChecked()==false & chkTos.isChecked()==false & chkGarganta.isChecked()==false
                        & chkNasal.isChecked()==false & chkFiebre.isChecked()==false & chkNinguno.isChecked()==false)
                {
                    Snackbar.make(v,"Seleccionar un síntoma",Snackbar.LENGTH_LONG).show();
                }else if (rdbtnFiebreSi.isChecked()==false & rdbtnFiebreNo.isChecked()==false)
                {
                    Snackbar.make(v,"Confirmar si tuvo fiebre",Snackbar.LENGTH_LONG).show();
                }else if(rdbtnSoloSi.isChecked()==false & rdbtnSoloNo.isChecked()==false)
                {
                    Snackbar.make(v,"Confirmar si vive solo",Snackbar.LENGTH_LONG).show();
                }else if(rdbtnAdultoSi.isChecked()==false & rdbtnAdultoNo.isChecked()==false)
                {
                    Snackbar.make(v,"Confimar si vive con un adulto mayor",Snackbar.LENGTH_LONG).show();
                }else if (chkLuz.isChecked()==false & chkAgua.isChecked()==false & chkInternet.isChecked()==false
                            & chkCable.isChecked()==false)
                {
                    Snackbar.make(v,"Confirmar con que servicios cuenta",Snackbar.LENGTH_LONG).show();
                }else
                {
                    String sintomas="", fiebre="", solo="", adulto="", servicios="";
                    if (chkGusto.isChecked())
                    {
                        sintomas="Disminución del gusto o del olfato";
                    }
                    if (chkTos.isChecked())
                    {
                        sintomas=sintomas+"\nTos";
                    }
                    if (chkGarganta.isChecked())
                    {
                        sintomas=sintomas+"\nDolor de Garganta";
                    }
                    if (chkNasal.isChecked())
                    {
                        sintomas=sintomas+"\nCongestión nasal";
                    }
                    if (chkFiebre.isChecked())
                    {
                        sintomas=sintomas+"\nFiebre";
                    }
                    if (chkNinguno.isChecked())
                    {
                        sintomas="Ninguno";
                    }


                    if (rdbtnFiebreSi.isChecked())
                    {
                        fiebre="Si";
                    }
                    if (rdbtnFiebreNo.isChecked())
                    {
                        fiebre="No";
                    }

                    if (rdbtnSoloSi.isChecked())
                    {
                        solo="Si";
                    }
                    if (rdbtnSoloNo.isChecked())
                    {
                        solo="No";
                    }

                    if (rdbtnAdultoSi.isChecked())
                    {
                        adulto="Si";
                    }
                    if (rdbtnAdultoNo.isChecked())
                    {
                        adulto="No";
                    }

                    if (chkLuz.isChecked())
                    {
                        servicios="Luz";
                    }
                    if (chkAgua.isChecked())
                    {
                        servicios=servicios+"\nAgua";
                    }
                    if (chkInternet.isChecked())
                    {
                        servicios=servicios+"\nInternet";
                    }
                    if (chkCable.isChecked())
                    {
                        servicios=servicios+"\nCable";
                    }

                    Intent variable= new Intent(this,ResumenCovidActivity.class);
                    variable.putExtra("sintomas",sintomas);
                    variable.putExtra("fiebre",fiebre);
                    variable.putExtra("solo",solo);
                    variable.putExtra("adulto",adulto);
                    variable.putExtra("servicios",servicios);
                    startActivity(variable);
                }
            }break;
        }
    }
}
