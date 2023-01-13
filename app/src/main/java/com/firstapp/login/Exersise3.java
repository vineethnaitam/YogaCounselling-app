package com.firstapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Exersise3 extends AppCompatActivity {
    private ImageButton imageButton;
    private ImageButton imageButton1;
    private ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_exersise3);

        imageButton = (ImageButton) findViewById(R.id.btn);
        imageButton1 = (ImageButton) findViewById(R.id.btn1);
        imageButton2 = (ImageButton) findViewById(R.id.btn2);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Exersise3.this, day1.class);
                startActivity(intent1);

            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Exersise3.this, day2.class);
                startActivity(intent1);
            }


        });

        imageButton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(Exersise3.this, day3.class);
                startActivity(intent2);
            }
        });
    }
}