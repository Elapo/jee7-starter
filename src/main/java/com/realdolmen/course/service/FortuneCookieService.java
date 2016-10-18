package com.realdolmen.course.service;

import com.realdolmen.course.domain.Profane;
import com.realdolmen.course.domain.ShitHappened;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Frederik Van Herbruggen on 14/10/2016.
 */
@Named("MyFortuneService")
public class FortuneCookieService {
    @Inject
    @Profane
    FortuneSupplier f;

    @Inject
    @ShitHappened
    private Event<String> onShit;

    public String crack(){
        //process message in some way
        String msg = f.getFortune();
        if(msg.toLowerCase().contains("shit")) onShit.fire(msg);
        return msg;
    }

}
