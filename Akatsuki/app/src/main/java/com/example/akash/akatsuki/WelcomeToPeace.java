package com.example.akash.akatsuki;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeToPeace extends AppCompatActivity {

    TextView names, villages,message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_to_peace);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        names = (TextView) findViewById(R.id.name);
        villages = (TextView) findViewById(R.id.village);
        message = (TextView) findViewById(R.id.message);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String village = intent.getStringExtra("village");
        String gender = intent.getStringExtra("gender");
        String speciality = intent.getStringExtra("speciality");

        names.setText("Hello "+gender+" "+name);
        villages.setText(village);
        message.setText("we will use your "+speciality+" to create a world without darkness");

        Button b2 = (Button) findViewById(R.id.start);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(WelcomeToPeace.this);

                builder.setMessage("R U ready? to know pain?");
                builder.setPositiveButton("ikazu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent2 = new Intent(WelcomeToPeace.this, PlanetaryDevastation.class);
                        startActivity(intent2);
                    }
                }).setNegativeButton("Dame Dame", null);

                AlertDialog alert =  builder.create();
                alert.show();

            }
        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "FUCK YOU. YOU WILL KNOW PAIN", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
     public void hideButton(View v)
     {
         Button b1;
         TextView t1;

         t1 = (TextView) findViewById(R.id.t1);
         b1 = (Button) findViewById(R.id.hide);
         b1.setVisibility(View.INVISIBLE);
         names.setVisibility(View.INVISIBLE);
         villages.setVisibility(View.INVISIBLE);
         message.setVisibility(View.INVISIBLE);
         t1.setVisibility(View.INVISIBLE);
     }

}
