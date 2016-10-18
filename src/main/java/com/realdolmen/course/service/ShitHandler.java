package com.realdolmen.course.service;

import com.realdolmen.course.domain.ShitHappened;

import javax.enterprise.event.Observes;

/**
 * Created by Frederik Van Herbruggen on 17/10/2016.
 */
public class ShitHandler {

    @ShitHappened
    private void handleShit(@Observes @ShitHappened String shitSentence){
        System.out.println(shitSentence);
    }
}
