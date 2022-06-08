package com.example.group5;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class want_sell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_sell);
    }

    public void go_back(View view){
//        Intent it = new Intent(this,shop_host.class );
//        startActivity(it);
        finish();
    }
}