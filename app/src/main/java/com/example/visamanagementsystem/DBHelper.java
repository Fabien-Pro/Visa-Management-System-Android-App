package com.example.visamanagementsystem;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    //Database Name
    public static final String DBNAME ="vms.db"; //Database version
    private static final int DATABASE_VERSION = 1;
    //Database Table name
    private static final String TABLE_NAME = "applications";
    //Table columns
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String RES_COUNTRY = "res_country";
    public static final String DOB = "dob";
    public static final String POV = "pov";
    public static final String DOT= "dot";
    public static final String DOI = "doi";
    public static final String DOE = "doe";
    private SQLiteDatabase sqLiteDatabase;

    //creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME +"("+ID+
            " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " TEXT NOT NULL,"+EMAIL+" TEXT NOT NULL,"+RES_COUNTRY+" TEXT NOT NULL,"+DOB+" TEXT NOT NULL,"+POV+" TEXT NOT NULL,"+DOT+" TEXT NOT NULL,"+DOI+" TEXT NOT NULL,"+DOE+" TEXT NOT NULL);";
    //Constructor
    public DBHelper(Context context){
        super(context,DBNAME,null,DATABASE_VERSION);
    }


    //Add Applicants Data
    public void addApplicant(ApplicationModelClass applicationModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.NAME, applicationModelClass.getName());
        contentValues.put(DBHelper.EMAIL, applicationModelClass.getEmail());
        contentValues.put(DBHelper.RES_COUNTRY, applicationModelClass.getRes_country());
        contentValues.put(DBHelper.DOB, applicationModelClass.getDob());
        contentValues.put(DBHelper.POV, applicationModelClass.getPov());
        contentValues.put(DBHelper.DOT, applicationModelClass.getDot());
        contentValues.put(DBHelper.DOI, applicationModelClass.getDoi());
        contentValues.put(DBHelper.DOE, applicationModelClass.getDoe());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DBHelper.TABLE_NAME, null,contentValues);
    }

    public List<ApplicationModelClass> getApplicantList(){
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<ApplicationModelClass> storeApplicant = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
             int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String email = cursor.getString(2);
                String res_country= cursor.getString(3);
                String dob= cursor.getString(4);
                String pov = cursor.getString(5);
                String dot= cursor.getString(6);
                String doi= cursor.getString(7);
                String doe= cursor.getString(7);
                storeApplicant.add(new ApplicationModelClass(id,name,email,res_country,dob,pov,dot,doi,doe));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeApplicant;
    }

    public void updateApplicant(ApplicationModelClass applicationModelClass){
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.NAME,applicationModelClass.getName());
        contentValues.put(DBHelper.EMAIL,applicationModelClass.getEmail());
        contentValues.put(DBHelper.RES_COUNTRY,applicationModelClass.getRes_country());
        contentValues.put(DBHelper.DOB,applicationModelClass.getDob());
        contentValues.put(DBHelper.POV,applicationModelClass.getPov());
        contentValues.put(DBHelper.DOT,applicationModelClass.getDot());
        contentValues.put(DBHelper.DOI,applicationModelClass.getDoi());
        contentValues.put(DBHelper.DOE,applicationModelClass.getDoe());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.update(TABLE_NAME,contentValues,ID + " = ?" , new String[]
                {String.valueOf(applicationModelClass.getId())});
    }

    public void deleteApplicant(int id){
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME, ID + " = ? ", new String[]
                {String.valueOf(id)});
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    db.execSQL("create table users(username TEXT primary key, password TEXT, password1 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists users");
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
    @SuppressLint("SuspiciousIndentation")
    public boolean insertData(String username, String password, String password1){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
//        values.put("email",email);
        values.put("username",username);
        values.put("password",password);
        values.put("password1",password1);
        long result=db.insert("users", null,values);
        if (result==-1)
            return false;
        else
            return true;
    }
    public boolean checkUsername(String username){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username=?",new String[] {username});
        if(cursor.getCount()>0) return true;
        else
            return false;
    }
    public boolean checkUsernamePassword(String username,String password,String password1){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username=? and password=? and password1=?",new String[] { username,password,password1});
        if(cursor.getCount()>0) return true;
        else
            return false;
    }
}
