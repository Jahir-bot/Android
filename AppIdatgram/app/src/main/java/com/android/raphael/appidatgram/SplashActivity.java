package com.android.raphael.appidatgram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Intent inLogin = new Intent(this,
                LoginActivity.class);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                }catch (InterruptedException ex)
                {
                }finally {
                    startActivity(inLogin);
                    finish();
                }
            }
        };

        timer.start();
    }
}
