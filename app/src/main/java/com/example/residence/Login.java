package com.example.residence;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    Button callSignUpBtn, logInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        callSignUpBtn = findViewById(R.id.create_account_button);
        callSignUpBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(Login.this,Signup.class);
               startActivity(intent);
           }
       });

        logInBtn= findViewById(R.id.login_button);
        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intent=new Intent(Login.this,Home_Page.class);
              startActivity(intent);
            }
        });

    }
}