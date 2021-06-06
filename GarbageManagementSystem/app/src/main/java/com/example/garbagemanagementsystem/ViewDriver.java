package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewDriver extends AppCompatActivity {
ListView listView;
    ArrayList<String> Name;
    ArrayList<String> password;
    ArrayList<String> Mobile;
    ArrayList<String> Adress;
    ArrayList<String> Area;
    ArrayList<String> cnic;
    ArrayList<Integer> id;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_driver);
        listView=findViewById(R.id.listviewdriver);
        dbHelper=new DbHelper(ViewDriver.this);
        Area=new ArrayList<String>();
        Name=new ArrayList<String>();
        password=new ArrayList<String>();
        Mobile=new ArrayList<String>();
        Adress=new ArrayList<String>();
        cnic=new ArrayList<String>();
        id=new ArrayList<Integer>();
        ArrayList<DriverModel> dr=dbHelper.getRecordsofDriver();
        for(int i=0;i<dr.size();i++) {

            DriverModel d=dr.get(i);
            Toast.makeText(ViewDriver.this,d.toString(),Toast.LENGTH_SHORT).show();
            id.add((d.getId()));
            Area.add(d.getArea());
            Name.add(d.getName());
            password.add(d.getPassword());
            Mobile.add(d.getMobile());
            Adress.add(d.getAdress());
            cnic.add(d.getCNIC());

        }
        AlertDialog.Builder builder=new AlertDialog.Builder(ViewDriver.this);

        DriverAdapter driveradapter= new DriverAdapter(this,Name,password,Mobile,Adress, Area,cnic,id,dbHelper,builder);
listView.setAdapter(driveradapter);
    }
}