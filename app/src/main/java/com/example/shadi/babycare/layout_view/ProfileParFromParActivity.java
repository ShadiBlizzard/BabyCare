package com.example.shadi.babycare.layout_view;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.os.Bundle;

import com.example.shadi.babycare.R;

public class ProfileParFromParActivity extends ProfileParFromBsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout fl = findViewById(R.id.profile_variable_content);
        getLayoutInflater().inflate(R.layout.activity_profile_par_from_par, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(3).setChecked(true);
    }
}
