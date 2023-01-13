package com.firstapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Exersise5 extends AppCompatActivity {

    private ImageButton imageButton;
    private ImageButton imageButton1;
    private ImageButton imageButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_exersise5);

        imageButton = (ImageButton) findViewById(R.id.btn60);
        imageButton1 = (ImageButton) findViewById(R.id.btn7);
        imageButton2 = (ImageButton) findViewById(R.id.btn8);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Exersise5.this, day111.class);
                startActivity(intent);

            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Exersise5.this, day222.class);
                startActivity(intent1);
            }


        });

        imageButton2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(Exersise5.this, day333.class);
                startActivity(intent2);
            }
        });
    }
}