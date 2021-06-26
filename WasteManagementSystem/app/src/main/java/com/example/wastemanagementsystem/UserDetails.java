package com.example.wastemanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class UserDetails extends AppCompatActivity {
    ListView listView;
    MyAdapter myAdapter;
    ArrayList<User> users;
    ArrayList<String> username;
    ArrayList<String> id;
    ArrayList<String> last;
    ArrayList<String> email;
    ArrayList<String> password;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        listView=findViewById(R.id.myListView);
        DbHelper dbHelper=new DbHelper(UserDetails.this);
        toolbar = findViewById(R.id.toolbadmin);
        nav = findViewById(R.id.navmenuadmin);
        drawerLayout = findViewById(R.id.drweradmin);
        toggle=new  ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        username=new ArrayList<String>();
        id=new ArrayList<String>();
        users=new ArrayList<>();
        last=new ArrayList<String>();
        email=new ArrayList<String>();
        password=new ArrayList<String>();
        users=dbHelper.getAllRecords();
        for(int i=0;i<users.size();i++)
         {
            User us=users.get(i);
            username.add(us.getFirstName());
            last.add(us.getLastName());
            email.add(us.getEmail());
            id.add(String.valueOf(us.getId()));
            password.add(us.getPassword());
         }
        localdatainlistview();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id1) {
                Intent intent=new Intent(UserDetails.this,DetailUser.class);
                intent.putExtra("Username",username.get(i));
                intent.putExtra("id",id.get(i));
                intent.putExtra("last",last.get(i));
                intent.putExtra("email",email.get(i));
                intent.putExtra("password",password.get(i));
                startActivity(intent);
            }
        });
        arrayAdapter.notifyDataSetChanged();
    }
    private void localdatainlistview()
    {
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,username);
        myAdapter=new MyAdapter(this,username,id,last,email);
        listView.setAdapter(myAdapter);
    }
}