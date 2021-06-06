package com.example.garbagemanagementsystem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    DbHelper dbHelper;
    AlertDialog.Builder builder;

    public DriverAdapter(Activity context, ArrayList<String> dName, ArrayList<String> dpassword,ArrayList<String> dMobile, ArrayList<String> dAdress, ArrayList<String> darea, ArrayList<String> dcnic ,ArrayList<Integer> did,DbHelper dbHelper, AlertDialog.Builder builder)
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
        this.dbHelper=dbHelper;
        this.builder=builder;
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

        Button delete=drivercustom.findViewById(R.id.deletedriver);
        Button update=drivercustom.findViewById(R.id.updatedriver);

        Name.setText(dName.get(position));
       password.setText(dpassword.get(position));
        Mobile.setText(dMobile.get(position));
       Adress.setText(dAdress.get(position));
        Area.setText(darea.get(position));
        cnic.setText(dcnic.get(position));
       id.setText(did.get(position).toString());

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setCancelable(true);
                builder.setTitle("Warning");
                builder.setMessage("Are you sure you want to delete that driver");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.DeleteDriver(did.get(position));
                        notifyDataSetChanged();

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create();
                builder.show();
               // dbHelper.DeleteDriver(did.get(position));
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*DriverModel d=new DriverModel();
                d.setId(did.get(position));
                d.setName(dName.get(position));
                d.setPassword(dpassword.get(position));
                d.setMobile(dMobile.get(position));
                d.setAdress(dAdress.get(position));
                d.setArea(darea.get(position));
                d.setCNIC(dcnic.get(position));

                Boolean check=dbHelper.UpdateDriver(d);
                if(check==true)
                {
                    Toast.makeText(context, "data updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "data not updated", Toast.LENGTH_SHORT).show();
                }
*/


            }
        });
        return drivercustom;
    }
}
