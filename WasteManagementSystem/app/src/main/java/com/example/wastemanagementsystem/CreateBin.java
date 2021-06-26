package com.example.wastemanagementsystem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class CreateBin extends AppCompatActivity {
    String [] load;
    AutoCompleteTextView drpbox1;
    String [] cycle;
    EditText Area;
    EditText Locality;
    EditText DriverEmail;
    EditText source;
    EditText dest;
    EditText LandMark;
    EditText City;
    AutoCompleteTextView drpbox2;
    TextInputLayout text;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapter2;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bin);

        //Toolbar
        toolbar = findViewById(R.id.toolbaraddbin);
        nav = findViewById(R.id.navmenuaddbin);
        drawerLayout = findViewById(R.id.drwaeraddbin);
        toggle=new  ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //eND nAV BAR
        Area=findViewById(R.id.BinArea);
        Locality=findViewById(R.id.Locality);
        DriverEmail=findViewById(R.id.Email);
        source=findViewById(R.id.sorce);
        dest=findViewById(R.id.dest);
        LandMark=findViewById(R.id.Land);
        City=findViewById(R.id.City);
        load=getResources().getStringArray(R.array.Load);
        cycle=getResources().getStringArray(R.array.Cycle);
        drpbox1=findViewById(R.id.autoCompleteTextView);
        drpbox2=findViewById(R.id.autoCompleteTextView2);
        arrayAdapter=new ArrayAdapter<String>(CreateBin.this,R.layout.dropdown_item,load);
        drpbox1.setAdapter(arrayAdapter);
        arrayAdapter2=new ArrayAdapter<String>(CreateBin.this,R.layout.dropdown_item,cycle);
        drpbox2.setAdapter(arrayAdapter2);
    }
    public void AddBin(View view) {
        if(Area.getText().toString().trim().length()==0)
        {
          Area.setError("Enter First Name");
        }
        if(Locality.getText().toString().trim().length()==0)
        {
            Locality.setError("Enter First Name");
        }
        if(DriverEmail.getText().toString().trim().length()==0)
        {
            DriverEmail.setError("Enter First Name");
        }
        if(source.getText().toString().trim().length()==0)
        {
           source.setError("Enter First Name");
        }
        if(dest.getText().toString().trim().length()==0)
        {
            dest.setError("Enter First Name");
        }
        if(LandMark.getText().toString().trim().length()==0)
        {
            LandMark.setError("Enter First Name");
        }
        if(City.getText().toString().trim().length()==0)
        {
            City.setError("Enter First Name");
        }

        if((Area.getText().toString().trim().length()!=0) && (Locality.getText().toString().trim().length()!=0) && (DriverEmail.getText().toString().trim().length()!=0) && (source.getText().toString().trim().length()!=0) && (dest.getText().toString().trim().length()!=0) && (LandMark.getText().toString().trim().length()!=0) && (drpbox1.getText().toString().trim().length()!=0) )
        {
            DbHelper dbHelper = new DbHelper(CreateBin.this);
            ArrayList<BinModel> bindata = dbHelper.getRecordsofBin();
            boolean flag=false;
            for(int i=0;i<bindata.size();i++) {
                BinModel user = bindata.get(i);
                if (user.getDriverEmail().equals(DriverEmail.getText().toString())) {
                    flag=true;
                }
            }
            if(flag==true) {
                AlertDialog.Builder builder=new AlertDialog.Builder(CreateBin.this);
                builder.setMessage("This driver already assigned a bin");
                builder.setTitle("Alert");
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();
            }
            else {
                String loadtype = drpbox1.getText().toString();
                String cyclicPeriod = drpbox2.getText().toString();
                BinModel bin = new BinModel(Area.getText().toString(), Locality.getText().toString(), LandMark.getText().toString(), City.getText().toString(), DriverEmail.getText().toString(), source.getText().toString(), dest.getText().toString(), loadtype, cyclicPeriod, 1);
                boolean b = dbHelper.addBin(bin);
                if (b == true) {
                    Intent intent = new Intent(CreateBin.this, ViewBin.class);
                    startActivity(intent);
                    Toast.makeText(CreateBin.this, "Bin ADDED", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(CreateBin.this, "Bin Not ADDED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}