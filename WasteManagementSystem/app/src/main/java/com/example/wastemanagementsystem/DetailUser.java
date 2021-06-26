package com.example.wastemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DetailUser extends AppCompatActivity {
    EditText firstname;
    EditText lastname;
    EditText email;
    String id;
    Button delete;
    Intent intent;
    String id2;
    String fifrstname;
    String lastnameofuser;
    String emailofuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);
        firstname=findViewById(R.id.first1);
        lastname=findViewById(R.id.Last1);
        email=findViewById(R.id.email1);
        intent=getIntent();
    firstname.setText(intent.getStringExtra("Username"));
        lastname.setText(intent.getStringExtra("last"));
        email.setText(intent.getStringExtra("email"));
        id2=intent.getStringExtra("id");
       fifrstname= intent.getStringExtra("Username");
       lastnameofuser= intent.getStringExtra("last");
       emailofuser= intent.getStringExtra("email");
    }
    public void updateuser10(View view) {

        DbHelper dbHelper = new DbHelper(DetailUser.this);
        Boolean deletedRows=dbHelper.updateUSER(firstname.getText().toString(),lastname.getText().toString(),email.getText().toString(),id2,intent.getStringExtra("password"));
        if(deletedRows==true) {
            Intent intent =new Intent(DetailUser.this,UserDetails.class);
            startActivity(intent);
            Toast.makeText(DetailUser.this, "User Updated", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(DetailUser.this,"User Not Updated",Toast.LENGTH_SHORT).show();
    }
    public void deleteUSER(View view) {
        Intent intent=getIntent();
       String firstname=intent.getStringExtra("Username");
       String lastname= intent.getStringExtra("last");
       String email=intent.getStringExtra("email");
       id=intent.getStringExtra("id");
        AlertDialog.Builder builder=new AlertDialog.Builder(DetailUser.this);
        builder.setMessage("Are you sure you want to delete");
        builder.setTitle("Alert!");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                DbHelper dbHelper = new DbHelper(DetailUser.this);
                Integer deletedRows=dbHelper.deleteUser(id);
                if(deletedRows>0)
                {
                    Intent intent1=new Intent(DetailUser.this,UserDetails.class);
                    startActivity(intent1);
                    Toast.makeText(DetailUser.this,"Data Deleted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(DetailUser.this,"Data not Deleted",Toast.LENGTH_SHORT).show();
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
}