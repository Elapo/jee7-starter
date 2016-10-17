package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Profane;
import com.realdolmen.course.domain.Prude;
import com.realdolmen.course.service.FortuneSupplier;

import java.util.Random;

/**
 * Created by Frederik Van Herbruggen on 14/10/2016.
 */
@Prude
public class FortuneRepository implements FortuneSupplier {
    private String[] fortunes = {"A book is like a garden carried in the pocket.",
                                "Be not afraid of growing slowly, be afraid only of standing still.",
                                "Better to light a candle than to curse the darkness.",
                                "Do not want others to know what you have done? Better not have done it anyways.",
                                "A bird does not sing because it has an answer. It sings because it has a song."};

    @Override
    public String[] getFortunes() {
        return fortunes;
    }

    /*public String getFortune(){
        Random rng = new Random(); //can also be done using abstract class or default methods in interface, as random is created twice otherwise
        return fortunes[rng.nextInt(fortunes.length)];
    }*/
}
