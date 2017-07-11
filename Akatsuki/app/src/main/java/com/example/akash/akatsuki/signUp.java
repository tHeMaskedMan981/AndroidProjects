package com.example.akash.akatsuki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    Button b1;
    EditText name, password, village;
    RadioGroup rg;
    RadioButton male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.name);
        village = (EditText) findViewById(R.id.village);
        password = (EditText) findViewById(R.id.password);

        b1.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick (View v)
            {
                Toast.makeText(signUp.this, "Welcome "+ name+ ". \n This world shall know.. \n PAIN..!!", Toast.LENGTH_LONG);


            }


        });



    }
}
