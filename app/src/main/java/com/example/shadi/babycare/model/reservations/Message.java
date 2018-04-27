package com.example.shadi.babycare.model.reservations;
import com.example.shadi.babycare.model.users.User;

public class Message {
    private String text;
    private User sender;
    private User receiver;

    public Message(String msg, User sender, User receiver){
        this.text=msg;
        this.sender=sender;
        this.receiver=receiver;
    }

    public String getText() {
        return text;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }
}