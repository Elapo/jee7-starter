package com.realdolmen.course.service;

import com.realdolmen.course.domain.Profane;
import com.realdolmen.course.domain.Prude;

import javax.inject.Inject;

/**
 * Created by Frederik Van Herbruggen on 14/10/2016.
 */
public class FortuneCookieService {
    @Inject
    @Prude
    FortuneSupplier f;

    public String crack(){
        //process message in some way
        return f.getFortune();
    }
}
