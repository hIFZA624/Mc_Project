package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class UserProfile extends AppCompatActivity {
    String username;
    TextView FirstName;
    TextView LastName;
    TextView Email;
    TextView password;
    Button Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        Intent intent = getIntent();
        username = intent.getStringExtra("UserProfileName");
        FirstName=findViewById(R.id.ProfileFirstName);
        LastName=findViewById(R.id.ProfileLastName);
        Email=findViewById(R.id.ProfileEmail);
        password=findViewById(R.id.ProfilePassword);
        Update=findViewById(R.id.UpdateUserProfile);
        DbHelper dbHelper = new DbHelper(UserProfile.this);
        ArrayList<User> userlist = dbHelper.getAllRecords();
        boolean flag = false;
        for (int i = 0; i < userlist.size(); i++) {
            User user = userlist.get(i);
            if (user.getEmail().equals(username)) {
               FirstName.setText(user.getFirstName());
                LastName.setText(user.getLastName());
                password.setText(user.getPassword());
                Email.setText(user.getEmail());
            }
        }
    }

    public void update(View view) {
        Intent intent=new Intent(UserProfile.this,UpdateProfile.class);
        intent.putExtra("UP",username);
        startActivity(intent);
    }
}