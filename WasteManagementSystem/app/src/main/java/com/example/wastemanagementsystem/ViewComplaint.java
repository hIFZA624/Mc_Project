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

public class ViewComplaint extends AppCompatActivity {
    ListView listView;

    ArrayList<String> username;
    ArrayList<String> complaint;
    ArrayList<String> title;
    ArrayList<String> identity;
    DbHelper dbHelper;
    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    String usernameS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaint);

        Intent intent = getIntent();
        usernameS = intent.getStringExtra("UserNameComplaintForA");
        listView=findViewById(R.id.myListViewUserComplaint);
        DbHelper dbHelper=new DbHelper(ViewComplaint.this);
        username=new ArrayList<String>();
        title=new ArrayList<String>();
        complaint=new ArrayList<String>();
        identity=new ArrayList<String>();
        toolbar = findViewById(R.id.toolbarcomplaintuSER);
        nav = findViewById(R.id.navmenucomplaintuSER);
        drawerLayout = findViewById(R.id.drawerForaSPECIFC);
        toggle=new  ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        ArrayList<UserCompalint> users=dbHelper.getAllRecordsofComplaint();
        for(int i=0;i<users.size();i++) {

            UserCompalint us=users.get(i);
            if(usernameS.equals(us.getUsercomplaint().toString()))
            {
                Toast.makeText(ViewComplaint.this, us.toString(), Toast.LENGTH_SHORT).show();
                username.add(us.getUsercomplaint());
                title.add(us.getTitle());
                complaint.add(us.getComplaint());
                identity.add(String.valueOf(us.getId()));
            }
        }
        MyArrayAdapter Adapter=new MyArrayAdapter(ViewComplaint.this,title,username,complaint);
        listView.setAdapter(Adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent=new Intent(ViewComplaint.this,DetailsComplaint.class);
                intent.putExtra("UserName",username.get(i));
                intent.putExtra("Title",title.get(i));
                intent.putExtra("Complaint",complaint.get(i));
                intent.putExtra("id",identity.get(i));
                startActivity(intent);
            }
        });
    }
    public class MyArrayAdapter extends ArrayAdapter<String>
    {
        private final Activity context;
        private final ArrayList<String> rtitle;
        private final  ArrayList<String> subtitle;
        private final  ArrayList<String> rDescription;
        public MyArrayAdapter(Activity context, ArrayList<String> title, ArrayList<String> Subtitle, ArrayList<String> description)
        {
            super(context,R.layout.row,title);
            this.context=context;
            this.rtitle=title;
            this.subtitle=Subtitle;
            this.rDescription=description;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            View row=layoutInflater.inflate(R.layout.row2,null,true);
            TextView title=row.findViewById(R.id.title);
            TextView description=row.findViewById(R.id.description);
            TextView Subtitle=row.findViewById(R.id.subtitle);
            title.setText(rtitle.get(position));
            description.setText(rDescription.get(position));
            Subtitle.setText(subtitle.get(position));
            return row;
        }
    }
}