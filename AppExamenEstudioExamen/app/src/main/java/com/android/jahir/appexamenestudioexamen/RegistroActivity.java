package com.android.jahir.appexamenestudioexamen;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{
    private TextInputEditText txtNombre, txtApellido, txtDireccion, txtCelular, txtOtro;
    private CheckBox chkFutbol, chkBasquet,chkVoley, chkOtro;
    private RadioButton rdbtnSoltero, rdbtnCasado, rdbtnDivorciado, rdbtnViudo;
    private Button btnAcceder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellidos);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtCelular = findViewById(R.id.txtCelular);
        txtOtro = findViewById(R.id.txtOtros);
        chkFutbol = findViewById(R.id.chkFutbol);
        chkBasquet = findViewById(R.id.chkBasquet);
        chkVoley = findViewById(R.id.chkVoley);
        chkOtro = findViewById(R.id.chkOtro);
        rdbtnSoltero = findViewById(R.id.rdbtnSoltero);
        rdbtnCasado = findViewById(R.id.rdbtnCasado);
        rdbtnDivorciado = findViewById(R.id.rdbtnDivorciado);
        rdbtnViudo = findViewById(R.id.rdbtnViudo);
        btnAcceder = findViewById(R.id.btnAcceder);
        btnAcceder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnAcceder:
            {
                if (txtNombre.getText().toString().equals("")){
                    Snackbar.make(v,"Ingrese nombre",Snackbar.LENGTH_LONG).show();
                }else if(txtApellido.getText().toString().equals("")){
                    Snackbar.make(v,"Ingrese apellido",Snackbar.LENGTH_LONG).show();
                }else if(txtDireccion.getText().toString().equals("")){
                    Snackbar.make(v,"Ingrese dirección",Snackbar.LENGTH_LONG).show();
                }else if(txtCelular.getText().toString().equals("")){
                    Snackbar.make(v,"Ingrese celular",Snackbar.LENGTH_LONG).show();
                }else if (chkFutbol.isChecked()==false & chkBasquet.isChecked()==false & chkVoley.isChecked()==false & chkOtro.isChecked()==false){
                    Snackbar.make(v,"Seleccione un deporte",Snackbar.LENGTH_LONG).show();
                }else if (chkOtro.isChecked() & txtOtro.getText().toString().equals("")){
                    Snackbar.make(v,"Ingrese su deporte",Snackbar.LENGTH_LONG).show();
                }else if(rdbtnSoltero.isChecked()==false & rdbtnCasado.isChecked()==false & rdbtnDivorciado.isChecked()==false & rdbtnViudo.isChecked()==false){
                    Snackbar.make(v,"Seleccione su Estado Civil",Snackbar.LENGTH_LONG).show();
                }else{
                    String nombre=txtNombre.getText().toString();
                    String apellido=txtApellido.getText().toString();
                    String direccion=txtDireccion.getText().toString();
                    String celular=txtCelular.getText().toString();
                    String futbol="",basquet="",voley="",otro="",deporte="",estado="";

                    if (chkFutbol.isChecked())
                    {
                        deporte="Futbol";
                    }
                    if (chkBasquet.isChecked())
                    {
                        deporte=deporte+"\nBasquet";
                    }
                    if(chkVoley.isChecked())
                    {
                        deporte=deporte+"\nVoley";
                    }
                    if (chkOtro.isChecked())
                    {
                        otro=txtOtro.getText().toString();
                        deporte=deporte+"\n"+otro;
                    }

                    if(rdbtnSoltero.isChecked())
                    {
                        estado="Soltero";
                    }
                    if(rdbtnCasado.isChecked())
                    {
                        estado="Casado";
                    }
                    if(rdbtnDivorciado.isChecked())
                    {
                        estado="Divorciado";
                    }
                    if(rdbtnViudo.isChecked())
                    {
                        estado="Viudo";
                    }
                    Intent variable= new Intent(this,ResumenRegistroActivity.class);
                    variable.putExtra("nombre",nombre);
                    variable.putExtra("apellido",apellido);
                    variable.putExtra("direccion",direccion);
                    variable.putExtra("celular",celular);
                    variable.putExtra("deporte",deporte);
                    variable.putExtra("estado",estado);
                    startActivity(variable);
                }

            }break;
        }
    }
}
