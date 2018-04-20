package com.example.shadi.babycare.model;

import com.example.shadi.babycare.model.reservations.Message;
import com.example.shadi.babycare.model.reservations.Reservation;
import com.example.shadi.babycare.model.users.Babysitter;
import com.example.shadi.babycare.model.users.Parent;

import java.util.ArrayList;
import java.util.List;

/**
 * The model related to the parent that is launched when
 * the controller recognize a parent in the login
 */
public class ModelParents extends Model {
    private Parent parent;
    private List<Reservation> reservations = new ArrayList<>();

    //It will be implemented in local as a trivial name list
    private List<Babysitter> favorites = new ArrayList<>();
    private List<Message> messages = new ArrayList<>();

    /**
     * When the constructor of ModelParents is called, there will be
     * a database query (clearly on the server) that will retrieve all
     * the users data.
     * It is called by the controller, and it will have as parameter
     * the parent profile
     */
    public ModelParents(Parent parent) {
        this.parent=parent;
        //TODO here all the db calls, but for now I will do hardcoding
        dataRetriever();
    }

    public void dataRetriever() {
        //TEMPORANEUS HARDCODING***
        this.favorites.add(new Babysitter("Sbiribillo", "Volante", 26));
        this.messages.add(new Message("sbirib"));


    }




}
