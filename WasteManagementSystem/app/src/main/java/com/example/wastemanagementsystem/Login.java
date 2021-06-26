package com.example.wastemanagementsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    TextView textView;
    String title;
    EditText userName;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //getting login details
        userName=findViewById(R.id.User);
        password=findViewById(R.id.Pass);

        textView=findViewById(R.id.login);
        Intent intent = getIntent();
        title = intent.getStringExtra("Heading");
        textView.setText(title.toString());
        if(userName.getText().toString().trim().length()!=0)
        {
            userName.setError(null);
        }
        if(password.getText().toString().trim().length()!=0)
        {
            password.setError(null);
        }
    }
    public void Open(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(Login.this);
        builder.setMessage("Invalid User Name and Password");
        builder.setTitle("Alert");
        builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        if(userName.getText().toString().trim().length()==0)
        {
            userName.setError("Enter Email");
        }
        if(password.getText().toString().trim().length()==0)
        {
            password.setError("Enter Email");
        }
        if(userName.getText().toString().trim().length()!=0 && password.getText().toString().trim().length()!=0) {
            if (title.equals("Admin Login")) {
                String temp1 = userName.getText().toString();
                String temp2 = password.getText().toString();
                if (userName.getText().toString().equals("Admin") && password.getText().toString().equals("Admin")) {
                    Intent intent2 = new Intent(Login.this, AdminHomePage.class);
                    startActivity(intent2);
                } else {
                  AlertDialog alertDialog=builder.create();
                  alertDialog.show();
                  Toast.makeText(Login.this, "UserName And Password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
            else if (title.equals("User Login"))
            {
                Toast.makeText(Login.this, "User Login", Toast.LENGTH_SHORT).show();
                DbHelper dbHelper=new DbHelper(Login.this);
                ArrayList<User> userlist=dbHelper.getAllRecords();
                boolean flag=false;
               for(int i=0;i<userlist.size();i++) {
                   User user = userlist.get(i);
                   if (user.getEmail().equals(userName.getText().toString()) && user.getPassword().equals(password.getText().toString())) {
                      flag=true;
                   }
               }
               if(flag==true)
               {
                   Intent intent2 = new Intent(Login.this, UserHomePage.class);
                   intent2.putExtra("UserName",userName.getText().toString());

                   startActivity(intent2);
               }
               else
               {
                   AlertDialog alertDialog=builder.create();
                   alertDialog.show();

               }
            }
            else if (title.equals("Driver Login"))
            {
                Toast.makeText(Login.this, "Driver Login Successfully", Toast.LENGTH_SHORT).show();
                DbHelper dbHelper=new DbHelper(Login.this);
                ArrayList<DriverModel> driverlist=dbHelper.getRecordsofDriver();
                boolean flag=false;
                for(int i=0;i<driverlist.size();i++) {
                    DriverModel user = driverlist.get(i);
                    if (user.getEMAIL().equals(userName.getText().toString()) && user.getPassword().equals(password.getText().toString())) {
                        flag=true;
                    }
                }
                if(flag==true)
                {
                    Intent intent2 = new Intent(Login.this, BestRouteAndActivity.class);
                    intent2.putExtra("UserName",userName.getText().toString());
                    startActivity(intent2);
                }
                else
                {
                    AlertDialog alertDialog=builder.create();
                    alertDialog.show();
                }
            }
            else {
                Toast.makeText(Login.this, "You Are not a User of this Login", Toast.LENGTH_SHORT).show();
            }
        }
      /*  Intent intent2=new Intent(Login.this,AdminHomePage.class);
        startActivity(intent2);*/
    }
}