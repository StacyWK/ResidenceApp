package com.example.residence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hbb20.CountryCodePicker;

public class Signup extends AppCompatActivity {


    //variables
    TextInputLayout regUsername, regEmail, regPassword, regPhoneNo ;
    Button signUpBtn, regToLogInBtn;

    private FirebaseDatabase database= FirebaseDatabase.getInstance();
    private DatabaseReference rootNode=database.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //hooks
        regUsername = findViewById(R.id.user_name);
        regEmail = findViewById(R.id.email);
        regPassword = findViewById(R.id.password_);
        signUpBtn = findViewById(R.id.sign_up_button);
        regToLogInBtn = findViewById(R.id.toLog_in_button);
        regPhoneNo=findViewById(R.id.phone_number);

        regPhoneNo=findViewById(R.id.phone_number);




        regToLogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, Login.class);
                startActivity(intent);
            }
        });

    }

    private Boolean validateUserName() {
        String val = regUsername.getEditText().getText().toString().trim();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()) {
            regUsername.setError("Field cannot be empty");
            return false;
        } else if (val.length() >= 15) {
            regUsername.setError("Username is too long");
            return false;

        } else if (!val.matches(noWhiteSpace)) {
            regUsername.setError("White spaces ae not allowed");
            return false;
        } else {
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {

            regEmail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Invalid email address");
            return false;

        } else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhoneNumber() {
        String val = regUsername.getEditText().getText().toString().trim();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if (val.isEmpty()) {
            regUsername.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 10) {
            regUsername.setError("Username is too long");
            return false;

        } else if (!val.matches(noWhiteSpace)) {
            regUsername.setError("White spaces ae not allowed");
            return false;
        } else {
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = regPassword.getEditText().getText().toString().trim();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{6,}" +               //at least 6 characters
                "$";

        if (val.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            regPassword.setError("Password is too weak");
            return false;
        } else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }




    public void registerUser(View view) {

        if (!validateUserName() | !validateEmail()  | !validatePassword() ){
            return;
        }


        //Get all values as strings
        String user_name = regUsername.getEditText().getText().toString().trim();
        String email = regEmail.getEditText().getText().toString().trim();
        String phone_number = regPhoneNo.getEditText().getText().toString().trim();
        String password_ = regPassword.getEditText().getText().toString().trim();

       // Intent intent= new Intent(getApplicationContext(),VerifyPhoneNumber.class);

       // intent.putExtra("phoneNumber",ccp.getFullNumberWithPlus().replace("",""));
     //  startActivity(intent);

       SignUpHelperClass signUpHelperClass = new SignUpHelperClass(user_name, email, phone_number, password_);
        rootNode.child("userS").setValue(signUpHelperClass);

        Toast.makeText(this,"Your Account has been created successfully! Log in to continue.", Toast.LENGTH_SHORT).show();
         Intent intent1 =new Intent(Signup.this, Login.class);
         startActivity(intent1);
         finish();





    }
}