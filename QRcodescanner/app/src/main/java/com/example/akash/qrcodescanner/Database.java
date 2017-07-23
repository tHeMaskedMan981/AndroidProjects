package com.example.akash.qrcodescanner;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by akash on 22-Jul-17.
 */

public class Database extends SQLiteOpenHelper {


    public Database(Context context) {
        super(context, "Akatsuki.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE DETAILS (ID text,name text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("drop table if exists DETAILS");
        onCreate(db);

    }
}
