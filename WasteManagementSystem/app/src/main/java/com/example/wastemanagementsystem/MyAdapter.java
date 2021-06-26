package com.example.wastemanagementsystem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<String>
{
    private final Activity context;
    private final ArrayList<String> rtitle;

    private final ArrayList<String> rdes;
    private final ArrayList<String> rlast;
    private final ArrayList<String> remail;
    public MyAdapter(Activity context,ArrayList<String> title,ArrayList<String> rdes,ArrayList<String> last,ArrayList<String> email)
    {
        super(context,R.layout.row,title);
        this.context=context;
        this.rtitle=title;
        this.rdes=rdes;
        this.rlast=last;
        this.remail=email;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View row=layoutInflater.inflate(R.layout.row,null,true);

        TextView title=row.findViewById(R.id.idofuser);
        TextView description=row.findViewById(R.id.nameofuser);
        TextView last=row.findViewById(R.id.lastnameofuser10);
        TextView email=row.findViewById(R.id.Emailofuser10);

        description.setText(rtitle.get(position));
        title.setText(rdes.get(position));
        last.setText(rlast.get(position));
        email.setText(remail.get(position));
        if(position%2==0) {
            row.setBackgroundColor(title.getResources().getColor(R.color.colornav));
        }
        else
            row.setBackgroundColor(title.getResources().getColor(R.color.white));
        return row;
    }
}
