package com.example.akash.akatsuki;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by akash on 21-Jul-17.
 */

public class sqlDatabase extends SQLiteOpenHelper {


    public sqlDatabase(Context context) {
        super(context, "Akatsuki.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table teamInfo (name text, village text, gender text, speciality text)");


    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists teamInfo");
        onCreate(db);

    }
}
