package com.example.linkstorer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;

public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(@Nullable Context context) {
        super(context, "linkData.db", null, 1);
    }


    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetails(link TEXT primary key, linkDesc TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserData(String link, String linkDesc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("link", link);
        values.put("linkDesc", linkDesc);
        long result = db.insert("Userdetails", null, values);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public ArrayList<HashMap<String,String >> getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT link, linkDesc FROM Userdetails";
        Cursor cursor = db.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> user = new HashMap<>();
            user.put("link",cursor.getString(cursor.getColumnIndex("link")));
            user.put("linkDesc",cursor.getString(cursor.getColumnIndex("linkDesc")));
            userList.add(user);
        }
        return  userList;
    }

}




