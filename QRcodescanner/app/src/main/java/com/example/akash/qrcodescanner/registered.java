package com.example.akash.qrcodescanner;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class registered extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);


        Database database = new Database(this);
        final String dbname = database.getDatabaseName();
        final SQLiteDatabase db = database.getReadableDatabase();

        Toast.makeText(registered.this, "the row number is "+" \n participant registered :"+dbname, Toast.LENGTH_LONG).show();

    }
}
