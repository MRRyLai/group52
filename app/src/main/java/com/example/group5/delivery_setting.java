package com.example.group5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ourfood.R;

public class delivery_setting extends AppCompatActivity {

    TextView textView;
    private String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_set);

        textView = findViewById(R.id.del_name);
        if(Login.log_username!=""){
            username = Login.log_username;
            Login.log_username = "";
        }else{
            username = Register.reg_username;
            Register.reg_username = "";
        }
        textView.setText(username);
    }

    public void onclick(View v){
        switch (v.getId()){

            case R.id.btn_changeIdentity:
                Intent intent = new Intent(this, choose_identity.class);
                startActivity(intent);
                break;
            case R.id.btn_delLogout:
                Intent intent1 = new Intent(this, Login.class);
                startActivity(intent1);
                finish();
                break;
            /*
            case R.id.btn_changeStatus:
                Intent intent2 = new Intent(this, delStatus.class);
                startActivity(intent2);
                break;
            */
            case R.id.del_home:
                Intent intent3 = new Intent(this, delivery_HP.class);
                startActivity(intent3);
                break;
            case R.id.ib_home:
                break;
            case R.id.ib_shpooingcar:
                Intent intent4 = new Intent(this, ShoppingcarActivity.class);
                startActivity(intent4);
                break;
            case R.id.ib_menu:
                Intent intent5 = new Intent(this, MenuActivity.class);
                startActivity(intent5);
                break;
        }
    }

}
