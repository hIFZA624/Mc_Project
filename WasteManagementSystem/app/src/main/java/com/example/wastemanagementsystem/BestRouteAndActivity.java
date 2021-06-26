package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class BestRouteAndActivity extends AppCompatActivity {
    BinModel binModel;
    BinModel user;
    String login;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_route_and);
        Intent intent = getIntent();
        login = intent.getStringExtra("UserName");
        Log.d("DRIVER",login);
       /* dbHelper = new DbHelper(BestRouteAndActivity.this);
        ArrayList<BinModel> userlist = dbHelper.getRecordsofBin();
        boolean flag = false;
        for (int i = 0; i < userlist.size(); i++) {
            user = userlist.get(i);
            if (user.getDriverEmail().equals(login) ) {
                flag = true;
            }
        }*/
    }
    public void viewDriverDetail(View view) {
        Intent intent = new Intent(BestRouteAndActivity.this, ViewDetail.class);
        intent.putExtra("ViewDriver",login);
        startActivity(intent);

    }
}