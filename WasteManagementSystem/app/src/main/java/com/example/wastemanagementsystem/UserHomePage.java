package com.example.wastemanagementsystem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

public class UserHomePage extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home_page);
        toolbar = findViewById(R.id.toolbar2);
        nav = findViewById(R.id.navmenu2);
        drawerLayout = findViewById(R.id.fwareer);
        toggle=new  ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        Intent intent = getIntent();
        username = intent.getStringExtra("UserName");
    }
    public void OpenComplaint(View view) {
        Intent intent=new Intent(UserHomePage.this,AddComplaint.class);
        intent.putExtra("UserNameComplaint",username);
        startActivity(intent);
    }
    public void ComplaintsOfAUSERS(View view) {
        Intent intent=new Intent(UserHomePage.this,ViewComplaint.class);
        intent.putExtra("UserNameComplaintForA",username);
        startActivity(intent);
    }
    public void  useropen(View view) {
        Intent intent=new Intent(UserHomePage.this,UserProfile.class);
        intent.putExtra("UserNamepROFILE",username);
        startActivity(intent);
    }

}