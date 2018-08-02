package com.example.shadi.babycare.layout_view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.CalendarView;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

public class SetAvailabilityActivity extends BaseActivity {

    private MaterialCalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_set_availability, fl);
        super.setTitle("Add availability");

        calendar = findViewById(R.id.set_calendar);

        calendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected( MaterialCalendarView materialCalendarView, CalendarDay calendarDay, boolean b) {
                Intent chosenDate = new Intent(getApplicationContext(), SetAvailabilityHourActivity.class);

                chosenDate.putExtra("year", calendarDay.getYear());
                chosenDate.putExtra("month", calendarDay.getMonth());
                chosenDate.putExtra("day", calendarDay.getDay());

                startActivity(chosenDate);
                //TODO qui è necessaria una comunicazione col backend, di modo che l'activity
                //per scegliere le ore abbia le fasce orarie già checkate nel caso sia già stata impostata
            }
        });

    }
}
