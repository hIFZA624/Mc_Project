package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class UserProfile extends AppCompatActivity {
    TextView FirstName;
    TextView LastName;
    TextView Email;
    TextView password;
    TextView ConfirmPassword;
    Intent intent;
    String firstname;
    String lastname;
    String email;
    String password123;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        FirstName = findViewById(R.id.ProfileFirstName);
        LastName = findViewById(R.id.ProfileLastName);
        Email = findViewById(R.id.ProfileEmail);
        password = findViewById(R.id.ProfilePassword);
        intent = getIntent();
        username = intent.getStringExtra("UserNamepROFILE");
        DbHelper dbHelper = new DbHelper(UserProfile.this);
        ArrayList<User> bin = dbHelper.getAllRecords();
        for (int i = 0; i < bin.size(); i++) {
            User user=bin.get(i);
            if (user.getEmail().equals(username)) {
                FirstName.setText(user.getFirstName());
                LastName.setText(user.getLastName());
                password.setText(user.getPassword());
                Email.setText(user.getEmail());
            }

        }
    }
    public void update(View view) {
       Intent intent=new Intent(UserProfile.this,UpdatePofile.class);
        intent.putExtra("UP",username);
        startActivity(intent);
    }
}