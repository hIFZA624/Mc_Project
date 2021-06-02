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
        //DriverTable
    public static final String NAME = "Name";
    public static final String  MOBILE= "Mobile";
    public static final String ADRESS = "Adress";
    public static final String PASSWORD = "Password";
    public static final String DRIVER_ID = "DrverId";
    public static final String CNIC = "CNIC";
    public static final String AREA = "Area";
    public static final String DRIVER = "Driver";
    //BinTable
    public static final String BIN_AREA = "BinArea";
    public static final String LOCALITY = "Locality";
    public static final String  LANDMARK= "LandMark";
    public static final String CITY = "City";
    public static final String DRIVER_EMAIL = "DriverEmail";
    public static final String BEST_ROUT = "BestRute";
    public static final String LOAD_TYPE = "LoadType";
    public static final String CYCLIC_PERIOD = "CyclePeriod";
    public static final String BIN_ID = "BinId";
    public static final String BIN = "Bin";

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
            //CreateDriverTable
            String createTableSTatement2 = "CREATE TABLE " +DRIVER + "(" + DRIVER_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + NAME + " Text, " + PASSWORD+ " Text, " + MOBILE + " Text ," + ADRESS + "Text," + AREA + "Text," + CNIC + "Text)";
            db.execSQL(createTableSTatement2);
            //CreateBinTable
            String createTableSTatement3 = "CREATE TABLE " +BIN + "(" + BIN_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + BIN_AREA + " Text, " + LOCALITY + " Text, " + LANDMARK + " Text ," + CITY + "Text," + DRIVER_EMAIL + "Text," + BEST_ROUT + "Text," + LOAD_TYPE + "Text," + CYCLIC_PERIOD + "Text)";
            db.execSQL(createTableSTatement3);


        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //DROP EXISTING Table
            db.execSQL("DROP TABLE IF EXISTS "+DRIVER);
            db.execSQL("DROP TABLE IF EXISTS "+BIN);
            onCreate(db);

        }

        public boolean addUser(User customerModel){
            SQLiteDatabase db = this.getWritableDatabase();
            //Hash map, as we did in bundles
            ContentValues cv = new ContentValues();

            //cv.put(FIRST_NAME, user.getFirstName());
          //  cv.put(LAST_NAME,user.getLastName());
      //  cv.put(EMAIL_ID,user.getEmail());
       // cv.put(PASSWORD_ID, user.getPassword());
        //NullCoumnHack
        long insert = db.insert(User_TABLE, null, cv);
        if (insert == -1) {return false; }
        else{return true;}





    }
    //AddDriver
    public boolean addDriver( DriverModel driver) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();
        cv.put(NAME, driver.getName());
        cv.put(PASSWORD, driver.getPassword());
        cv.put(MOBILE, driver.getMobile());
        cv.put(ADRESS,driver.getAdress());
        cv.put(AREA, driver.getArea());
        cv.put(CNIC, driver.getCNIC());

        //NullCoumnHack
        long insert = db.insert(DRIVER, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }
    //Add Bin
    public boolean addBin(BinModel bin) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();
        cv.put(BIN_AREA, bin.getBinArea());
        cv.put(LOCALITY, bin.getLocality());
        cv.put(LANDMARK, bin.getLandMak());
        cv.put(CITY, bin.getCity());
        cv.put(DRIVER_EMAIL, bin.getDriverEmail());
        cv.put(BEST_ROUT, bin.getBestRout());
        cv.put(LOAD_TYPE, bin.getLoad());
        cv.put(CYCLIC_PERIOD, bin.getCyclicPeriod());
        //NullCoumnHack
        long insert = db.insert(BIN, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }

        //cv.put(COL_2, customerModel.getFirstName());
          //  cv.put(COL_3, customerModel.getLastName());
           // cv.put(COL_4, customerModel.getEmail());
           // cv.put(COL_5, customerModel.getPassword());

            //NullCoumnHack
          //  long insert = db.insert(TABLE_NAME, null, cv);
         //   if (insert == -1) { return false; }
          //  else{return true;}

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
    //Update bin data
    public boolean UpdateBin(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        //NullCoumnHack
        Cursor  cursor=db.rawQuery("Select * from Bin where BinId = ?",new String[]{String.valueOf(id)});
        cv.put(BIN_AREA, cursor.getString(1));
        cv.put(LOCALITY, cursor.getString(2));
        cv.put(LANDMARK, cursor.getString(3));
        cv.put(CITY,cursor.getString(4));
        cv.put(DRIVER_EMAIL, cursor.getString(5));
        cv.put(BEST_ROUT,cursor.getString(6));
        cv.put(LOAD_TYPE, cursor.getString(7));
        cv.put(CYCLIC_PERIOD,cursor.getString(8));
        //NullCoumnHack
        if(cursor.getCount()>0) {
            long update = db.update(BIN, cv, "BinId=?", new String[]{String.valueOf(id)});
            if (update == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
            return false;
    }
    //UPdate Driver
    public boolean UpdateDriver(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        Cursor  cursor=db.rawQuery("Select * from Driver where DrverId = ?",new String[]{String.valueOf(id)});
        cv.put(NAME,  cursor.getString(1));
        cv.put(PASSWORD,  cursor.getString(2));
        cv.put(MOBILE,  cursor.getString(3));
        cv.put(ADRESS,cursor.getString(4));
        cv.put(AREA,cursor.getString(5) );
        cv.put(CNIC,cursor.getString(6));
        //NullCoumnHack
        if(cursor.getCount()>0) {
            long update = db.update(DRIVER, cv, "DrverId=?", new String[]{String.valueOf(id)});
            if (update == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
            return false;
    }
    //Delete Driver
    public boolean DeleteDriver(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles

        Cursor  cursor=db.rawQuery("Select * from Driver where DrverId = ?",new String[]{String.valueOf(id)});

        //NullCoumnHack
        if(cursor.getCount()>0) {
            long update = db.delete(DRIVER, "DrverId=?", new String[]{String.valueOf(id)});
            if (update == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
            return false;
    }
    //Delete bin
    public boolean DeleteBin(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles


        //NullCoumnHack
        Cursor  cursor=db.rawQuery("Select * from Bin where BinId = ?",new String[]{String.valueOf(id)});

        //NullCoumnHack
        if(cursor.getCount()>0) {
            long update = db.delete(BIN,  "BinId=?", new String[]{String.valueOf(id)});
            if (update == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
            return false;
    }
    //get bin data
    public Cursor getBinData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor  cursor=db.rawQuery("Select * from Bin",null);

        return cursor;
    }
    //get driver data
    public Cursor getDriverData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor  cursor=db.rawQuery("Select * from Driver",null);

        return cursor;
    }

}
