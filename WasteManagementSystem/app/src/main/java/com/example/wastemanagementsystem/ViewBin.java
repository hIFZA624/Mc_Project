package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewBin extends AppCompatActivity {
    ListView listView;
    ArrayList<String> Area;
    ArrayList<String> Locality;
    ArrayList<String> LandMark;
    ArrayList<String> City;
    ArrayList<String> DriverEmail;
    ArrayList<String> source;
    ArrayList<String> destin;
    ArrayList<String> loadtype;
    ArrayList<String> cyclicPeriod;
    ArrayList<Integer> id;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_bin);
        listView=findViewById(R.id.listviewbin);
        dbHelper=new DbHelper(ViewBin.this);
        Area=new ArrayList<String>();
        Locality=new ArrayList<String>();
        LandMark=new ArrayList<String>();
        City=new ArrayList<String>();
        DriverEmail=new ArrayList<String>();
        source=new ArrayList<String>();
        destin=new ArrayList<String>();
        loadtype=new ArrayList<String>();
        cyclicPeriod=new ArrayList<String>();
        id=new ArrayList<Integer>();
        ArrayList<BinModel> bin=dbHelper.getRecordsofBin();
        for(int i=0;i<bin.size();i++) {

            BinModel b=bin.get(i);
            Toast.makeText(ViewBin.this,b.toString(),Toast.LENGTH_SHORT).show();
            id.add((b.getId()));
            Area.add(b.getBinArea());
            Locality.add(b.getLocality());
            LandMark.add(b.getLocality());
            City.add(b.getCity());
            DriverEmail.add(b.getDriverEmail());
            source.add(b.getSource());
            destin.add(b.getDestination());
            loadtype.add(b.getLoad());
            cyclicPeriod.add(b.getCyclicPeriod());
        }
        RefreshData();
    }
    private void RefreshData() {
        AlertDialog.Builder builder=new AlertDialog.Builder(ViewBin.this);
        BinAdapter adapter=new BinAdapter(this,Area,Locality,LandMark,City,DriverEmail,source,destin,loadtype,cyclicPeriod,id,dbHelper,builder);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}