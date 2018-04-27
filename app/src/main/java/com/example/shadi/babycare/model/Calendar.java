package com.example.shadi.babycare.model;

import java.sql.Time;
import java.util.Date;

public class Calendar {

    private Date date;
    private Time time;

    public Calendar(Date date, Time time) {
        this.date=date;
        this.time=time;

    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }
}