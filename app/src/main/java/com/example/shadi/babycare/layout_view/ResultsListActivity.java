package com.example.shadi.babycare.layout_view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import adapters.ProfileAdapter;
import model.ProfileBs;

public class ResultsListActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO backend call, profile call per babysitter disponibili che poi verranno aggiunte come pins alla mappa
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_results_list, fl);

        super.setTitle("Results");

        //map setting
        MapsFragment mf = new MapsFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.map_container, mf).commit();
    }


}