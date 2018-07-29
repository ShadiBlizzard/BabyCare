package com.example.shadi.babycare.layout_view;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;
import com.example.shadi.babycare.layout_view.ProfileActivity;

public class ProfileParFromParActivity extends ProfileActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.profile_variable_content);
        getLayoutInflater().inflate(R.layout.activity_profile_par_from_par, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(3).setChecked(true);
    }
}
