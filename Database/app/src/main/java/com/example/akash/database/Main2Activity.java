package com.example.akash.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    StudentDbHelper database = new StudentDbHelper(this);
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final String dbname = database.getDatabaseName();
        final SQLiteDatabase db = database.getReadableDatabase();

        t = (TextView) findViewById(R.id.result);
        String columns[]={"name","village"};
        String columns2[]={"beasts"};

        Cursor cursor = db.query(
                "teamInfo",                     // The table to query
                columns,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                // The sort order
        );
        cursor.moveToLast();
        String name = cursor.getString(0);
        String village = cursor.getString(1);

        Cursor cursor1 = db.query("tailedBeasts", columns2, null, null, null, null, null);
        cursor1.moveToLast();
        String beast = cursor1.getString(0);
//        Toast.makeText(Main2Activity.this, name, Toast.LENGTH_LONG).show();
        t.setText(name+" "+village+" "+beast);


    }
}
