package com.firstapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Exersise1 extends AppCompatActivity {


    Animation up,down;
    ImageView imageView;
    ImageView imageView1;
    Button button;
    Button button1;
    Button button2;
    private Button button3;
    private Button button4;
    private Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_exersise1);

        ImageView imageView = findViewById(R.id.yoga);
        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        imageView.setAnimation(up);

        ImageView imageView1 = findViewById(R.id.fit);
        down = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.down);
        imageView1.setAnimation(up);


        Button button = findViewById(R.id.btnyo);
        up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        button.setAnimation(down);

        Button button1 = findViewById(R.id.btnwork);
        up = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.up);
        button1.setAnimation(down);


        button3 = (Button) findViewById(R.id.btnyo);


        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Exersise1.this,Exersise2.class);
                startActivity(intent);

            }

        });

        button4 = (Button) findViewById(R.id.btnwork);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent1 = new Intent(Exersise1.this,workout.class);
                startActivity(intent1);
            }
        });



        button5 = (Button) findViewById(R.id.docter);


        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(Exersise1.this,ngos.class);
                startActivity(intent2);

            }

        });

    }
}