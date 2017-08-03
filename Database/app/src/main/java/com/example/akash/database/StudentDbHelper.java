package com.example.akash.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by akash on 22-Jul-17.
 */

public class StudentDbHelper extends SQLiteOpenHelper {


    public  StudentDbHelper(Context context) {
        super(context, "Akatsuki.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE teamInfo (name text, village text, gender text, speciality text)");
        db.execSQL("CREATE TABLE tailedBeasts (beasts text)");


    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists teamInfo");
        db.execSQL("drop table if exists tailedBeasts");
        onCreate(db);

    }
}
