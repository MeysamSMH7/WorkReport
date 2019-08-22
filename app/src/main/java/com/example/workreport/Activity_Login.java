package com.example.workreport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final SharedPreferences preferences = getSharedPreferences("WorkReport", 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("FirstTime?", true);
        editor.apply();

        Button btnlogin = findViewById(R.id.btnlogin);
        final EditText edtUsername = findViewById(R.id.edtUsername);
        final EditText edtPassword = findViewById(R.id.edtPassword);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if (username.equals("admin") && password.equals("123")) {
                    Intent intent = new Intent(Activity_Login.this, MainActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(Activity_Login.this, "نام کاربری یا رمز عبور صحیح نیست", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
