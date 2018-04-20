package com.example.shadi.babycare;
import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.IOException;

public interface Observer <C> {
    /**
     * it updates something in the game
     * @param o
     * @throws IOException
     */
    public void update(C o) throws IOException;

}


