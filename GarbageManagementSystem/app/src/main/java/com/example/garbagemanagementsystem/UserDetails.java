package com.example.garbagemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class UserDetails extends AppCompatActivity {
    ListView listView;
    MyAdapter myAdapter;
    List<User> users;
    ArrayList<String> username;
    ArrayList<String> id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        listView=findViewById(R.id.myListView);
        DbHelper dbHelper=new DbHelper(UserDetails.this);
        username=new ArrayList<String>();
        id=new ArrayList<String>();
        users=new ArrayList<>();
        users=dbHelper.getAllRecords();
        for(int i=0;i<users.size();i++)
        {
            User us=users.get(i);
            username.add(us.getFirstName());
            id.add(String.valueOf(us.getId()));
        }
        Toast.makeText(UserDetails.this,users.toString(),Toast.LENGTH_LONG).show();
        localdatainlistview();
    }
    private void localdatainlistview()
    {
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,username);
        myAdapter=new MyAdapter(this,username,id);
      //  listView.setAdapter(myAdapter);
    }
}