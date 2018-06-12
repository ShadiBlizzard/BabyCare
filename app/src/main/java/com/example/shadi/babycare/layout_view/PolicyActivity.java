package com.example.shadi.babycare.layout_view;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class PolicyActivity extends BaseActivity {

    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_policy, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(R.id.nav_policy).setChecked(true);

        this.setTitle("Policy");
        text = findViewById(R.id.policy);
    }
}
