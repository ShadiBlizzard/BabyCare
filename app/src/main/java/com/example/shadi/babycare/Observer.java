package com.example.shadi.babycare;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.IOException;

public abstract class Observer <C> {
    /**
     * it updates something in the game
     * @param o
     * @throws IOException
     */
    public void update(C o) throws IOException {
        if(o!=null)
            System.out.println("I am the" + this.getClass().getSimpleName() +
                    " I have been notified with the "+o.getClass().getSimpleName());
    }

}
