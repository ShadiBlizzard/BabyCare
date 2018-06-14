package com.example.shadi.babycare.layout_view;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class MessageActivity extends BaseActivity {
    private TextView timestamp, sender, text;
    private Button answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_message, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(1).setChecked(true);
        super.setTitle("Message");

        timestamp = findViewById(R.id.timestamp);
        sender = findViewById(R.id.sender);
        text = findViewById(R.id.message_text);
        answer = findViewById(R.id.answer_button);
    }
}
