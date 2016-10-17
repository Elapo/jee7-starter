package com.realdolmen.course.repository;

import com.realdolmen.course.domain.Profane;
import com.realdolmen.course.service.FortuneSupplier;
import javax.inject.Inject;

/**
 * Created by Frederik Van Herbruggen on 14/10/2016.
 */
@Profane
public class ProfanityFortuneRepository implements FortuneSupplier {

    String[] fortunes; //Default scope is best, so tests can access it. Protected is a tad too open

    @Inject
    public ProfanityFortuneRepository(@Profane String[] messages) {
        this.fortunes = messages;
    }


    @Override
    public String[] getFortunes() {
        return fortunes;
    }

}
