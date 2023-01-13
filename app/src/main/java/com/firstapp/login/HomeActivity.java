package com.firstapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button button;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        button = (Button) findViewById(R.id.btnfitness);
        button1 = (Button) findViewById(R.id.btninfo);
        button2 = (Button) findViewById(R.id.btndiet);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(HomeActivity.this,Exersise1.class);
                startActivity(intent);

            }

        });

        button1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(HomeActivity.this, scrollview.class);
                startActivity(intent1);
            }


        });

        button2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(HomeActivity.this, DIET.class);
                startActivity(intent2);
            }
        });

    }
}