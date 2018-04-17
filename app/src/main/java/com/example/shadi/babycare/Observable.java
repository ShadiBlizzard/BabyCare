package com.example.shadi.babycare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class Observable <C> {

    private List<Observer<C>> observers= new ArrayList<>();


    /**
     * it registers a new observer
     * @param o
     */
    public void registerObserver(Observer<C> o) {

        this.observers.add(o);
    }

    /**
     * it remove an observer
     * @param o
     */
    public void unregisterObserver(Observer<C> o) {

        this.observers.remove(o);
    }

    /**
     * it notifies the observers
     * @param c
     * @throws IOException
     */
    public void notifyObserver(C c) throws IOException {
        if(!this.observers.isEmpty()) {
            for (Observer<C> o : this.observers) {
                o.update(c);
            }
        }

    }

    /**
     * @return the observers
     */
    public List<Observer<C>> getObservers() {
        return observers;
    }

}
