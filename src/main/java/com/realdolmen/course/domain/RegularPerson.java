package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Frederik Van Herbruggen on 19/10/2016.
 */
@Entity
@Table(name = "tblRegularPerson")
public class RegularPerson extends Person {
    private Profile profile;

    protected RegularPerson() {
    }

    public RegularPerson(String firstName, String lastName, String password, String email, Profile profile, int age) {
        super(firstName, lastName, password, email, age);
        this.profile = profile;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
