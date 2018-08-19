package com.example.shadi.babycare.layout_view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import adapters.ProfileAdapter;
import model.ProfileBs;

public class ResultsListActivity extends BaseActivity {

    private ListView listView;
    private ProfileAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO backend call, profile call per babysitter disponibili
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_results_list, fl);

        super.setTitle("Results");

        listView = findViewById(R.id.resultsList);
        listCreation();
    }

    private void listCreation() {
        ArrayList<ProfileBs> bs= new ArrayList<>();

        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));
        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));
        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));
        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));
        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));
        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));
        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));
        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));
        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));
        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));
        bs.add(new ProfileBs("Name", "Surname", "pic", 0.5f));


        adapter = new ProfileAdapter(this, bs);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO backend call per dettagli profilo
            }
        });

    }
}
