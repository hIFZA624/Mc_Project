package com.example.wastemanagementsystem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class CreatDriver extends AppCompatActivity {
    EditText Name;
    EditText Mobile;
    EditText Adress;
    EditText password;
    EditText Area;
    EditText CNIC;
    EditText Email;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_driver);
        Name=findViewById(R.id.name);
        Mobile=findViewById(R.id.mobile);
        Adress=findViewById(R.id.adress);
        password=findViewById(R.id.pwd);
        Area=findViewById(R.id.area);
        CNIC=findViewById(R.id.cnic);
        Email=findViewById(R.id.edriver);
        toolbar = findViewById(R.id.toolbaradddriver);
        nav = findViewById(R.id.navmenuadddriver);
        drawerLayout = findViewById(R.id.draweradddriver);
        toggle=new  ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    public void RegisterDriver(View view) {
        String status= "Pending";
        DriverModel driver= new DriverModel(Name.getText().toString(),password.getText().toString(),Mobile.getText().toString(),Adress.getText().toString(), Area.getText().toString(),CNIC.getText().toString(),1,Email.getText().toString(),status);
        DbHelper dbHelper = new DbHelper(CreatDriver.this);
       boolean b = dbHelper.addDriver(driver);
       if (b == true) {
           Intent intent=new Intent(CreatDriver.this,ViewDriver.class);
           startActivity(intent);
           Toast.makeText(CreatDriver.this, "Driver Registered", Toast.LENGTH_SHORT).show();
       }
        else
            Toast.makeText(CreatDriver.this, " Driver not Registered ", Toast.LENGTH_SHORT).show();
    }
}