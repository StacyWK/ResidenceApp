 package com.example.residence;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.HashMap;

 public class RegisterTenant extends AppCompatActivity {


    TextInputLayout first_name,second_name,tenant_id,tenant_phone_no;
    Button register_tenantBtn;

   private FirebaseDatabase database=FirebaseDatabase.getInstance();
   private DatabaseReference root=database.getReference().child("Tenants");

    TextView calendarPicker;
    DatePickerDialog.OnDateSetListener onDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_tenant);

        //hooks
        first_name=findViewById(R.id.tenant_first_name_name);
        second_name=findViewById(R.id.tenant_second_name);
        tenant_id=findViewById(R.id.tenant_id);
        tenant_phone_no=findViewById(R.id.tenant_phone_no_name);


        calendarPicker= findViewById(R.id.calender_picker_text_view);

        calendarPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal= Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(RegisterTenant.this,android.R.style.Theme_DeviceDefault_Light,onDateSetListener,year,day,month);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();


            }

        });

        onDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date=dayOfMonth +"/" + month+ "/" +year;
                calendarPicker.setText(date);

            }
        };
    }

     private Boolean validateTenantFirstName() {
         String val = first_name.getEditText().getText().toString().trim();
         String noWhiteSpace = "\\A\\w{4,20}\\z";

         if (val.isEmpty()) {
             first_name.setError("Field cannot be empty");
             return false;
         } else if (val.length() >= 15) {
             first_name.setError("First name is too long");
             return false;

         } else if (!val.matches(noWhiteSpace)) {
             first_name.setError("White spaces ae not allowed");
             return false;
         } else {
             first_name.setError(null);
             first_name.setErrorEnabled(false);
             return true;
         }
     }

     private Boolean validateTenantSecondName() {
         String val = second_name.getEditText().getText().toString().trim();
         String noWhiteSpace = "\\A\\w{4,20}\\z";

         if (val.isEmpty()) {
             second_name.setError("Field cannot be empty");
             return false;
         } else if (val.length() >= 15) {
             second_name.setError("Username is too long");
             return false;

         } else if (!val.matches(noWhiteSpace)) {
             second_name.setError("White spaces ae not allowed");
             return false;
         } else {
             second_name.setError(null);
             second_name.setErrorEnabled(false);
             return true;
         }
     }

     private Boolean validateTenantId() {
         String val = tenant_id.getEditText().getText().toString().trim();

         if (val.isEmpty()) {
             tenant_id.setError("Field cannot be empty");
             return false;
         } else {
             tenant_id.setError(null);
             tenant_id.setErrorEnabled(false);
             return true;
         }
     }

     private Boolean validateTenantPhoneNumber() {
         String val = tenant_phone_no.getEditText().getText().toString().trim();

         if (val.isEmpty()) {
             tenant_phone_no.setError("Field cannot be empty");
             return false;
         } else {
             tenant_phone_no.setError(null);
             tenant_phone_no.setErrorEnabled(false);
             return true;
         }
     }


     public void registerTenant(View view) {

         if (!validateTenantFirstName() | !validateTenantSecondName() | !validateTenantId() | !validateTenantPhoneNumber()) {
             return;
         }


         //Get all values as strings
         String firstName = first_name.getEditText().getText().toString().trim();
         String secondName = second_name.getEditText().getText().toString().trim();
         String tenantId = tenant_id.getEditText().getText().toString().trim();
         String tenantPhoneNo = tenant_phone_no.getEditText().getText().toString().trim();


         HashMap<String, String > userMap= new HashMap<>();

         userMap.put("first_name", firstName);
         userMap.put("second_name", secondName);
         userMap.put("tenant_id", tenantId);
         userMap.put("tenant_phone_no", tenantPhoneNo);

         root.push().setValue(userMap);

         Toast.makeText(this, "The tenant has been registered successfully!", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(RegisterTenant.this, Home_Page.class);
         startActivity(intent);
         finish();
     }
}