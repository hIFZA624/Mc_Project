package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class BestRouteAndWork extends AppCompatActivity {
BinModel binModel;
    BinModel user;
String login;
    DbHelper dbHelper;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_route_and_work);
        Intent intent = getIntent();
        login = intent.getStringExtra("Login");
        button=findViewById(R.id.buttonBRA);
        dbHelper = new DbHelper(BestRouteAndWork.this);
        ArrayList<BinModel> userlist = dbHelper.getRecordsofBin();
        boolean flag = false;
        for (int i = 0; i < userlist.size(); i++) {
       user = userlist.get(i);
            if (user.getDriverEmail().equals(login) ) {
                flag = true;
            }
        }

    }
    public void viewDriverDetail(View view) {
        Intent intent = new Intent(BestRouteAndWork.this, ViewDetail.class);
//        intent.putExtra("ViewDri",login);
        startActivity(intent);

    }
}