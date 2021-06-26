package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class postWork extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String text;
    BinModel binModel;
    TextView driverEmail,binId,area;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_work);
        spinner=findViewById(R.id.spinner);
        driverEmail=findViewById(R.id.driverEmail);
        binId=findViewById(R.id.binId);
        area=findViewById(R.id.area);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Status, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        binModel= (BinModel) getIntent().getSerializableExtra("postWork");
        driverEmail.setText(binModel.getDriverEmail());
        binId.setText(binModel.getId());
        area.setText(binModel.getBinArea());
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
       // String text=parent.getItemAtPosition(1).toString();
    }
    public void SubmitWorkAndBackToViewDetail(View view) {
        Intent intent = new Intent(this, ViewDetail.class);
        dbHelper=new DbHelper(postWork.this);
        intent.putExtra("submit",binModel);

        boolean b = dbHelper.UpdateStatus(binModel.getDriverEmail(),text);
        if (b == true)
            Toast.makeText(postWork.this, "Bin Updated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(postWork.this, "Bin Not Updated", Toast.LENGTH_SHORT).show();
        startActivity(intent);

    }
}