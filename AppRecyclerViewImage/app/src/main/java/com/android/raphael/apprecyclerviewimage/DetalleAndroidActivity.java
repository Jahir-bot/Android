package com.android.raphael.apprecyclerviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.raphael.apprecyclerviewimage.model.Android;

public class DetalleAndroidActivity extends AppCompatActivity {
    private TextView txtNombreDetalleAndroid,txtVersionDetalleAndroid;
    private ImageView imgDetalleAndroid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_android);
        txtNombreDetalleAndroid = findViewById(R.id.txtNombreDetalleAndroid);
        txtVersionDetalleAndroid = findViewById(R.id.txtVersionDetalleAndroid);
        imgDetalleAndroid = findViewById(R.id.imgDetalleAndroid);

            if (getIntent().hasExtra("android"))
            {
                Android objAndroid = getIntent().getParcelableExtra("android");
                imgDetalleAndroid.setImageResource(objAndroid.getImagen());
                txtNombreDetalleAndroid.setText(Html.fromHtml("<b>Android: </b>"+objAndroid.getNombre()));
                txtVersionDetalleAndroid.setText(Html.fromHtml("<b>Version: </b>"+objAndroid.getVersion()));
            }
    }
}
