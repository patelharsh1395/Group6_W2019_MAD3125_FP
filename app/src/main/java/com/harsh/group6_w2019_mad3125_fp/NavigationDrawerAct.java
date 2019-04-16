package com.harsh.group6_w2019_mad3125_fp;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;


public class NavigationDrawerAct extends AppCompatActivity{

    private WebView webView;


    Toolbar customToolBar;
    NavigationView nav_view;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    AboutUsFragment aboutUsFragment;
    AddEmployeesFragment addEmployeesFragment;
    EmployeeFragment employeeFragment;
    ContactUsFragment contactUsFragment;
    DrawerLayout nav_drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);



       // String htmlString = "<h1>Hello World</h1>";
       // webView = findViewById(R.id.myWebView);

      //  webView.setWebViewClient(new WebViewClient());
       // webView.loadUrl("https://www.google.com");

        // webView.loadData(htmlString, "aboutus/html", "utf8");

       // AssetManager mAssetManager = this.getAssets();
       // try
      //  {
          //  InputStream mInputStream = mAssetManager.open("aboutus.html");
          //  int size = mInputStream.available();
          //  byte[] buffer = new byte[size];
           // mInputStream.read(buffer);
          //  mInputStream.close();
          //  String content = new String(buffer, "UTF-8");

          //  Log.d("DATA", content);
            // webView.loadData(content, "aboutus/html", "utf-8");
      //  } catch (IOException e)
       // {
           // e.printStackTrace();
      //  }








        this.nav_drawer = (DrawerLayout) findViewById(R.id.nav_drawer);
        employeeFragment = new EmployeeFragment();



        //reference -  https://stackoverflow.com/questions/26486730/in-android-app-toolbar-settitle-method-has-no-effect-application-name-is-shown
        // for displaying title on ToolBar
        // reference - https://developer.android.com/training/implementing-navigation/nav-drawer
        // for Add the nav drawer button
        this.customToolBar = findViewById(R.id.Customtoolbar);
        setSupportActionBar(this.customToolBar);
        final ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle("My title");
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.navigation_drawer_button_24dp);

        fragmentManager = getSupportFragmentManager();
        this.fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, employeeFragment);
        fragmentTransaction.commit();
        this.customToolBar.setTitle("Employees");



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
                        actionbar.setTitle("Employees");
                        NavigationDrawerAct.this.nav_drawer.closeDrawer(Gravity.START, true);
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
                        actionbar.setTitle("Add employee");
                        NavigationDrawerAct.this.nav_drawer.closeDrawer(Gravity.START, true);
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
                        actionbar.setTitle("About US");
                        NavigationDrawerAct.this.nav_drawer.closeDrawer(Gravity.START, true);
                        Toast.makeText(NavigationDrawerAct.this, "About US" , Toast.LENGTH_LONG).show();
                        break;
                    case R.id.contact_us :
                        if(contactUsFragment == null)
                        {
                            contactUsFragment = new ContactUsFragment();
                        }
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_layout, contactUsFragment);
                        fragmentTransaction.commit();
                        actionbar.setTitle("Contact Us");
                        NavigationDrawerAct.this.nav_drawer.closeDrawer(Gravity.START, true);
                        Toast.makeText(NavigationDrawerAct.this, "Contact Us" , Toast.LENGTH_LONG).show();
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.nav_drawer.openDrawer(Gravity.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
