package com.realdolmen.course.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.util.*;

/**
 * Created by Frederik Van Herbruggen on 17/10/2016.
 */
@Entity
public class Tweet {

    @Id
    private int PK_id;

    @Size(min = 2)
    @NotNull
    private String userName;

    @Past
    @NotNull
    private Date date;

    @Size(max = 140)
    @NotNull
    @NoProfanity
    private String message; //custom: NoProfanity

    @ElementCollection
    @Size(min = 1)
    Set<String> Tags;

    public Tweet(String userName, String message, String... tags) {
        this.date = new Date();
        this.userName = userName;
        this.message = message;
        this.Tags = new TreeSet<>(Arrays.asList(tags));
    }
}
