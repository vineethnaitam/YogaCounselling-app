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

import com.google.android.material.textfield.TextInputLayout;

public class loginActivity2 extends AppCompatActivity {

    private EditText passEdit;
    private CheckBox mCheckBox;

    EditText username, password;

    Button btnLogin;

    DBHelper myDB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_login2);

        username = (EditText) findViewById(R.id.usernameLogin);
        password = (EditText) findViewById(R.id.passwordLogin);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        passEdit = findViewById(R.id.passwordLogin);
        mCheckBox = findViewById(R.id.look);

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

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("") || pass.equals(""))
                {
                    Toast.makeText(loginActivity2.this, "Please enter the Credentials.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                  Boolean result = myDB.checkusernamepassword(user,pass);
                  if(result == true){
                      Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                      startActivity(intent);

                  }
                  else
                  {
                      Toast.makeText(loginActivity2.this, "Invalid Credentials.", Toast.LENGTH_SHORT).show();
                  }
                }
            }
        });
    }
}