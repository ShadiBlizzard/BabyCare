package com.example.shadi.babycare.layout_view;

import android.support.design.internal.NavigationMenu;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;

public class UpdateProfileActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_update_profile, fl);

        super.setTitle("Update profile");
    }
}
