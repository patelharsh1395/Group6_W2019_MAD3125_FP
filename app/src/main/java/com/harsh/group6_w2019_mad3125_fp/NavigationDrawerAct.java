package com.harsh.group6_w2019_mad3125_fp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationDrawerAct extends AppCompatActivity {



    NavigationView nav_view;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    AboutUsFragment aboutUsFragment;
    AddEmployeesFragment addEmployeesFragment;
    EmployeeFragment employeeFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        employeeFragment = new EmployeeFragment();



        fragmentManager = getSupportFragmentManager();
        this.fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, employeeFragment);
        fragmentTransaction.commit();




        nav_view = findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.employees :
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, employeeFragment, null);
                        fragmentTransaction.commit();
                        Toast.makeText(NavigationDrawerAct.this, "Employees" , Toast.LENGTH_LONG).show();
                        break;
                    case R.id.add_employee :
                        if(addEmployeesFragment == null)
                        {
                            addEmployeesFragment = new AddEmployeesFragment();
                        }
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, addEmployeesFragment);
                        fragmentTransaction.commit();
                        Toast.makeText(NavigationDrawerAct.this, "Add employee" , Toast.LENGTH_LONG).show();
                        break;
                    case R.id.about_us :
                        if(aboutUsFragment == null)
                        {
                            aboutUsFragment = new AboutUsFragment();
                        }
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, aboutUsFragment);
                        fragmentTransaction.commit();
                        Toast.makeText(NavigationDrawerAct.this, "About US" , Toast.LENGTH_LONG).show();
                        break;
                    case R.id.logout :
                        startActivity(new Intent(NavigationDrawerAct.this, LoginActivity.class));
                        Toast.makeText(NavigationDrawerAct.this, "Logout" , Toast.LENGTH_LONG).show();
                        break;

                }



                return true;
            }
        });

    }
}
