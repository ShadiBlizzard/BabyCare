package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SetAvailabilityHourActivity extends BaseActivity {

    private int year, month, day;
    private Button send;
    private Map<CheckBox, Boolean> hours = new LinkedHashMap<>();
    private List<CheckBox>predefined = new ArrayList<>();
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

        //checkbox handler
        predefined.add((CheckBox) findViewById(R.id.period_pred1));
        predefined.add((CheckBox) findViewById(R.id.period_pred2));
        predefined.add((CheckBox) findViewById(R.id.period_pred3));
        predefined.add((CheckBox) findViewById(R.id.period_pred4));

        hours.put((CheckBox)findViewById(R.id.period1), false);
        hours.put((CheckBox)findViewById(R.id.period2), false);
        hours.put((CheckBox)findViewById(R.id.period3), false);
        hours.put((CheckBox)findViewById(R.id.period4), false);
        hours.put((CheckBox)findViewById(R.id.period5), false);
        hours.put((CheckBox)findViewById(R.id.period6), false);
        hours.put((CheckBox)findViewById(R.id.period7), false);
        hours.put((CheckBox)findViewById(R.id.period8), false);
        hours.put((CheckBox)findViewById(R.id.period9), false);
        hours.put((CheckBox)findViewById(R.id.period10), false);
        hours.put((CheckBox)findViewById(R.id.period11), false);
        hours.put((CheckBox)findViewById(R.id.period12), false);
        hours.put((CheckBox)findViewById(R.id.period13), false);
        hours.put((CheckBox)findViewById(R.id.period14), false);
        hours.put((CheckBox)findViewById(R.id.period15), false);
        hours.put((CheckBox)findViewById(R.id.period16), false);
        hours.put((CheckBox)findViewById(R.id.period17), false);
        hours.put((CheckBox)findViewById(R.id.period18), false);
        hours.put((CheckBox)findViewById(R.id.period19), false);
        hours.put((CheckBox)findViewById(R.id.period20), false);
        hours.put((CheckBox)findViewById(R.id.period21), false);
        hours.put((CheckBox)findViewById(R.id.period22), false);
        hours.put((CheckBox)findViewById(R.id.period23), false);
        hours.put((CheckBox)findViewById(R.id.period24), false);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                periodHandler();
            }
        });

        super.setTitle("Choose times");


    }

    private void periodHandler() {
        int startingHourPred, endingHourPred;
        List<CheckBox> keyList = new ArrayList<>(hours.keySet());
        //I set the hashmap value to true if the corresponding key checkbox is checked
        for (int i=0; i<hours.size(); i++) {
            CheckBox key = keyList.get(i);
            if(key.isChecked())
                hours.put(key, true);
        }

        //FIRST: I check all the predefined periods
        if (predefined.get(0).isChecked()) {
             sendAvailability(0, 24);
             hours.clear();
        }
        else {
            List<CheckBox> checked = new ArrayList<>();
            for (int i = 1; i<predefined.size(); i++) {
                if (predefined.get(i).isChecked())
                    checked.add(predefined.get(i));
            }

            switch (checked.size()) {
                case 1:
                    if(checked.get(0).getId() == predefined.get(1).getId()) {
                        startingHourPred = 8;
                        endingHourPred = 13;
                        //I set the hashmap values to false if they correspond to the same period as above
                        for (int i=8; i<13; i++) {
                            CheckBox key = keyList.get(i);
                            hours.put(key, false);
                        }
                    }
                    else if(checked.get(0).getId() == predefined.get(2).getId()) {
                        startingHourPred = 13;
                        endingHourPred = 18;
                        //I set the hashmap values to false if they correspond to the same period as above
                        for (int i=13; i<18; i++) {
                            CheckBox key = keyList.get(i);
                            hours.put(key, false);
                        }
                    }
                    else {
                        startingHourPred = 18;
                        endingHourPred= 24;
                        //I set the hashmap values to false if they correspond to the same period as above
                        for (int i=18; i<24; i++) {
                            CheckBox key = keyList.get(i);
                            hours.put(key, false);
                        }
                    }

                    break;
                case 2:
                    //if the user select morning and evening, I have to create two distinct availabilities
                    if (checked.get(0).getId() == predefined.get(1).getId() && checked.get(1).getId() == predefined.get(3).getId()) {
                        sendAvailability(8, 13);
                        sendAvailability(18, 24);
                    }
                    //hours are in order, so if the first is morning, and we are not in the case above, the second
                    //is afternoon
                    else if(checked.get(0).getId() == predefined.get(1).getId()) {
                        sendAvailability(8, 18);
                    }
                    //afternoon-evening case
                    else
                        sendAvailability(13, 24);
                    break;
                    //foolproof case
                case 3:
                    sendAvailability(0, 24);
                    //I do not need to check single checkbox
                    hours.clear();
                    break;
                default:
                    break;
            }

            //SECOND: I check all the hourly periods

            //now I cast two temporary values for periods
            int tempStart = -1, tempEnd;
            for (int i = 0; i<hours.size(); i++) {
                //initialize the period, I start from the first checked checkbox
                if(hours.get(keyList.get(i))) {
                    if(tempStart==-1)
                        tempStart = i;
                    //if it is checked and I'm not in the last checkbox
                    if(i<hours.size()-1) {
                        //if the following checkbox is checked, update the end time to that of the following
                        if (!hours.get(keyList.get(i + 1))) {
                            tempEnd = i + 1;
                            sendAvailability(tempStart, tempEnd);
                            tempStart = -1;
                        }
                    }
                    //if I'm in the last, no need to perform other checkings
                    else {
                        tempEnd = i+1;
                        sendAvailability(tempStart, tempEnd);
                    }

                }
            }


        }

    }

    private void sendAvailability(int start, int end) {
        //TODO DEVO FINIRE LA GESTIONE DELL'INPUT
    }

}
