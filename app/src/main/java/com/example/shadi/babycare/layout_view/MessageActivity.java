package com.example.shadi.babycare.layout_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class MessageActivity extends AppCompatActivity {
    private TextView timestamp, sender, text;
    private Button answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        this.setTitle("Message");

        timestamp = findViewById(R.id.timestamp);
        sender = findViewById(R.id.sender);
        text = findViewById(R.id.message_text);
        answer = findViewById(R.id.answer_button);
    }
}
