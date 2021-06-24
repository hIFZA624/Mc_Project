package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreatDriver extends AppCompatActivity {
    EditText Name;
    EditText Mobile;
    EditText Adress;
    EditText password;
    EditText Area;
    EditText CNIC;
    EditText Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_driver);
        Name=findViewById(R.id.name);;
        Mobile=findViewById(R.id.mobile);;
        Adress=findViewById(R.id.adress);;
        password=findViewById(R.id.pwd);;
        Area=findViewById(R.id.area);;
        CNIC=findViewById(R.id.cnic);;
        Email=findViewById(R.id.edriver);;


    }

    public void RegisterDriver(View view) {
        String status= "false";
        DriverModel driver= new DriverModel(Name.getText().toString(),password.getText().toString(),Mobile.getText().toString(),Adress.getText().toString(), Area.getText().toString(),CNIC.getText().toString(),1,Email.getText().toString(),status);
        DbHelper dbHelper = new DbHelper(CreatDriver.this);
        boolean b = dbHelper.addDriver(driver);
        if (b == true)
            Toast.makeText(CreatDriver.this, "Driver Registered", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(CreatDriver.this, " Driver not Registered ", Toast.LENGTH_SHORT).show();

    }
}