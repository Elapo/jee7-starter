package com.realdolmen.course.service;

import java.util.Random;

/**
 * Created by Frederik Van Herbruggen on 14/10/2016.
 */
public interface FortuneSupplier {
    public String[] getFortunes();

    public default String getFortune(){
        Random rng = new Random(); //can also be done using abstract class, as random is created twice
        String[] fortunes = getFortunes();
        return fortunes[rng.nextInt(fortunes.length)];
    }
}
