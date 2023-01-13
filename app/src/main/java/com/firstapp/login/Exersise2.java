package com.firstapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exersise2 extends AppCompatActivity {
    private Button button;
    private Button button1;
    private Button button2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_exersise2);
        button = (Button) findViewById(R.id.good1);
        button1 = (Button) findViewById(R.id.good3);
        button2 = (Button) findViewById(R.id.good5);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Exersise2.this,Exersise3.class);
                startActivity(intent);

            }

        });


        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Exersise2.this,Exersise4.class);
                startActivity(intent);

            }

        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Exersise2.this,Exersise5.class);
                startActivity(intent);

            }

        });



    }
}