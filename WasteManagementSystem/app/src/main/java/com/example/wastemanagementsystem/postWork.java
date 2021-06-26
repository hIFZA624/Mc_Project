package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class postWork extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String text;
    BinModel binModel;
    TextView driverEmail, binId, area;
    DbHelper dbHelper;
    String login;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_work);
        spinner=findViewById(R.id.spinnerofview);
        driverEmail=findViewById(R.id.driverEmailPage);
        binId=findViewById(R.id.binIdPage);

        DbHelper dbHelper=new DbHelper(postWork.this);
        area=findViewById(R.id.areaPage);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        Intent intent = getIntent();
        login = intent.getStringExtra("postWork");
        BinModel binModel=dbHelper.searchDriver(login);
        Log.d("BinModel",binModel.getBinArea());
        Log.d("BinModel",binModel.getDriverEmail());
        Log.d("BinModel",String.valueOf(binModel.getId()));
        //Log.d("BinModel",binModel.getId());
        //Log.d("binModel",binModel.getDriverEmail());
        //Log.d("binModel",binModel.getBinArea());
        Integer number=binModel.getId();
        driverEmail.setText(binModel.getDriverEmail());
        binId.setText(number.toString());
        area.setText(binModel.getBinArea());
        email=binModel.getDriverEmail();
}
    public void SubmitWorkAndBackToViewDetail(View view) {
        dbHelper=new DbHelper(postWork.this);
        Log.d("texthifza",text);
        Log.d("texthifza",email);
      boolean b = dbHelper.UpdateStatus(email,text);
        if (b == true) {
           /* Toast.makeText(postWork.this, "Bin Updated", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ViewDetail.class);
            intent.putExtra("submit",binModel);*/
            //startActivity(intent);
            Toast.makeText(postWork.this, "Bin Updated", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(postWork.this, "Bin Not Updated", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}