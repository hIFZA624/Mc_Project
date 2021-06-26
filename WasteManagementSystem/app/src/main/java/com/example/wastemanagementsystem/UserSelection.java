package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserSelection extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);
    }
    public void UserLogin(View view) {
        Intent intent=new Intent(UserSelection.this,Login.class);
        intent.putExtra("Heading","User Login");
        startActivity(intent);
    }
    public void DriverLogin(View view) {
        Intent intent=new Intent(UserSelection.this,Login.class);
        intent.putExtra("Heading","Driver Login");
        startActivity(intent);
    }
    public void AdminLogin(View view) {
        Intent intent=new Intent(UserSelection.this,Login.class);
        intent.putExtra("Heading","Admin Login");
        startActivity(intent);
    }
    public void userRegister(View view) {
        Intent intent=new Intent(UserSelection.this,UserRegistration.class);
        startActivity(intent);
    }
}