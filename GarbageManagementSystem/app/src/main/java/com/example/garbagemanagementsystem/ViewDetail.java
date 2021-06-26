package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewDetail extends AppCompatActivity {
    //initialization variable
    BinModel binModel;
    BinModel user;
    String login;
    DbHelper dbHelper;
    TextView et_source,et_destination,binId,area,Locality,City;
    Button btTrack,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_detail);
        //Assigning variable
        et_source=findViewById(R.id.et_Source);
        et_destination=findViewById(R.id.et_Destination);
        btTrack=findViewById(R.id.bt_track);
        binId=findViewById(R.id.DbinId);
        area=findViewById(R.id.Darea);
        Locality=findViewById(R.id.DLocality);
        City=findViewById(R.id.DCity);
        Intent intent = getIntent();
        login = intent.getStringExtra("Login");

        dbHelper = new DbHelper(ViewDetail.this);
        ArrayList<BinModel> userlist = dbHelper.getRecordsofBin();
        boolean flag = false;
        for (int i = 0; i < userlist.size(); i++) {
            user = userlist.get(i);
            if (user.getDriverEmail().equals(login) ) {
                flag = true;
            }
        }


        et_source.setText(binModel.getSource());
        et_destination.setText((binModel.getDestination()));
        area.setText(binModel.getBinArea());
        binId.setText(binModel.getId());
        Locality.setText(binModel.getLocality());
        City.setText(binModel.getCity());
        btTrack.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                //Get VALUE FROM EDIT TEXT
                String sSource=et_source.getText().toString().trim();
                String sDestination=et_destination.getText().toString().trim();

                //Check condition
                if(sSource.equals("")&& sDestination.equals(""))
                {
                    //when both values are blank
                    Toast.makeText(getApplicationContext(),
                            "Enter both location",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //when both value fi;;
                    //display track
                    DisplayTrack(sSource,sDestination);

                }
            }
        });

    }

    private void DisplayTrack(String sSource, String sDestination) {
        //if the device does not have a map installed, then redirect it to play store
        try{
            //When google map is installed
            //initialize URI
            Uri uri= Uri.parse("https://www.google.co.in/maps/dir/" + sSource +"/"
                    + sDestination);

            //initialize intent with action view
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            //Set package
            intent.setPackage("com.google.android.apps.maps");
            //set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //Start activity
            startActivity(intent);

        }catch(ActivityNotFoundException e)
        {
            //when google map is not installed
            //Initialized uri
            Uri uri=Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
            //initialize intent with action view
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            //set flag
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //START ACTIVITY
            startActivity(intent);

        }
    }
    public void postwork(View view) {
        Intent intent = new Intent(this, postWork.class);
        intent.putExtra("postWork",binModel);
        startActivity(intent);

    }
}