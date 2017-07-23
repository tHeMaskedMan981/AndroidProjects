package com.example.akash.akatsuki;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.akash.akatsuki.sqlDatabase;

public class signUp extends AppCompatActivity {

    Button b1,b2;
    EditText name, password, village;
    RadioGroup rg,rg2;
    RadioButton male, female;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.name);
        village = (EditText) findViewById(R.id.village);
//        password = (EditText) findViewById(R.id.password);
        b1 = (Button) findViewById(R.id.submit);
        b2 = (Button) findViewById(R.id.submit1);
//        male= (RadioButton) findViewById(R.id.male);
//        female= (RadioButton) findViewById(R.id.female);

        rg = (RadioGroup) findViewById(R.id.RadioGroup);
        rg2 = (RadioGroup) findViewById(R.id.RadioGroup2);


        sqlDatabase database = new sqlDatabase(this);
        final String dbname = database.getDatabaseName();
       final SQLiteDatabase db = database.getWritableDatabase();






        b1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick (View v)
            {

//                Toast.makeText(signUp.this, "Welcome "+salute+" " finalName+ " from " +finalVillage+". \n This world shall know.. \n       PAIN..!!", Toast.LENGTH_LONG).show();

                final String finalName = name.getText().toString();
                final String finalVillage = village.getText().toString();
//                final String finalPass = password.getText().toString();


//                String gender= "", salute="";
//
//                if (male.isChecked())
//                {gender="Male"; salute="Ninja";}
//                else if (female.isChecked())
//                {gender="Female"; salute ="Kunoichi";}

                int i = rg.getCheckedRadioButtonId();
                final RadioButton rb = (RadioButton) findViewById(i);

                int j = rg2.getCheckedRadioButtonId();
                final RadioButton rb2 = (RadioButton) findViewById(j);


                Intent intent = new Intent(signUp.this, WelcomeToPeace.class);

                intent.putExtra("name",finalName);
                intent.putExtra("village",finalVillage);
                intent.putExtra("gender",rb.getText().toString());
                intent.putExtra("speciality",rb2.getText().toString());


                ContentValues values = new ContentValues();
                values.put("name", finalName);
                values.put("village", finalVillage);
                values.put("gender",rb.getText().toString() );
                values.put("speciality",rb2.getText().toString());

                long row = db.insert("teamInfo" , null, values);

                Toast.makeText(signUp.this, "the row number is "+row+" "+dbname, Toast.LENGTH_LONG).show();

//               Toast.makeText(signUp.this, "Welcome "+rb.getText().toString()+" " +finalName+"("+rb2.getText().toString()+") "+ " from " +finalVillage+". \n     This world shall know.. \n       PAIN..!!", Toast.LENGTH_SHORT).show();

                startActivity(intent);


            }


        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent inten1 = new Intent(signUp.this, PlanetaryDevastation.class);

                startActivity(inten1);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.settings :
                Toast.makeText(signUp.this, "I will set things up for u and this world", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.about :
                Toast.makeText(signUp.this, "Savior of the world", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.contact :
                Toast.makeText(signUp.this, "meet me in hell", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.kamui :
                Toast.makeText(signUp.this, "kamui...!", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
