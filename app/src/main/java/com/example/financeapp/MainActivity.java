package com.example.financeapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.dashboard:
                    Dashboard f4 = new Dashboard();
                    FragmentManager fm2 = getSupportFragmentManager();
                    FragmentTransaction ft1 = fm2.beginTransaction();
                    ft1.replace(R.id.frame, f4);
                    ft1.commit();
                    return true;
                case R.id.customers:
                    Customers f1 = new Customers();
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frame, f1);
                    ft.commit();
                    return true;
                case R.id.depositors:
                    Depositors f2 = new Depositors();
                    FragmentManager fm3 = getSupportFragmentManager();
                    FragmentTransaction ft2 = fm3.beginTransaction();
                    ft2.replace(R.id.frame, f2);
                    ft2.commit();
                    return true;
                case R.id.reports:
                    Reports f11 = new Reports();
                    FragmentManager fm11 = getSupportFragmentManager();
                    FragmentTransaction ft11 = fm11.beginTransaction();
                    ft11.replace(R.id.frame, f11);
                    ft11.commit();
                    return true;

                case R.id.menu:
                    Menu f3 = new Menu();
                    FragmentManager fm1 = getSupportFragmentManager();
                    FragmentTransaction ft4 = fm1.beginTransaction();
                    ft4.replace(R.id.frame, f3);
                    ft4.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dashboard f4 = new Dashboard();
        FragmentManager fm2 = getSupportFragmentManager();
        FragmentTransaction ft1 = fm2.beginTransaction();
        ft1.replace(R.id.frame, f4);
        ft1.commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.customers_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action) {
            return true;
        }
        if (id == R.id.sign) {
            return true;
        }
        if (id == R.id.out) {
            return true;
        }
        if (id == R.id.action_sign) {
            return true;
        }
        if (id == R.id.action_sign_out) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
