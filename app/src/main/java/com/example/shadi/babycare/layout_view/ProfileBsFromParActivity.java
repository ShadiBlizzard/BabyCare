package com.example.shadi.babycare.layout_view;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shadi.babycare.R;

public class ProfileBsFromParActivity extends ProfileParFromBsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout cl = findViewById(R.id.profile_variable_content);

        getLayoutInflater().inflate(R.layout.activity_profile_bs_from_par, cl);
    }
}
