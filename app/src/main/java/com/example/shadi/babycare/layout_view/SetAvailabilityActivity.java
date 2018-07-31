package com.example.shadi.babycare.layout_view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.CalendarView;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;

public class SetAvailabilityActivity extends BaseActivity {

    private CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_set_availability, fl);
        super.setTitle("Add availability");

        calendar = findViewById(R.id.set_calendar);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                Intent chosenDate = new Intent(getApplicationContext(), SetAvailabilityHourActivity.class);
                chosenDate.putExtra("year", year);
                chosenDate.putExtra("month", month);
                chosenDate.putExtra("day", day);

                startActivity(chosenDate);
                //TODO qui è necessaria una comunicazione col backend, di modo che l'activity
                //per scegliere le ore abbia le fasce orarie già checkate nel caso sia già stata impostata

            }
        });

    }
}
