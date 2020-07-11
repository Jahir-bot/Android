package com.android.jahir.appfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnFragment1,btnFragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFragment1 = findViewById(R.id.btnFragment1);
        btnFragment2 = findViewById(R.id.btnFragment2);
        btnFragment1.setOnClickListener(this);
        btnFragment2.setOnClickListener(this);
        final Fragment1 frag1 = new Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.flContenedor,frag1).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnFragment1:{
                final Fragment1 frag1 = new Fragment1();
                getSupportFragmentManager().beginTransaction().replace(R.id.flContenedor,frag1).commit();
            }break;
            case R.id.btnFragment2:{
                final Fragment2 frag2 = new Fragment2();
                getSupportFragmentManager().beginTransaction().replace(R.id.flContenedor,frag2).commit();
            }break;
        }
    }
}
