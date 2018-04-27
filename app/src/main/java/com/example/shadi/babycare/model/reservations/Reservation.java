package com.example.shadi.babycare.model.reservations;

import com.example.shadi.babycare.model.Calendar;
import com.example.shadi.babycare.model.users.Babysitter;
import com.example.shadi.babycare.model.users.Parent;
import com.example.shadi.babycare.model.users.Review;

public class Reservation {

    private int idReservation;
    private StatusRes status;
    private Parent petitioner;
    private Babysitter babysitter;
    private Calendar date;
    private Review optionalReview = null;

    public Reservation(Parent petitioner, Calendar date, Babysitter bs) {
        this.babysitter=bs;
        this.petitioner=petitioner;
        this.date=date;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public StatusRes getStatus() {
        return status;
    }

    public Parent getRequestor() {
        return petitioner;
    }

    public Babysitter getBabysitter() {
        return babysitter;
    }

    public Calendar getDate() {
        return date;
    }

    public Review getOptionalReview() {
        return optionalReview;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setStatus(StatusRes status) {
        this.status = status;
    }
}
