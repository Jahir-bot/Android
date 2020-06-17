package com.android.raphael.apprecyclerviewimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.raphael.apprecyclerviewimage.adapters.AndroidAdapter;
import com.android.raphael.apprecyclerviewimage.model.Android;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvAndroid;
    private AndroidAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvAndroid = findViewById(R.id.rvAndroid);
        rvAndroid.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new AndroidAdapter(MainActivity.this);
        rvAndroid.setAdapter(adapter);

        ArrayList<Android> lista = new ArrayList<>();
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image1,
                "Apple Pie",
                "Android 1.0"
                ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image2,
                "Banana Brend",
                "Android 1.1"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image3,
                "Cupcake",
                "Android 1.5"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image4,
                "Donut",
                "Android 1.6"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image5,
                "Eclair",
                "Android 2.0-2.1"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image6,
                "Froyo",
                "Android 2.2"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image7,
                "Gingerbread",
                "Android 2.3"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image8,
                "Honeycomb",
                "Android 3.0"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image9,
                "Ice cream sandwich",
                "Android 4.0"
        ));
        lista.add(new Android(
                lista.size()+1,
                R.drawable.image10,
                "Jelly bean",
                "Android 4.1-4.2-4-3"
        ));
        adapter.agregarElemento(lista);
    }
}
