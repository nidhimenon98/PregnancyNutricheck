package com.example.pregnancynutricheck;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class events {
    static SQLiteDatabase database;
    public static DatabaseHelper dbhelper;
    public static DatabaseHelper getInstance(Context context)
    {
        if(dbhelper==null){
            dbhelper=new DatabaseHelper(context);
        }
        return dbhelper;
    }

    public static void open(){database=dbhelper.getWritableDatabase();}
    public static void close(){
        database.close();
    }
    public static void add(String name, String husband_name, String region, String phone_no, String pass, String re_pass){
        ContentValues c=new ContentValues();
        c.put(keys.NAME,name);
        c.put(keys.HUSBAND_NAME, husband_name);
        c.put(keys.REGION, region);
        c.put(keys.PASS, phone_no);
        c.put(keys.PHONE_NO, pass);
        c.put(keys.RE_TYPE_PASS,re_pass);

        database.insertOrThrow(keys.TABLE_NAME,null,c);
        Log.i("preg","Record Inserted Successfully");

    }
}
