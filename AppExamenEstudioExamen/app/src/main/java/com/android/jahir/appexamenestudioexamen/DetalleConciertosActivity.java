package com.android.jahir.appexamenestudioexamen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.jahir.appexamenestudioexamen.model.concierto;

public class DetalleConciertosActivity extends AppCompatActivity {
    private TextView txtTituloDetalleConcierto;
    private ImageView imgDetalleConciertoo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_conciertos);
        txtTituloDetalleConcierto = findViewById(R.id.txtTituloDetalleConcierto);
        imgDetalleConciertoo = findViewById(R.id.imgDetalleConciertoo);

        if (getIntent().hasExtra("concierto"))
        {
            concierto objconcierto = getIntent().getParcelableExtra("concierto");
            imgDetalleConciertoo.setImageResource(objconcierto.getImagen());
            txtTituloDetalleConcierto.setText(Html.fromHtml("<b>Fecha: </b>"+objconcierto.getFecha()));
        }

    }
}