package com.example.garbagemanagementsystem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter {
    private final Activity context;
    private final ArrayList<String> rtitle;

    private final ArrayList<String> rdes;
    public MyAdapter(Activity context,ArrayList<String> title,ArrayList<String> rdes)
    {
       super();
        this.context=context;
        this.rtitle=title;
        this.rdes=rdes;
    }
    @NonNull
   
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View row=layoutInflater.inflate(R.layout.row,null,true);
        TextView title=row.findViewById(R.id.idofuser);
        TextView description=row.findViewById(R.id.nameofuser);
        description.setText(rtitle.get(position));
        title.setText(rdes.get(position));
        return row;
    }
}
