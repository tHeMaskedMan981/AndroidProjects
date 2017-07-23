package com.example.akash.akatsuki;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class PlanetaryDevastation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planetary_devastation);


        SeekBar chakra;

       final ImageView rasengan= (ImageView) findViewById(R.id.rasengan);
        chakra = (SeekBar) findViewById(R.id.seekBar);

        chakra.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i>50)
                {
                    rasengan.setTranslationY((float)(-1.5)*(i-50));
                    rasengan.getLayoutParams().width = i * 3 + 150;
                    rasengan.getLayoutParams().height = i * 3 + 150;
                    rasengan.requestLayout();
                }
                else
                {   rasengan.setTranslationY(0);
                    rasengan.getLayoutParams().width = i * 3 + 150;
                    rasengan.getLayoutParams().height = i * 3 + 150;
                    rasengan.requestLayout();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button b1 = (Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PlanetaryDevastation.this, tsukinome.class);
                startActivity(intent);

            }
        });

        Button b2 = (Button) findViewById(R.id.startbattle);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View v = LayoutInflater.from(PlanetaryDevastation.this).inflate(R.layout.activity_login, null);
               // initialize these views after the layout is loaded, as these are not in the base class here(PlanetaryDevastation)
                final EditText name = (EditText) v.findViewById(R.id.name);
                final EditText boss = (EditText) v.findViewById(R.id.boss);
                // also it is not just findViewbyId but view.findViewbyid

                AlertDialog.Builder builder = new AlertDialog.Builder(PlanetaryDevastation.this);

                builder.setTitle("LOGIN").setMessage("Who are you?").setView(v);
                builder.setPositiveButton("Let's do it", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    String Name = name.getText().toString();
                    String Boss = boss.getText().toString();

                        if (Boss.equals("pain"))
                        {
                            Toast.makeText(PlanetaryDevastation.this, "Welcome to Infinite TSUKUYOMI..!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent ( PlanetaryDevastation.this, battle.class);
                            startActivity(intent);
                        }
                        else
                        {
                            Toast.makeText(PlanetaryDevastation.this,"KNOW YOUR LIMITS, ASSHOLE", Toast.LENGTH_SHORT).show();
                            Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(1000);
                        }

                    }
                }).setNegativeButton("Cancel", null).setCancelable(false);

                AlertDialog alert =  builder.create();
                alert.show();
            }
        });

    }
        @Override
    public void onBackPressed()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(PlanetaryDevastation.this);

        builder.setTitle("Really Exit??").setMessage("U r going back on ur words.. IS that ur ninja way?");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                PlanetaryDevastation.super.onBackPressed();
            }
        }).setNegativeButton("no", null);
        builder.setCancelable(false);

        AlertDialog alert =  builder.create();
        alert.show();
    }

}
