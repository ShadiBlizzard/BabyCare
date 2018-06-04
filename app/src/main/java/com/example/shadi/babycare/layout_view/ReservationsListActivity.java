package com.example.shadi.babycare.layout_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import adapters.ReservationAdapter;
import model.Reservation;

public class ReservationsListActivity extends AppCompatActivity {

    private ListView resList;
    private ReservationAdapter resAdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_list);
        resList = findViewById(R.id.res_list);
        listCreation();
    }

    private void listCreation() {
        //temporaneous hardcoding
        ArrayList<Reservation> res = new ArrayList<>();
        res.add(new Reservation("timestamp", "ctr", "status"));
        res.add(new Reservation("timestamp1", "ctr", "status"));
        res.add(new Reservation("timestamp2", "ctr", "status"));
        res.add(new Reservation("timestamp3", "ctr", "status"));
        res.add(new Reservation("timestamp4", "ctr", "status"));
        res.add(new Reservation("timestamp5", "ctr", "status"));

        resAdp = new ReservationAdapter(this, res);
        resList.setAdapter(resAdp);
        resList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO in base all'id si passa alla pagina della singola reservation
            }
        });
    }
}
