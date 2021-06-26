package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsComplaint extends AppCompatActivity {
    String identity;
    String username;
    EditText head;
    EditText complaintView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_complaint);
        Intent intent=getIntent();
        username=intent.getStringExtra("UserName");
        String title=intent.getStringExtra("Title");
        String complaint=intent.getStringExtra("Complaint");
        identity=intent.getStringExtra("id");
        head=findViewById(R.id.heading);
        TextView user=findViewById(R.id.subheading);
        complaintView=findViewById(R.id.usercomplaint);
        user.setText(username);
        head.setText(title);
       complaintView.setText(complaint);
    }
    public void  deleteComplaint(View view) {
        DbHelper dbHelper = new DbHelper(DetailsComplaint.this);

        AlertDialog.Builder builder=new AlertDialog.Builder(DetailsComplaint.this);
        builder.setMessage("Are you sure you want to delete");
        builder.setTitle("Alert!");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Integer deletedRows=dbHelper.deleteComplaint(identity);
                if(deletedRows>0)
                {
                    Intent intent1=new Intent(DetailsComplaint.this,ViewComplaint.class);
                    intent1.putExtra("UserNameComplaintForA",username);
                    startActivity(intent1);
                    Toast.makeText(DetailsComplaint.this,"Data Deleted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(DetailsComplaint.this,"Data not Deleted",Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

            }
    public void  updateComplaint(View view) {
        DbHelper dbHelper = new DbHelper(DetailsComplaint.this);
        Boolean deletedRows=dbHelper.updatecomplaint(identity,head.getText().toString(),complaintView.getText().toString());
        if(deletedRows==true) {
            Intent intent=new Intent(DetailsComplaint.this,ViewComplaint.class);
            intent.putExtra("UserNameComplaintForA",username);
            startActivity(intent);
            Toast.makeText(DetailsComplaint.this, "Complaint Updated", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(DetailsComplaint.this,"Complaint not updated",Toast.LENGTH_SHORT).show();
    }

}