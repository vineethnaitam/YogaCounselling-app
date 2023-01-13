package com.firstapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class scrollview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_scrollview);
        TextView text = (TextView) findViewById(R.id.link);
        text.setMovementMethod(LinkMovementMethod.getInstance());
    }
}