package com.laura.parcial_2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    EditText txt_user, txt_pass;
    Button btn_submit;

    private static final String dataUserCache = "user";
    private static final int privateMode = Context.MODE_PRIVATE;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txt_user = findViewById(R.id.txt_user);
        txt_pass = findViewById(R.id.txt_pass);
        btn_submit = findViewById(R.id.btn_submit);

        sharedPreferences = getSharedPreferences(dataUserCache, privateMode);
        editor = sharedPreferences.edit();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user, pass;
                if ( txt_user.getText().toString().isEmpty() || txt_pass.getText().toString().isEmpty() ) {
                    Toast.makeText(Login.this, "error", Toast.LENGTH_SHORT).show();
                } else {
                    user = txt_user.getText().toString();
                    pass = txt_pass.getText().toString();

                    editor.putString("user", user);
                    editor.putString("pass", pass);

                    editor.commit();
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }
}