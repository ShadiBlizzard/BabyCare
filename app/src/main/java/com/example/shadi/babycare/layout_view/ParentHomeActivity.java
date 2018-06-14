package com.example.shadi.babycare.layout_view;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;

public class ParentHomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_parent_home, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(0).setChecked(true);

        super.setTitle("Home");
    }
}
