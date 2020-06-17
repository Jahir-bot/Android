package com.android.jahir.appexamenestudioexamen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Intent menu = new Intent(this,
                MainActivity.class);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                }catch (InterruptedException ex)
                {
                }finally {
                    startActivity(menu);
                    finish();
                }
            }
        };

        timer.start();
    }
}
