package com.example.shadi.babycare.layout_view;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;

public class ProfileBsFromBsActivity extends ProfileParFromBsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.profile_variable_content);
        getLayoutInflater().inflate(R.layout.activity_profile_bs_from_bs, fl);
        //da finire

    }
}
