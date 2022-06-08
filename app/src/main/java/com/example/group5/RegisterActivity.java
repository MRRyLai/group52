package com.example.group5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ourfood.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements OnCompleteListener{

    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhone;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_phone);
        etPhone = findViewById(R.id.et_phone);

        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void onRegister(View view){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, this);
    }

    @Override
    public void onComplete(@NonNull Task task) {
        if(task.isSuccessful()){
            Toast.makeText(this, "註冊成功", Toast.LENGTH_SHORT).show();
            addUser();
            finish();
        }else{
            Toast.makeText(this, "註冊失敗", Toast.LENGTH_SHORT).show();
        }
    }
    public void onCancel(View view){
        finish();
    }

    private void addUser(){
        String email = etEmail.getText().toString();
        String phone = etPhone.getText().toString();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference userRef = firebaseDatabase.getReference("users");
        DatabaseReference phoneRef = userRef.child(phone);
        Map<String, Object> user = new HashMap<>();
        user.put("email", email);
        user.put("phone", phone);
        phoneRef.updateChildren(user);
    }
}