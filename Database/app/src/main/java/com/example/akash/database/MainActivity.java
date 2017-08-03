package com.example.akash.database;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    StudentDbHelper database;
    EditText name,tail,village;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database = new StudentDbHelper(this);
       final String dbname = database.getDatabaseName();
       final SQLiteDatabase db = database.getWritableDatabase();

        Button submit, show;

        name = (EditText) findViewById(R.id.name);
        village = (EditText) findViewById(R.id.village);
        tail = (EditText) findViewById(R.id.tail);
        submit = (Button) findViewById(R.id.submit);
        show = (Button) findViewById(R.id.show);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ContentValues values = new ContentValues();
                String sname =name.getText().toString();
                String svillage =village.getText().toString();
                String stail =tail.getText().toString();
                values.put("name", sname);
                values.put("village", svillage);

                long row = db.insert("teamInfo" , null, values);

                ContentValues values2 = new ContentValues();
                values2.put("beasts", stail);
                long row2 = db.insert("tailedBeasts" , null, values2);


                Toast.makeText(MainActivity.this, "the row number is"+row+" "+row2+"\n"+dbname+" "+sname+" "+svillage+" "+stail, Toast.LENGTH_LONG).show();

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });





    }
}
