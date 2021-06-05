package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    TextView textView;
    EditText userName;
    EditText password;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getting username and password
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        textView = findViewById(R.id.login);
        Intent intent = getIntent();
        title = intent.getStringExtra("Heading");
        textView.setText(title.toString());
    }

    public void Open(View view) {
        if (userName.getText().toString().trim().length() == 0) {
            userName.setError("Enter Email");
        }
        if (password.getText().toString().trim().length() == 0) {
            password.setError("Enter Email");
        }
        if (userName.getText().toString().trim().length() != 0 && password.getText().toString().trim().length() != 0) {
            if (title.equals("Admin Login")) {
                String temp1 = userName.getText().toString();
                String temp2 = password.getText().toString();
                if (userName.getText().toString().equals("Admin") && password.getText().toString().equals("Admin")) {
                    Intent intent2 = new Intent(Login.this, AdminHomePage.class);
                    startActivity(intent2);
                } else
                    Toast.makeText(Login.this, "UserName And Password is invalid", Toast.LENGTH_SHORT).show();
            } else if (title.equals("User Login")) {
                Toast.makeText(Login.this, "User Login", Toast.LENGTH_SHORT).show();
                DbHelper dbHelper = new DbHelper(Login.this);
                ArrayList<User> userlist = dbHelper.getAllRecords();
                boolean flag = false;
                for (int i = 0; i < userlist.size(); i++) {
                    User user = userlist.get(i);
                    if (user.getEmail().equals(userName.getText().toString()) && user.getPassword().equals(password.getText().toString())) {
                        flag = true;
                    }
                }
                if (flag == true) {
                    Intent intent2 = new Intent(Login.this, UserHomePage.class);
                    intent2.putExtra("UserName", userName.getText().toString());
                    Toast.makeText(Login.this, "User Login", Toast.LENGTH_SHORT).show();
                    startActivity(intent2);
                } else {
                    Toast.makeText(Login.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Login.this, "You Are not a User of this Login", Toast.LENGTH_SHORT).show();
            }
        }

    }
}