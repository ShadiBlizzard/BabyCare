package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.shadi.babycare.R;

public class RegistrationokActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrationok);
    }

    public void onParentHome (View view) {
        Intent intent=new Intent(this, ParentHomeActivity.class);
        startActivity(intent);
    }
}