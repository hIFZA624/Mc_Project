package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class updateDriver extends AppCompatActivity {
    EditText Name;
    EditText Mobile;
    EditText Adress;
    EditText password;
    EditText Area;
    EditText CNIC;
    EditText DEmail;
    DriverModel driverModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_driver);
        driverModel= (DriverModel) getIntent().getSerializableExtra("DriverModel");
        Name=findViewById(R.id.updatename);
        Mobile=findViewById(R.id.updatemobile);
        Adress=findViewById(R.id.updateadress);
        password=findViewById(R.id.updatepwd);
        Area=findViewById(R.id.updatearea);
        CNIC=findViewById(R.id.updatecnic);
        DEmail=findViewById(R.id.updatemaildriver);
        //set texts
        Name.setText(driverModel.getName());
        Mobile.setText(driverModel.getMobile());
        Adress.setText(driverModel.getAdress());
        password.setText(driverModel.getPassword());
        Area.setText(driverModel.getArea());
        CNIC.setText(driverModel.getCNIC());
        DEmail.setText(driverModel.getEMAIL());
    }
    public void UpdateDriver(View view) {
        String Status= "false";
        DriverModel driver= new DriverModel(Name.getText().toString(),password.getText().toString(),Mobile.getText().toString(),Adress.getText().toString(), Area.getText().toString(),CNIC.getText().toString(),driverModel.getId(),DEmail.getText().toString(),Status);
        DbHelper dbHelper = new DbHelper(updateDriver.this);

        boolean b = dbHelper.UpdateDriver(driver);
        if (b == true)
            Toast.makeText(updateDriver.this, "Driver updated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(updateDriver.this, " Driver not updated ", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(updateDriver.this,ViewDriver.class);

        startActivity(intent);
    }
}