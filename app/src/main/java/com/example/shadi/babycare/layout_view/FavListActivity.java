package com.example.shadi.babycare.layout_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.shadi.babycare.R;

import adapters.ProfileAdapter;

public class FavListActivity extends BaseActivity {

    private ListView listView;
    private ProfileAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_fav_list, fl);
        super.setTitle("Favorites");

        listView = findViewById(R.id.favlist);
    }
}
