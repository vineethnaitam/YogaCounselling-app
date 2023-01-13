package com.firstapp.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class number extends AppCompatActivity {

    EditText enternumber;
    Button getotpnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        enternumber = findViewById(R.id.inputnumber);
        getotpnumber = findViewById(R.id.otp);

        ProgressBar progressBar = findViewById(R.id.buffer);

        getotpnumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!enternumber.getText().toString().trim().isEmpty()){
                    if ((enternumber.getText().toString().trim()).length() == 10){

                        progressBar.setVisibility(view.VISIBLE);
                        getotpnumber.setVisibility(view.INVISIBLE);

                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + enternumber.getText().toString(),
                                60,
                                TimeUnit.SECONDS,
                                number.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                        progressBar.setVisibility(view.GONE);
                                        getotpnumber.setVisibility(view.VISIBLE);
                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull FirebaseException e) {
                                        progressBar.setVisibility(view.GONE);
                                        getotpnumber.setVisibility(view.VISIBLE);
                                        Toast.makeText(number.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull String backendotp, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                        progressBar.setVisibility(view.GONE);
                                        getotpnumber.setVisibility(view.VISIBLE);
                                        Intent intent = new Intent(getApplicationContext(),verify.class);
                                        intent.putExtra("mobile",enternumber.getText().toString());
                                        intent.putExtra("backendotp",backendotp);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                    }
                                }
                        );


 //                       Intent intent = new Intent(getApplicationContext(),verify.class);
//                        intent.putExtra("mobile",enternumber.getText().toString());
//                        startActivity(intent);
                    }else {
                        Toast.makeText(number.this,"please enter correct number",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(number.this,"Enter Mobile Number",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}