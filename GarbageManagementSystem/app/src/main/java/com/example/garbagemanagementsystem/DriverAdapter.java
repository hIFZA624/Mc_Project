package com.example.garbagemanagementsystem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DriverAdapter  extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String> dName;
    private final ArrayList<String> dpassword;
    private final ArrayList<String> dMobile;
    private final ArrayList<String> dAdress;
    private final ArrayList<String> darea;
    private final ArrayList<String> dcnic;
    private final ArrayList<Integer> did;

    public DriverAdapter(Activity context, ArrayList<String> dName, ArrayList<String> dpassword,ArrayList<String> dMobile, ArrayList<String> dAdress, ArrayList<String> darea, ArrayList<String> dcnic ,ArrayList<Integer> did)
    {
        super(context,R.layout.listview_custom,dName);
        this.context=context;
        this.dName=dName;
        this.dpassword=dpassword;
        this.dMobile=dMobile;
        this.dAdress=dAdress;
        this.darea=darea;
        this.dcnic=dcnic;
        this.did=did;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View drivercustom=layoutInflater.inflate(R.layout.list_custom_driver,null,true);
        TextView id=drivercustom.findViewById(R.id.dId);
        TextView Name=drivercustom.findViewById(R.id.dname);
        TextView password=drivercustom.findViewById(R.id.dpwd);
        TextView Mobile=drivercustom.findViewById(R.id.dmobile);
        TextView Adress=drivercustom.findViewById(R.id.dadress);
        TextView Area=drivercustom.findViewById(R.id.dArea);
        TextView cnic=drivercustom.findViewById(R.id.dCnic);



        Name.setText(dName.get(position));
       password.setText(dpassword.get(position));
        Mobile.setText(dMobile.get(position));
       Adress.setText(dAdress.get(position));
        Area.setText(darea.get(position));
        cnic.setText(dcnic.get(position));
       id.setText(did.get(position).toString());


        return drivercustom;
    }
}
