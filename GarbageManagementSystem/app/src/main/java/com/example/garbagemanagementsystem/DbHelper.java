package com.example.garbagemanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "User_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "firstname";
    public static final String COL_3 = "lastname";
    public static final String COL_4 = "email";
    public static final String COL_5 = "password";

    public DbHelper(@Nullable Context context) {

            super(context, "MyDB.db", null,  1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTableSTatement = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " Integer PRIMARY KEY AUTOINCREMENT, " + COL_2 + " Text, " + COL_3 + " Text, " + COL_4 + " Text, " + COL_5 + " Text) ";
            db.execSQL(createTableSTatement);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public boolean addUser(User customerModel){
            SQLiteDatabase db = this.getWritableDatabase();
            //Hash map, as we did in bundles
            ContentValues cv = new ContentValues();
            cv.put(COL_2, customerModel.getFirstName());
            cv.put(COL_3, customerModel.getLastName());
            cv.put(COL_4, customerModel.getEmail());
            cv.put(COL_5, customerModel.getPassword());

            //NullCoumnHack
            long insert = db.insert(TABLE_NAME, null, cv);
            if (insert == -1) { return false; }
            else{return true;}
    }
    public List<User> getAllRecords(){
        List<User> myList=new ArrayList<>();
        String query="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                int id=cursor.getInt(0);
                String custname=cursor.getString(1);
                String LastName=cursor.getString(2);
                String Email=cursor.getString(3);
                String Password=cursor.getString(4);
                User customerModel=new User(custname,LastName,Email,Password,Password,id);
                myList.add(customerModel);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return  myList;
    }
}
