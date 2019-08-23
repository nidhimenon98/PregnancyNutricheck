package com.example.pregnancynutricheck;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {
    String create_table= "create table " + keys.TABLE_NAME + "(" + keys.ID + " integer primary key autoincrement, " +
            keys.NAME + " text not null, " + keys.HUSBAND_NAME + " text not null, " + keys.REGION + " text not null, " +
            keys.PHONE_NO + " text not null, " + keys.PASS + " text not null, " + keys.RE_TYPE_PASS + " text not null);";
    public DatabaseHelper(Context context) {
        super(context,keys.DB_NAME,null ,keys.DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.i("preg",create_table);
        database.execSQL(create_table);
        Log.i("preg","Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {
        onCreate(database);
    }
}
