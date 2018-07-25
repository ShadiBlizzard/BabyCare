package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.shadi.babycare.R;

public class BaseActivity extends AppCompatActivity {

    private DrawerLayout mDrLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        NavigationView nv= findViewById(R.id.nav_view);
        mDrLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrLayout, R.string.open, R.string.close);
        mDrLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //code for clicked navi item
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                final String appPackageName = getPackageName();

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent homeCaller = new Intent(getApplicationContext(), SearchingActivity.class);
                        break;
                    case R.id.nav_reservations:
                        Intent resCaller = new Intent(getApplicationContext(), ReservationsListActivity.class);
                        startActivity(resCaller);
                        break;
                    case R.id.nav_messages:
                        Intent msgCaller = new Intent(getApplicationContext(), MessagesListActivity.class);
                        startActivity(msgCaller);
                        break;
                    case R.id.nav_policy:
                        Intent policyCaller = new Intent(getApplicationContext(), PolicyActivity.class);
                        startActivity(policyCaller);
                        break;
                    case R.id.nav_profile:
                        Intent profileCaller = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(profileCaller);
                        break;
                }

                return false;
            }
        });


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
