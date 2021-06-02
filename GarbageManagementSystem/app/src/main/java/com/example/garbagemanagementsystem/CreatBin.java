package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class CreatBin extends AppCompatActivity {
String [] load;
AutoCompleteTextView drpbox1;
String [] cycle;
    EditText Area;
    EditText Locality;
    EditText DriverEmail;
    EditText BestRout;
    EditText LandMark;
    EditText City;

    AutoCompleteTextView drpbox2;
    TextInputLayout text;

    ArrayAdapter<String> arrayAdapter;
ArrayAdapter<String> arrayAdapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_bin);
        Area=findViewById(R.id.BinArea);
        Locality=findViewById(R.id.Locality);
        DriverEmail=findViewById(R.id.Email);
        BestRout=findViewById(R.id.Rout);
        LandMark=findViewById(R.id.Land);
        City=findViewById(R.id.City);

        //load=getResources().getStringArray(R.array.Load);
        //cycle=getResources().getStringArray(R.array.Cycle);
        drpbox1=findViewById(R.id.autoCompleteTextView);
        drpbox2=findViewById(R.id.autoCompleteTextView2);


        arrayAdapter=new ArrayAdapter<String>(CreatBin.this,R.layout.dropdown_item,load);
        drpbox1.setAdapter(arrayAdapter);

        arrayAdapter2=new ArrayAdapter<String>(CreatBin.this,R.layout.dropdown_item,cycle);

        drpbox2.setAdapter(arrayAdapter2);

    }

    public void AddBin(View view) {

        String loadtype=drpbox1.getText().toString();
        String cyclicPeriod=drpbox2.getText().toString();
        BinModel bin= new BinModel(Area.getText().toString(),Locality.getText().toString(),LandMark.getText().toString(),City.getText().toString(),DriverEmail.getText().toString(),BestRout.getText().toString() ,loadtype,cyclicPeriod,1);

        DbHelper dbHelper = new DbHelper(CreatBin.this);
        boolean b = dbHelper.addBin(bin);
        if (b == true)
            Toast.makeText(CreatBin.this, "Bin ADDED", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(CreatBin.this, "Bin Not ADDED", Toast.LENGTH_SHORT).show();

    }
}