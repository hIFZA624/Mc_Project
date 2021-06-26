package com.example.wastemanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
//bin
public static final String TABLE_NAMEBIN = "Bin_table";
public static final String BIN_AREA = "BinArea";
    public static final String LOCALITY = "Locality";
    public static final String  LANDMARK= "LandMark";
    public static final String CITY = "City";
    public static final String DRIVER_EMAIL = "DriverEmail";
    public static final String SOURCE = "Source";
    public static final String DESTINATION = "Destination";
    public static final String LOAD_TYPE = "LoadType";
    public static final String CYCLIC_PERIOD = "CyclePeriod";
    public static final String BIN_ID = "BinId";
    public static final String BIN = "Bin";
    //Table 2
    public static final String TABLE_NAMES = "Complaint_Table";
    public static final String COL_11 = "ID";
    public static final String COL_12 = "Title";
    public static final String COL_13 = "Complaint";
    public static final String COL_14 = "CompalintName";
//dRIVER TABLE
public static final String NAME = "Name";
    public static final String  MOBILE= "Mobile";
    public static final String ADRESS = "Adress";
    public static final String D_EMAIL = "DriverMail";
    public static final String STATUS = "Status";
    public static final String PASSWORD = "Password";
    public static final String DRIVER_ID = "DrverId";
    public static final String CNIC = "CNIC";
    public static final String AREA = "Area";
    public static final String DRIVER = "Driver";
    public DbHelper(@Nullable Context context ) {
        super(context, "MyDB.db", null,  4);
    }
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " Integer PRIMARY KEY AUTOINCREMENT, " + COL_2 + " Text, " + COL_3 + " Text, " + COL_4 + " Text, " + COL_5 + " Text) ";
        String createTableSTatement2 = "CREATE TABLE " + TABLE_NAMES + "(" + COL_11 + " Integer PRIMARY KEY AUTOINCREMENT, " + COL_12 + " Text, " + COL_13 + " Text, " + COL_14 + " Text) ";
        db.execSQL(createTableSTatement);
        db.execSQL(createTableSTatement2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
switch (newVersion) {
    case 2:
        String createTableSTatement2 = "CREATE TABLE " + TABLE_NAMES + "(" + COL_11 + " Integer PRIMARY KEY AUTOINCREMENT, " + COL_12 + " Text, " + COL_13 + " Text, " + COL_14 + " Text) ";
        db.execSQL(createTableSTatement2);
        break;
    case 3:
        String createTableSTatement3 = "CREATE TABLE " +BIN + "(" + BIN_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + BIN_AREA + " Text, " + LOCALITY + " Text, " + LANDMARK + " Text ," + CITY + " Text ," + DRIVER_EMAIL + " Text ," + SOURCE + " Text ," + DESTINATION + " Text ," + LOAD_TYPE + " Text ," + CYCLIC_PERIOD + " Text)";
        db.execSQL(createTableSTatement3);
        break;
    case 4:
        String createTableSTatement1 = "CREATE TABLE " +DRIVER + "(" + DRIVER_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + NAME + " Text, " + PASSWORD+ " Text, " + MOBILE + " Text ," + ADRESS + " Text, " + AREA + " Text, " + CNIC + " Text, " + D_EMAIL + " Text, " + STATUS + " Text)";
        db.execSQL(createTableSTatement1);
        break;
}


    }
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
        cv.put(D_EMAIL, driver.getEMAIL());
        cv.put(STATUS,driver.getStatus());

        //NullCoumnHack
        long insert = db.insert(DRIVER, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
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
    public ArrayList<User> getAllRecords(){
        ArrayList<User> myList=new ArrayList<User>();
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
    public boolean addComplaint(UserCompalint usermodel){
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();
        cv.put(COL_12, usermodel.getTitle());
        cv.put(COL_13, usermodel.getComplaint());
        cv.put(COL_14, usermodel.getUsercomplaint());


        //NullCoumnHack
        long insert = db.insert(TABLE_NAMES, null, cv);
        if (insert == -1) { return false; }
        else{return true;}
    }
    public ArrayList<UserCompalint> getAllRecordsofComplaint(){
        ArrayList<UserCompalint> myList=new ArrayList<UserCompalint>();
        String query="SELECT * FROM "+TABLE_NAMES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                int id=cursor.getInt(0);
                String title=cursor.getString(1);
                String complaints=cursor.getString(2);
                String username=cursor.getString(3);

                UserCompalint complaint=new UserCompalint(title,complaints,username,id);
                myList.add(complaint);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return  myList;
    }
    public Integer deleteUser(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID=?",new String[] {id});
    }
    public Integer  deleteComplaint(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAMES,"ID=?",new String[] {id});
    }
public boolean updateUSER(String first,String last,String email,String id,String pass)
{
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();
    Log.d("helo",first);
    Log.d("helo",last);
    Log.d("helo",email);
    Log.d("helo",pass);
    Log.d("helo",id);
    cv.put(COL_2,first);
    cv.put(COL_3, last);
    cv.put(COL_4, email);
    cv.put(COL_5, pass);
        int delete =db.update(TABLE_NAME,cv,"ID=?",new String[] {id});
        if (delete == -1) {
            return false;
        } else {
            return true;
        }
}
    public boolean updatecomplaint(String id,String heading,String description)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_12, heading);
        cv.put(COL_13, description);

        int delete =db.update(TABLE_NAMES,cv,"ID=?",new String[] {id});
        if (delete == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean addBin(BinModel bin) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();
        cv.put(BIN_AREA, bin.getBinArea());
        cv.put(LOCALITY, bin.getLocality());
        cv.put(LANDMARK, bin.getLandMak());
        cv.put(CITY, bin.getCity());
        cv.put(DRIVER_EMAIL, bin.getDriverEmail());
        cv.put(SOURCE, bin.getSource());
        cv.put(DESTINATION, bin.getDestination());
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
    public BinModel searchDriver(String Login) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        //  ContentValues cv = new ContentValues();

        Cursor cursor = db.rawQuery("Select * from BIN where  DriverEmail= ?", new String[]{String.valueOf(Login)});
        BinModel driver=new BinModel();
        if(cursor.moveToFirst())
        {
            do{
                int id=cursor.getInt(0);
                String Area=cursor.getString(1);
                String Locality=cursor.getString(2);
                String LandMark=cursor.getString(3);
                String City=cursor.getString(4);
                String DriverEmail=cursor.getString(5);
                String source=cursor.getString(6);
                String destin=cursor.getString(7);
                String loadtype=cursor.getString(8);
                String cyclicPeriod=cursor.getString(9);

                driver= new BinModel(Area,Locality,LandMark,City,DriverEmail,source,destin,loadtype,cyclicPeriod,id);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return  driver;
    }
    //UPdate Status
    public boolean UpdateStatus(String email,String status) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();
        cv.put(D_EMAIL, email);
        cv.put(STATUS, status);
        //NullCoumnHack
            long update = db.update(DRIVER, cv, "DriverMail=?", new String[]{String.valueOf(email)});
            if (update == -1) {
                return false;
            } else {
                return true;
            }
    }
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
    public ArrayList<BinModel> getRecordsofBin(){
        ArrayList<BinModel> binList=new ArrayList<BinModel>();
        String query="SELECT * FROM "+BIN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                int id=cursor.getInt(0);
                String Area=cursor.getString(1);
                String Locality=cursor.getString(2);
                String LandMark=cursor.getString(3);
                String City=cursor.getString(4);
                String DriverEmail=cursor.getString(5);
                String source=cursor.getString(6);
                String destin=cursor.getString(7);
                String loadtype=cursor.getString(8);
                String cyclicPeriod=cursor.getString(9);

                BinModel bin= new BinModel(Area,Locality,LandMark,City,DriverEmail,source,destin,loadtype,cyclicPeriod,id);

                binList.add(bin);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return  binList;
    }
    public boolean UpdateBin(BinModel bin) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        //NullCoumnHack

        cv.put(BIN_AREA, bin.getBinArea());
        cv.put(LOCALITY, bin.getLocality());
        cv.put(LANDMARK, bin.getLandMak());
        cv.put(CITY, bin.getCity());
        cv.put(DRIVER_EMAIL, bin.getDriverEmail());
        cv.put(SOURCE, bin.getSource());
        cv.put(DESTINATION, bin.getDestination());
        cv.put(LOAD_TYPE, bin.getLoad());
        cv.put(CYCLIC_PERIOD, bin.getCyclicPeriod());
        Cursor  cursor=db.rawQuery("Select * from Bin where BinId = ?",new String[]{String.valueOf(bin.getId())});
        //NullCoumnHack
        if(cursor.getCount()>0) {
            long update = db.update(BIN, cv, "BinId=?", new String[]{String.valueOf(bin.getId())});
            if (update == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
            return false;
    }
    public boolean UpdateDriver(DriverModel driver) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        Cursor  cursor=db.rawQuery("Select * from Driver where DrverId = ?",new String[]{String.valueOf(driver.getId())});
        cv.put(NAME, driver.getName());
        cv.put(PASSWORD, driver.getPassword());
        cv.put(MOBILE, driver.getMobile());
        cv.put(ADRESS,driver.getAdress());
        cv.put(AREA, driver.getArea());
        cv.put(CNIC, driver.getCNIC());
        cv.put(D_EMAIL, driver.getEMAIL());
        cv.put(STATUS, driver.getStatus());
        //NullCoumnHack
        if(cursor.getCount()>0) {
            long update = db.update(DRIVER, cv, "DrverId=?", new String[]{String.valueOf(driver.getId())});
            if (update == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
            return false;
    }
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
    public ArrayList<DriverModel> getRecordsofDriver(){
        ArrayList<DriverModel> driverlist=new ArrayList<DriverModel>();
        String query="SELECT * FROM "+DRIVER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor= db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            do{
                int id=cursor.getInt(0);
                String Name=cursor.getString(1);
                String password=cursor.getString(2);
                String Mobile=cursor.getString(3);
                String Adress=cursor.getString(4);
                String Area=cursor.getString(5);
                String cnic=cursor.getString(6);
                String Email=cursor.getString(7);
                String Status=cursor.getString(8);

                DriverModel driver= new DriverModel(Name,password,Mobile,Adress, Area,cnic,id,Email,Status);

                driverlist.add(driver);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return  driverlist;
    }
    public boolean UpdateUser(User u) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        //NullCoumnHack


        cv.put(COL_2, u.getFirstName());
        cv.put(COL_3,u.getLastName());
        cv.put(COL_4,u.getEmail());
        cv.put(COL_5, u.getPassword());
        Cursor  cursor=db.rawQuery("Select * from UserTable where UserId = ?",new String[]{String.valueOf(u.getId())});

        //NullCoumnHack
        if(cursor.getCount()>0) {
            long update = db.update(TABLE_NAME, cv, "UserId=?", new String[]{String.valueOf(u.getId())});
            if (update == -1) {
                return false;
            } else {
                return true;
            }
        }
        else
            return false;
    }
}
