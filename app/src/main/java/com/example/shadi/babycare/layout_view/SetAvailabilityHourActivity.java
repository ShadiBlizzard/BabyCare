package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;

public class SetAvailabilityHourActivity extends BaseActivity {

    private int year, month, day;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_set_availability_hour, fl);

        Intent intent = getIntent();
        year = intent.getIntExtra("year", 0);
        month = intent.getIntExtra("month", 0);
        day = intent.getIntExtra("day", 0);
        send = findViewById(R.id.send_avail);
        //TODO DEVO FINIRE LA GESTIONE DELL'INPUT

        super.setTitle("Choose times");


    }


}
