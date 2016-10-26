package com.realdolmen.course.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Frederik Van Herbruggen on 19/10/2016.
 */
@Entity
@Table(name = "tblVerifiedPerson")
public class VerifiedPerson extends Person {
    private LocalDateTime verificationDate;
    private Date oldDate;
    private int verificationId;
    private String creditCard;

    protected VerifiedPerson(){

    }

    public VerifiedPerson(String firstName, String lastName, String password, String email, LocalDateTime verificationDate, int age) {
        super(firstName, lastName, password, email, age);
        this.verificationDate = verificationDate;
    }

    public LocalDateTime getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(LocalDateTime verificationDate) {
        this.verificationDate = verificationDate;
    }

    public int getVerificationId() {
        return verificationId;
    }

    public void setVerificationId(int verificationId) {
        this.verificationId = verificationId;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
}
