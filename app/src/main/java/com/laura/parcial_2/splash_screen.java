package com.laura.parcial_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splash_screen extends AppCompatActivity {

    private static final String dataUserCache = "user";
    private static final int privateMode = Context.MODE_PRIVATE;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        cacheValidation();
    }

    private void cacheValidation() {
        usuario = getApplicationContext().getSharedPreferences(dataUserCache, privateMode).getString("user", "0");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i;
                if ( usuario.equalsIgnoreCase("0")) {
                    i = new Intent(splash_screen.this, Login.class);
                } else {
                    i = new Intent(splash_screen.this, MainActivity.class);
                }
                startActivity(i);
            }
        }, 500);
    }
}