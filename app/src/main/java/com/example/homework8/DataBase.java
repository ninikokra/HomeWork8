package com.example.homework8;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.Objects;

public class DataBase extends SQLiteOpenHelper {
    SQLiteDatabase sqlBase;


    public DataBase(Context context) {
        super(context, "usersBase.db", null, 1);
        sqlBase = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String base = "create table myUsers (Mobile text,Password text)";
        sqLiteDatabase.execSQL(base);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void saveData(ContentValues contentValues){
        sqlBase.insert("myUsers",null,contentValues);
    }

    public String getData (String mob){
        Cursor cursor;

        cursor = sqlBase.query("myUsers",null,"Mobile=?",new String[]{mob},null,null,null);
        cursor.moveToFirst();
        //String password = cursor.getString(cursor.getColumnIndex("Password"));
        if (cursor.getCount()<1){
            return "not Exist";
        }
        @SuppressLint("Range")
        String mobile = cursor.getString(cursor.getColumnIndex("Password"));



        return mobile ;

    }
}
