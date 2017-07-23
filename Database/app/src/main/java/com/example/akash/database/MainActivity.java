package com.example.akash.database;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StudentDbHelper database = new StudentDbHelper(this);
       final String dbname = database.getDatabaseName();
       SQLiteDatabase database1 = database.getWritableDatabase();

        Toast.makeText(MainActivity.this, "the row number is "+dbname, Toast.LENGTH_LONG).show();


    }
}
