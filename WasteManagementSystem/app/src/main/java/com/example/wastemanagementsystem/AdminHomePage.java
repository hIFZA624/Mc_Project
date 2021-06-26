package com.example.wastemanagementsystem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class AdminHomePage extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);

        toolbar = findViewById(R.id.toolbar);
        nav = findViewById(R.id.navmenu);
        drawerLayout = findViewById(R.id.drawer);
        toggle=new  ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
    public void UserDetails(View view) {
        Intent intent=new Intent(AdminHomePage.this,UserDetails.class);
        startActivity(intent);
    }

    public void ComplaintView(View view) {
      /*  Intent intent=new Intent(AdminHomePage.this,AddComplaint.class);
        startActivity(intent);*/
    }
    public void  OpenActivity(View view) {
        Intent intent=new Intent(AdminHomePage.this,ViewComplaints.class);
        startActivity(intent);
    }
    public void   CreateBin(View view) {
        Intent intent=new Intent(AdminHomePage.this,CreateBin.class);
        startActivity(intent);
    }

    public void ViewBins(View view) {
        Intent intent=new Intent(AdminHomePage.this,ViewBin.class);
        startActivity(intent);
    }
    public void createdriveropen(View view)
    {
        Intent intent=new Intent(AdminHomePage.this,CreatDriver.class);
        startActivity(intent);
    }

    public void ViewDriverdata(View view) {
        Intent intent=new Intent(AdminHomePage.this,ViewDriver.class);
        startActivity(intent);
    }
}