package com.example.residence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Property extends AppCompatActivity {

    Spinner propertySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);

        propertySpinner=(Spinner)findViewById(R.id.propert_spinner);
        ArrayAdapter <String> myAdapter=new ArrayAdapter<String>(Property.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.property_types));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        propertySpinner.setAdapter(myAdapter);
    }
}