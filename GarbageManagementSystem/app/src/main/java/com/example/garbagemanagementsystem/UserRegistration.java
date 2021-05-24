package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class UserRegistration extends AppCompatActivity {
EditText FirstName;
    EditText LastName;
    EditText Email;
    EditText password;
    EditText ConfirmPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        FirstName=findViewById(R.id.firstName);
        LastName=findViewById(R.id.LastName);
        Email=findViewById(R.id.email);
        password=findViewById(R.id.Password);
        ConfirmPassword=findViewById(R.id.confirmPassword);
        if(FirstName.getText().toString().trim().length()!=0)
        {
            FirstName.setError(null);
        }
        if(LastName.getText().toString().trim().length()!=0)
        {
            LastName.setError(null);
        }
        if(Email.getText().toString().trim().length()!=0)
        {
            Email.setError(null);
        }
        if(password.getText().toString().trim().length()!=0)
        {
            password.setError(null);
        }
    }
    public void RegisterUser(View view) {
        /*DbHelper dbHelper = new DbHelper(UserRegistration.this);
        List<User> allcustomers=dbHelper.getAllRecords();
        Toast.makeText(UserRegistration.this,allcustomers.toString(), Toast.LENGTH_LONG).show();*/
        if(FirstName.getText().toString().trim().length()==0)
        {
            FirstName.setError("Enter First Name");
        }

        if(LastName.getText().toString().trim().length()==0)
        {
            LastName.setError("Enter Last Name");
        }

        if(Email.getText().toString().trim().length()==0)
        {
            Email.setError("Enter Email");
        }

        if(password.getText().toString().trim().length()==0)
        {
            password.setError("Enter Password");
        }

        if(ConfirmPassword.getText().toString().trim().length()==0)
        {
            ConfirmPassword.setError("Enter Confirmed Password");
        }



        if(FirstName.getText().toString().trim().length()!=0 && LastName.getText().toString().trim().length()!=0 && Email.getText().toString().trim().length()!=0 && password.getText().toString().trim().length()!=0 && ConfirmPassword.getText().toString().trim().length()!=0) {
                if (password.equals(ConfirmPassword)) {
                    User user = new User(FirstName.getText().toString(), LastName.getText().toString(), Email.getText().toString(), password.getText().toString(), ConfirmPassword.getText().toString(), 1);
                    // Toast.makeText(UserRegistration.this, user.toString(), Toast.LENGTH_SHORT).show();
                    DbHelper dbHelper = new DbHelper(UserRegistration.this);
                    boolean b = dbHelper.addUser(user);
                    if (b == true)
                        Toast.makeText(UserRegistration.this, "uSER aDDED", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(UserRegistration.this, "User Not ADDED", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(UserRegistration.this, "Password Not Matched", Toast.LENGTH_SHORT).show();
            }
    }
}