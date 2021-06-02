package com.example.garbagemanagementsystem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViewComplaints extends AppCompatActivity {
    ListView listView;

    ArrayList<String> username;
    ArrayList<String> complaint;
    ArrayList<String> title;
    DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaints);
        listView=findViewById(R.id.myListViewversion2);
        DbHelper dbHelper=new DbHelper(ViewComplaints.this);
        username=new ArrayList<String>();
        title=new ArrayList<String>();
        complaint=new ArrayList<String>();

        ArrayList<UserComplaint> users=dbHelper.getAllRecordsofComplaint();
        for(int i=0;i<users.size();i++) {

            UserComplaint us=users.get(i);
            Toast.makeText(ViewComplaints.this,us.toString(),Toast.LENGTH_SHORT).show();
            username.add(us.getUsercomplaint());
            title.add(us.getTitle());
            complaint.add(us.getComplaint());
        }
        MyArrayAdapter  Adapter=new MyArrayAdapter(ViewComplaints.this,title,username,complaint);
        listView.setAdapter(Adapter);
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