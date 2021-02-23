package com.example.residence;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class VerifyPhoneNumber extends AppCompatActivity {

    Button verify_btn;
    EditText phoneNoEnteredByTheUser;
    ProgressBar verificationProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone_number);

        //Hooks
        verify_btn = findViewById(R.id.verify_btn);
        phoneNoEnteredByTheUser = findViewById(R.id.verification_code_entered_by_user);
        verificationProgressBar = findViewById(R.id.verification_progress_bar);

        String phoneNo = getIntent().getStringExtra("phoneNumber").toString();

        //  sendVerificationCodeToUser(phoneNo);


    }

    /*private void sendVerificationCodeToUser(String phoneNo){
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNo)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(TaskExecutors.MAIN_THREAD)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

     */

}