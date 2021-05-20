package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Login extends AppCompatActivity {
TextView textView;
EditText userName;
EditText password;
String title;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getting username and password
        userName=findViewById(R.id.username);
        password=findViewById(R.id.password);
        textView=findViewById(R.id.login);
        Intent intent = getIntent();
       title = intent.getStringExtra("Heading");
        textView.setText(title.toString());
    }
    public void Open(View view) {
        DbHelper dbHelper = new DbHelper(Login.this);
        List<User> allcustomers=dbHelper.getAllRecords();
        for(int i=0;i<allcustomers.size();i++)
        {
            User user=allcustomers[i];

        }
        //Toast.makeText(Login.this,userName.toString(), Toast.LENGTH_SHORT).show();
        //Toast.makeText(Login.this,password.toString(), Toast.LENGTH_SHORT).show();
        Intent intent2=new Intent(Login.this,AdminHomePage.class);
        startActivity(intent2);

    }
}