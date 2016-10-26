package com.realdolmen.course.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Frederik Van Herbruggen on 19/10/2016.
 */
@Embeddable
public class Profile {
    private String ageCategory;

    @ElementCollection
    private List<String> interests;
    private String maritalState;

    public Profile() {
    }

    public Profile(String ageCategory, String maritalState, String... interests) {
        this.ageCategory = ageCategory;
        this.interests = Arrays.asList(interests);
        this.maritalState = maritalState;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public String getMaritalState() {
        return maritalState;
    }

    public void setMaritalState(String maritalState) {
        this.maritalState = maritalState;
    }
}
