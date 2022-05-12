package com.example.lifecycleapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "usersTable";

    public DataBaseHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(" create table " + TABLE_NAME
          + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,AGE TEXT,PHONE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean insertData(String userName,String userAge,String userPhone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",userName);
        contentValues.put("AGE",userAge);
        contentValues.put("PHONE",userPhone);
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return result != -1;
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.rawQuery("select * from "+TABLE_NAME, null);
    }

    public boolean updateData(String Id,String userName,String userAge,String userPhone){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID",Id);
        contentValues.put("NAME",userName);
        contentValues.put("AGE",userAge);
        contentValues.put("PHONE",userPhone);
        sqLiteDatabase.update(TABLE_NAME,contentValues, "id = ?",new String[]{Id});
        return true;

    }

    public Integer deleteData(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,"ID = ? ", new String[]{id});
    }
}
