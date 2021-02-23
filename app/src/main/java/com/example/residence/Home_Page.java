package com.example.residence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;



public class Home_Page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView tenantIcon, serviceProviderIcon, paymentsIcon, tasksIcon, reportsIcon, chartsIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);

        tenantIcon=findViewById(R.id.tenant_icon);
        serviceProviderIcon=findViewById(R.id.service_providers_icon);
        paymentsIcon=findViewById(R.id.payments_icon);
        tasksIcon=findViewById(R.id.tasks_icon);
        reportsIcon=findViewById(R.id.reports_icon);
        chartsIcon=findViewById(R.id.charts_icon);


        tenantIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Home_Page.this,RegisterTenant.class);
                startActivity(intent);
            }
        });

        serviceProviderIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Home_Page.this,service_providers.class);
                startActivity(intent);
            }
        });

        paymentsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Home_Page.this,RegisterPayment.class);
                startActivity(intent);
            }
        });

        tasksIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Home_Page.this,RegisterTasks.class);
                startActivity(intent);
            }
        });

        reportsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Home_Page.this,Reports.class);
                startActivity(intent);
            }
        });

        chartsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Home_Page.this,Charts.class);
                startActivity(intent);
            }
        });




        toolbar=findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.nav_view);

        //Hide or show items
        Menu menu=navigationView.getMenu();
        menu.findItem(R.id.logout).setVisible(false);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
        super.onBackPressed();
    }
}

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.property:
                Intent intent=new Intent(Home_Page.this,Property.class);
                startActivity(intent);
                break;
            case R.id.message:
                Intent intent2t=new Intent(Home_Page.this,Send_Messages.class);
                break;
            default:
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;


    }

}