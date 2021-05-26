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
<<<<<<< HEAD
    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String EMAIL_ID = "EmailId";
    public static final String PASSWORD_ID = "Password";
        public static final String User_ID = "UserId";
        public static final String User_TABLE = "UserTable";
        //DriverTable
    public static final String NAME = "Name";
    public static final String  Mobile= "Mobile";
    public static final String Adress = "Adress";
    public static final String PASSWORD = "Password";
    public static final String DriverId = "DrverId";
    public static final String CNIC = "CNIC";
    public static final String Area = "Area";
    public static final String Driver = "Driver";
    //BinTable
    public static final String BinArea = "BinArea";
    public static final String Locality = "Locality";
    public static final String  LandMark= "LandMark";
    public static final String City = "City";
    public static final String DriverEmail = "DriverEmail";
    public static final String BestRute = "BestRute";
    public static final String LoadType = "LoadType";
    public static final String CyclePeriod = "CyclePeriod";
    public static final String BinId = "BinId";
    public static final String Bin = "Bin";
=======
    public static final String TABLE_NAME = "User_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "firstname";
    public static final String COL_3 = "lastname";
    public static final String COL_4 = "email";
    public static final String COL_5 = "password";

>>>>>>> 500d381e8b8c4de700925e57d45c5813a6687bd5
    public DbHelper(@Nullable Context context) {

            super(context, "MyDB.db", null,  1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            String createTableSTatement = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " Integer PRIMARY KEY AUTOINCREMENT, " + COL_2 + " Text, " + COL_3 + " Text, " + COL_4 + " Text, " + COL_5 + " Text) ";
            db.execSQL(createTableSTatement);
            //CreateDriverTable
            String createTableSTatement2 = "CREATE TABLE " +Driver + "(" + DriverId + " Integer PRIMARY KEY AUTOINCREMENT, " + NAME + " Text, " + PASSWORD+ " Text, " + Mobile + " Text ," +Adress+"Text,"+Area+"Text,"+CNIC+"Text)";
            db.execSQL(createTableSTatement2);
            //CreateBinTable
            String createTableSTatement3 = "CREATE TABLE " +Bin + "(" + BinId + " Integer PRIMARY KEY AUTOINCREMENT, " + BinArea + " Text, " + Locality+ " Text, " + LandMark + " Text ," +City+"Text,"+DriverEmail+"Text,"+BestRute+"Text,"+LoadType+"Text,"+CyclePeriod+"Text)";
            db.execSQL(createTableSTatement3);

        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }

        public boolean addUser(User customerModel){
            SQLiteDatabase db = this.getWritableDatabase();
            //Hash map, as we did in bundles
            ContentValues cv = new ContentValues();
<<<<<<< HEAD
            cv.put(FIRST_NAME, user.getFirstName());
            cv.put(LAST_NAME,user.getLastName());
        cv.put(EMAIL_ID,user.getEmail());
        cv.put(PASSWORD_ID, user.getPassword());
        //NullCoumnHack
        long insert = db.insert(User_TABLE, null, cv);
        if (insert == -1) {return false; }
        else{return true;}




    }
    //AddDriver
    public boolean addDriver(DriverModel driver) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();
        cv.put(NAME, driver.getName());
        cv.put(PASSWORD, driver.getPassword());
        cv.put(Mobile, driver.getMobile());
        cv.put(Area, driver.getArea());
        cv.put(CNIC, driver.getCNIC());

        //NullCoumnHack
        long insert = db.insert(Driver, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
    //AddDriver
    public boolean addBin(BinModel bin) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();
        cv.put(BinArea, bin.getBinArea());
        cv.put(Locality, bin.getLocality());
        cv.put(LandMark, bin.getLandMak());
        cv.put(City, bin.getCity());
        cv.put(DriverEmail, bin.getDriverEmail());
        cv.put(BestRute, bin.getBestRout());
        cv.put(LoadType, bin.getLoad());
        cv.put(CyclePeriod, bin.getCyclicPeriod());
        //NullCoumnHack
        long insert = db.insert(Bin, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
=======
            cv.put(COL_2, customerModel.getFirstName());
            cv.put(COL_3, customerModel.getLastName());
            cv.put(COL_4, customerModel.getEmail());
            cv.put(COL_5, customerModel.getPassword());

            //NullCoumnHack
            long insert = db.insert(TABLE_NAME, null, cv);
            if (insert == -1) { return false; }
            else{return true;}
>>>>>>> 500d381e8b8c4de700925e57d45c5813a6687bd5
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
