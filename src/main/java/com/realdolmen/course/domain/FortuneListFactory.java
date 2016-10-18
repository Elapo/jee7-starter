package com.realdolmen.course.domain;

import javax.enterprise.inject.Produces;
import java.io.Serializable;

/**
 * Created by Frederik Van Herbruggen on 14/10/2016.
 */
public class FortuneListFactory implements Serializable {
    /*private String[] rude = {"A man who fishes in another man’s hole will often catch crabs.",
            "A foolish man gives his wife a grand piano, a wise man gives his wife an upright organ.",
            "Passionate kiss, like spider web, lead to undoing of fly.",
            "Man who keep feet firmly on ground have trouble putting on pants.",
            "Boy who go to sleep with hard problem wake up with solution in hand."};
            */
    private String[] rude = {
            "shit"
    };

    @Produces
    @Profane
    public String[] getRude(){
        return rude;
    }

}
