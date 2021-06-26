package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class updateBin extends AppCompatActivity {
    String [] cycle;
    String [] load;
    EditText Area;
    EditText Locality;
    EditText DriverEmail;
    EditText source;
    EditText des;
    EditText LandMark;
    EditText City;
    AutoCompleteTextView drpbox2;
    AutoCompleteTextView drpbox1;
    BinModel binModel;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_bin);
        binModel= (BinModel) getIntent().getSerializableExtra("BinModel");
        Area=findViewById(R.id.updateBinArea);
        Locality=findViewById(R.id.updateLocality);
        DriverEmail=findViewById(R.id.updateEmail);
        source=findViewById(R.id.usorce);
        des=findViewById(R.id.udest);
        LandMark=findViewById(R.id.updateLand);
        City=findViewById(R.id.updateCity);

        load=getResources().getStringArray(R.array.Load);
        cycle=getResources().getStringArray(R.array.Cycle);
        drpbox1=findViewById(R.id.updateautoCompleteTextView);
        drpbox2=findViewById(R.id.updateautoCompleteTextView2);

        drpbox1.setText(binModel.getLoad());
        drpbox2.setText(binModel.getCyclicPeriod());
        Area.setText(binModel.getBinArea());
        Locality.setText(binModel.getLocality());
        DriverEmail.setText(binModel.getDriverEmail());
        source.setText(binModel.getSource());
        des.setText(binModel.getDestination());
        LandMark.setText(binModel.getLandMak());
        City.setText(binModel.getCity());


        arrayAdapter=new ArrayAdapter<String>(updateBin.this,R.layout.dropdown_item,load);
        drpbox1.setAdapter(arrayAdapter);

        arrayAdapter2=new ArrayAdapter<String>(updateBin.this,R.layout.dropdown_item,cycle);

        drpbox2.setAdapter(arrayAdapter2);
    }
    public void updateBin(View view) {
        String loadtype=drpbox1.getText().toString();
        String cyclicPeriod=drpbox2.getText().toString();
        BinModel bin= new BinModel(Area.getText().toString(),Locality.getText().toString(),LandMark.getText().toString(),City.getText().toString(),DriverEmail.getText().toString(),source.getText().toString() ,des.getText().toString(),loadtype,cyclicPeriod,binModel.getId());

        DbHelper dbHelper = new DbHelper(updateBin.this);
        boolean b = dbHelper.UpdateBin(bin);
        if (b == true)
            Toast.makeText(updateBin.this, "Bin Updated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(updateBin.this, "Bin Not Updated", Toast.LENGTH_SHORT).show();

        Intent intent=new Intent(updateBin.this,ViewBin.class);

        startActivity(intent);
    }
}