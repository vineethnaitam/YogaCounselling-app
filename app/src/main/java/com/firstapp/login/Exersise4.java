package com.firstapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Exersise4 extends AppCompatActivity {
    private ImageButton imageButton;
    private ImageButton imageButton1;
    private ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_exersise4);

        imageButton = (ImageButton) findViewById(R.id.btn3);
        imageButton1 = (ImageButton) findViewById(R.id.btn4);
        imageButton2 = (ImageButton) findViewById(R.id.btn5);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Exersise4.this, day11.class);
                startActivity(intent1);

            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Exersise4.this, day22.class);
                startActivity(intent1);
            }


        });

        imageButton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(Exersise4.this, day33.class);
                startActivity(intent2);
            }
        });
    }
}