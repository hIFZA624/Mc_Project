package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewDetail extends AppCompatActivity {
    BinModel binModel;

    String login;
    DbHelper dbHelper;
    TextView binid;
    TextView binarea;
    TextView locality;
    TextView city;
    TextView source;
    TextView destination;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);

        Intent intent = getIntent();
        login = intent.getStringExtra("ViewDriver");
        Log.d("text",login);

        DbHelper dbHelper=new DbHelper(ViewDetail.this);
        ArrayList<BinModel> driverlist=dbHelper.getRecordsofBin();
        //text get
        binid=findViewById(R.id.binidofbin);
        binarea=findViewById(R.id.areaofbin);
        locality=findViewById(R.id.localityofbin);
        city=findViewById(R.id.cityofbin);
        source=findViewById(R.id.sourceofbin);
        destination=findViewById(R.id.destinationofbin);
        boolean flag=false;
    /*for(int i=0;i<driverlist.size();i++) {

            BinModel bin = driverlist.get(i);
            if (bin.getDriverEmail().equals(login)) {
                Log.d("inloop",login);
                Log.d("inloopfter",login);
                break;
            }
        }*/
        BinModel binModel=dbHelper.searchDriver(login);
       Log.d("BinModel",binModel.getBinArea());
       Integer number=binModel.getId();
       binid.setText(number.toString());
       binarea.setText(binModel.getBinArea());
       locality.setText(binModel.getLocality());
       city.setText(binModel.getCity());
       source.setText(binModel.getSource());
       destination.setText(binModel.getDestination());
    }
    public void postwork(View view) {
        Intent intent = new Intent(this, postWork.class);
        intent.putExtra("postWork",login);
        startActivity(intent);
    }
}