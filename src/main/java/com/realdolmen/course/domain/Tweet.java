package com.realdolmen.course.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Entity
@Table(name = "tblTweet")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK_id")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_Person_Id")
    private Person user;

    @NotNull
    private LocalDateTime date;

    @Transient
    @Past
    private Date oldDate;

    @Size(max = 140)
    @NotNull
    @NoProfanity
    private String message; //custom: NoProfanity

    @ManyToMany(cascade=CascadeType.ALL)
    List<Tag> Tags;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    protected Tweet(){ //Protected to keep people from using this, used by JPA

    }

    public Tweet(Person user, String message, Tag... tags) {
        this.date = LocalDateTime.now();
        this.oldDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
        this.user = user;

        this.message = message;
        this.Tags = Arrays.asList(tags);
        this.status = Status.ACTIVE;
    }
    public Person getUser() {
        return user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
        this.oldDate = Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Tag[] getTags() {
        return Tags.toArray(new Tag[Tags.size()]);
    }


    public Integer getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getOldDate(){ return this.oldDate;}

    public void setUser(Person user) {
        this.user = user;
    }

    public void addTags(Tag tag) {
        Tags.add(tag);
    }
}
