package com.example.ourfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.group5.Login;

public class MainActivity extends AppCompatActivity {
    public static boolean VALID_USER = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!VALID_USER){
            Intent intent = new Intent();
            intent.setClass(this, Login.class);
            startActivity(intent);
        }


    }
}