package com.firstapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class day222 extends AppCompatActivity {
    private Button button;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_day222);

        button = (Button) findViewById(R.id.writ);
        button1 = (Button) findViewById(R.id.writ1);
        button2 = (Button) findViewById(R.id.writ2);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(day222.this,counter.class);
                startActivity(intent);

            }

        });


        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(day222.this,counter.class);
                startActivity(intent);

            }

        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(day222.this,counter.class);
                startActivity(intent);

            }

        });
    }
}