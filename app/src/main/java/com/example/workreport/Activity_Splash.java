package com.example.workreport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Activity_Splash extends AppCompatActivity {

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


    final SharedPreferences preferences = getSharedPreferences("WorkReport", 0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean firstTime = preferences.getBoolean("FirstTime?", true);
                Intent intent;
                if (firstTime)
                    intent = new Intent(context, Activity_Welcome.class);
                else
                    intent = new Intent(context, Activity_Login.class);

                startActivity(intent);
                finish();
            }
        }, 4000);



    }
}
