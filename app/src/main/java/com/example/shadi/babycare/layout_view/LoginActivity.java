package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

import com.example.shadi.babycare.R;

public class LoginActivity extends AppCompatActivity {

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActionBar().setTitle("Login");
    }

    public void login(View view) {
        //TODO verifico che cosa sia il client che fa il login, in base a quello lo reindirizzo alla home dedicata
    }
}
