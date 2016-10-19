package com.realdolmen.course.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Frederik Van Herbruggen on 18/10/2016.
 */
@Entity
@Table(name = "tblTag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "Tags", cascade=CascadeType.ALL)
    List<Tweet> tweets;

    public Tag(){

    }

    public Tag(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected List<Tweet> getTweets() {
        return Collections.unmodifiableList(tweets);
    }
}
