package com.example.shadi.babycare.layout_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import adapters.MessageAdapter;
import model.Message;

public class MessagesActivity extends AppCompatActivity {

    private ListView listView;
    private MessageAdapter msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);
        listView = findViewById(R.id.msg_list);
        listCreation();
    }

    public void listCreation () {
        //temporaneous hardcoding
        ArrayList<Message> obj = new ArrayList<>();
        obj.add(new Message("", "sender1", "timestamp1"));
        obj.add(new Message("", "sender2", "timestamp2"));
        obj.add(new Message("", "sender3", "timestamp3"));
        obj.add(new Message("", "sender4", "timestamp4"));
        obj.add(new Message("", "sender5", "timestamp5"));
        obj.add(new Message("", "sender6", "timestamp6"));
        obj.add(new Message("", "sender7", "timestamp7"));

        msg = new MessageAdapter(this, obj );
        listView.setAdapter(msg);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO when the user clicks an item, we will open the message activity and
                //populate it with message data
            }
        });
    }
}
