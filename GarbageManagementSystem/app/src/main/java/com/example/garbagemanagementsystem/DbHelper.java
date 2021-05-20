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
    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String EMAIL_ID = "EmailId";
    public static final String PASSWORD_ID = "Password";
        public static final String User_ID = "UserId";
        public static final String User_TABLE = "UserTable";
    public DbHelper(@Nullable Context context) {
            super(context, "GarbageManagementSystem.db", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTableSTatement = "CREATE TABLE " + User_TABLE + "(" + User_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + FIRST_NAME + " Text, " + LAST_NAME + " Text, " + EMAIL_ID + " Text ," +PASSWORD_ID+"Text)";
            db.execSQL(createTableSTatement);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
        public boolean addUser(User user){
            SQLiteDatabase db = this.getWritableDatabase();
            //Hash map, as we did in bundles
            ContentValues cv = new ContentValues();
            cv.put(FIRST_NAME, user.getFirstName());
            cv.put(LAST_NAME,user.getLastName());
        cv.put(EMAIL_ID,user.getEmail());
        cv.put(PASSWORD_ID, user.getPassword());
        //NullCoumnHack
        long insert = db.insert(User_TABLE, null, cv);
        if (insert == -1) {return false; }
        else{return true;}
    }
    public List<User> getAllRecords(){
        List<User> myList=new ArrayList<>();
        String query="SELECT * FROM "+User_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                int id=cursor.getInt(0);
                String firstname=cursor.getString(1);
                String lastname=cursor.getString(2);
                String email=cursor.getString(3);
                String password=cursor.getString(4);

                User user=new User(firstname,lastname,email,password,password,id);
                myList.add(user);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return  myList;
    }
}
