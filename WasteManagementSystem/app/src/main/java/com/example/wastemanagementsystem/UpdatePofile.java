package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdatePofile extends AppCompatActivity {
    String username;
    EditText FirstName;
    EditText LastName;
    EditText Email;
    EditText password;
    Button Update;
    User user;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pofile);
        Intent intent = getIntent();
        username = intent.getStringExtra("UP");
        FirstName = findViewById(R.id.UpFirstName);
        LastName = findViewById(R.id.UPLastName);
        Email = findViewById(R.id.UpEmail);
        password = findViewById(R.id.UpPassword);

        Update = findViewById(R.id.UpdateProfile);
        dbHelper = new DbHelper(UpdatePofile.this);
        ArrayList<User> userlist = dbHelper.getAllRecords();
        boolean flag = false;
        for (int i = 0; i < userlist.size(); i++) {
            user = userlist.get(i);
            if (user.getEmail().equals(username)) {
                FirstName.setText(user.getFirstName());
                LastName.setText(user.getLastName());
                password.setText(user.getPassword());
                Email.setText(user.getEmail());
            }
        }
    }
        public void updatinguser(View view) {
            User u= new User(FirstName.getText().toString(),LastName.getText().toString(),Email.getText().toString(),password.getText().toString(),password.getText().toString(),user.getId());

            dbHelper = new DbHelper(UpdatePofile.this);
            boolean b = dbHelper.updateUSER(FirstName.getText().toString(),LastName.getText().toString(),Email.getText().toString(),String.valueOf(user.getId()),password.getText().toString());

            if (b == true)
                Toast.makeText(UpdatePofile.this, "Profile Updated", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(UpdatePofile.this, "Profile Not Updated", Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(UpdatePofile.this,UserProfile.class);
            intent.putExtra("UserNamepROFILE",username);
//public User(String firstName, String lastName, String email,  String Password,String ConfirmPassword,int Id)
            startActivity(intent);
        }
}

