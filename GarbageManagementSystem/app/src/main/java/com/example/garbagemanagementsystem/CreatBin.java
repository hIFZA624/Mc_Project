package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class CreatBin extends AppCompatActivity {
String [] load;
AutoCompleteTextView drpbox1;
String [] cycle;
    AutoCompleteTextView drpbox2;
    TextInputLayout text;

    ArrayAdapter<String> arrayAdapter;
ArrayAdapter<String> arrayAdapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat_bin);
        load=getResources().getStringArray(R.array.Load);
        cycle=getResources().getStringArray(R.array.Cycle);
        drpbox1=findViewById(R.id.autoCompleteTextView);
        drpbox2=findViewById(R.id.autoCompleteTextView2);


        arrayAdapter=new ArrayAdapter<String>(CreatBin.this,R.layout.dropdown_item,load);
        drpbox1.setAdapter(arrayAdapter);
        arrayAdapter2=new ArrayAdapter<String>(CreatBin.this,R.layout.dropdown_item,cycle);

        drpbox2.setAdapter(arrayAdapter2);
    }
}