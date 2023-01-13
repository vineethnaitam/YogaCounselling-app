package com.firstapp.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class verify extends AppCompatActivity {

    EditText inputnumber1,inputnumber2,inputnumber3,inputnumber4,inputnumber5,inputnumber6;
    Button okbutton;
    String getotpbackend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        okbutton = findViewById(R.id.submit);

        inputnumber1 = findViewById(R.id.box1);
        inputnumber2 = findViewById(R.id.box2);
        inputnumber3 = findViewById(R.id.box3);
        inputnumber4 = findViewById(R.id.box4);
        inputnumber5 = findViewById(R.id.box5);
        inputnumber6 = findViewById(R.id.box6);

        TextView textView = findViewById(R.id.textbox);
        textView.setText(String.format(
                "+91-%s",getIntent().getStringExtra("mobile")
        ));

        getotpbackend = getIntent().getStringExtra("backendotp");

        ProgressBar progressBar1 = findViewById(R.id.buffer1);
        okbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (!inputnumber1.getText().toString().trim().isEmpty() && !inputnumber2.getText().toString().trim().isEmpty() && !inputnumber3.getText().toString().trim().isEmpty() && !inputnumber4.getText().toString().trim().isEmpty() && !inputnumber5.getText().toString().trim().isEmpty() && !inputnumber6.getText().toString().trim().isEmpty()){
                   String entercodeotp = inputnumber1.getText().toString() +
                           inputnumber2.getText().toString() +
                           inputnumber3.getText().toString() +
                           inputnumber4.getText().toString() +
                           inputnumber5.getText().toString() +
                           inputnumber6.getText().toString();

                   if (getotpbackend!=null){
                       progressBar1.setVisibility(view.VISIBLE);
                       okbutton.setVisibility(view.INVISIBLE);

                       PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                               getotpbackend,entercodeotp
                       );
                       FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                               .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                   @Override
                                   public void onComplete(@NonNull Task<AuthResult> task) {
                                       progressBar1.setVisibility(view.GONE);
                                       okbutton.setVisibility(view.VISIBLE);

                                       if (task.isSuccessful()){
                                           Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                           startActivity(intent);
                                       }else {
                                           Toast.makeText(verify.this,"Enter the correct OTP",Toast.LENGTH_SHORT).show();
                                       }
                                   }
                               });
                   }else {
                       Toast.makeText(verify.this,"Please check internet connection",Toast.LENGTH_SHORT).show();
                   }


 //                  Toast.makeText(verify.this,"OTP Verified",Toast.LENGTH_SHORT).show();
               }else {
                   Toast.makeText(verify.this,"please enter all numbers",Toast.LENGTH_SHORT).show();
               }
            }
        });
        
        numberotpmove();

        TextView resendlabel = findViewById(R.id.resend);

        resendlabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        verify.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                                Toast.makeText(verify.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull String newbackendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {


                                getotpbackend = newbackendotp;
                                Toast.makeText(verify.this,"OTP sended successfully",Toast.LENGTH_SHORT).show();


                            }
                        }
                );

            }
        });
    }





    private void numberotpmove() {

        inputnumber1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    inputnumber2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputnumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    inputnumber3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputnumber3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    inputnumber4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputnumber4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    inputnumber5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        inputnumber5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().trim().isEmpty()){
                    inputnumber6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}