package com.example.wastemanagementsystem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class AddComplaint extends AppCompatActivity {
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    EditText title;
    EditText complaint;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_complaint);

        toolbar = findViewById(R.id.toolbaruser);
        nav = findViewById(R.id.navmenuuser);
        drawerLayout = findViewById(R.id.draweruser);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        title = findViewById(R.id.titleof);
        complaint = findViewById(R.id.complaint);

        Intent intent = getIntent();
        username = intent.getStringExtra("UserNameComplaint");
    }

    public void aDDcOMPLAINT(View view) {
        UserCompalint user = new UserCompalint(title.getText().toString(), complaint.getText().toString(), username, 1);
        // Toast.makeText(UserRegistration.this, user.toString(), Toast.LENGTH_SHORT).show();
        DbHelper dbHelper = new DbHelper(AddComplaint.this);
        boolean b = dbHelper.addComplaint(user);
        if (b == true) {
            Intent intent=new Intent(AddComplaint.this,ViewComplaint.class);
            intent.putExtra("UserNameComplaintForA",username);
            startActivity(intent);
            Toast.makeText(AddComplaint.this, "Complaint Added", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(AddComplaint.this, "Complaint Not Added", Toast.LENGTH_SHORT).show();
        }
    }

}