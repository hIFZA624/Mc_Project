package com.example.garbagemanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewBin extends AppCompatActivity {
    ListView listView;
    ArrayList<String> Area;
    ArrayList<String> Locality;
    ArrayList<String> LandMark;
    ArrayList<String> City;
    ArrayList<String> DriverEmail;
    ArrayList<String> BestRout;
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
        BestRout=new ArrayList<String>();
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
            BestRout.add(b.getBestRout());
            loadtype.add(b.getLoad());
            cyclicPeriod.add(b.getCyclicPeriod());


        }
        RefreshData();

        /*,ArrayList<String> bBestRout, ArrayList<String> bloadtype, ArrayList<String> bcyclicPeriod, ArrayList<Integer> bid)
    {*/

    }

    private void RefreshData() {
        AlertDialog.Builder builder=new AlertDialog.Builder(ViewBin.this);

        BinAdapter adapter=new BinAdapter(this,Area,Locality,LandMark,City,DriverEmail,BestRout,loadtype,cyclicPeriod,id,dbHelper,builder);
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
    }


}