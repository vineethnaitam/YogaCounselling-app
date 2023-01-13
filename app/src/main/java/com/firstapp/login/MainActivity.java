package com.firstapp.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText passEdit;
    private CheckBox mCheckBox;


    EditText username,password,repassword;
    Button btnSignUp,btnSignIn;
    DBHelper myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        repassword = (EditText)findViewById(R.id.repassword);
        passEdit = findViewById(R.id.password);
        mCheckBox = findViewById(R.id.apper2);


        btnSignUp = (Button) findViewById(R.id.btnsignup);
        btnSignIn = (Button) findViewById(R.id.btnsignin);

        myDB = new DBHelper(this);

        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    passEdit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    passEdit.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("") || pass.equals("") || repass.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Fill all the fields.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                  if(pass.equals(repass))
                  {
                      Boolean usercheckResult = myDB.checkusername(user);
                      if(usercheckResult == false)
                      {
                         Boolean regResult = myDB.insertData(user,pass);
                         if(regResult == true){
                             Toast.makeText(MainActivity.this, "Registration Successful.", Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(getApplicationContext(),number.class);
                             intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                             startActivity(intent);
                         }
                         else
                         {
                             Toast.makeText(MainActivity.this, "Registration Failed.", Toast.LENGTH_SHORT).show();
                         }
                      }
                      else
                      {
                          Toast.makeText(MainActivity.this, "User already Exists.\n please Sign In", Toast.LENGTH_SHORT).show();
                      }
                  }
                  else
                  {
                      Toast.makeText(MainActivity.this, "Password not matching.", Toast.LENGTH_SHORT).show();
                  }
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),loginActivity2.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }
}