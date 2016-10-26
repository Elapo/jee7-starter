package com.realdolmen.course.domain;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

/**
 * Created by Frederik Van Herbruggen on 18/10/2016.
 */
public class TwitterTest extends JpaPersistenceTest{

    @Test
    public void createDummyEntries(){
        EntityManager em = entityManager();
        Person p = new RegularPerson("Frederik", "Van Herbruggen", "abc123", "email1", new Profile("Young", "Dancing", "Games"), 21);
        Person p2 = new RegularPerson("Benny", "Familie", "abc123", "email2", new Profile("Young", "Dancing", "Games"), 34);
        Person p3 = new VerifiedPerson("Tronald", "Dump", "abc123", "email2", LocalDateTime.now(), 70);
        Person p4 = new VerifiedPerson("Olle", "Ma", "abc123", "email2", LocalDateTime.now(), 354);
        Person p5 = new RegularPerson("Freddy", "Verhaert", "abc123", "email1", new Profile("Young", "Dancing", "Games"), 53);

        Tweet t = new Tweet(p, "Something highly intelligent", new Tag("Smart stuff"));
        Tweet t1 = new Tweet(p2, "Something Weird", new Tag("Weird stuff"));
        Tweet t2 = new Tweet(p3, "Something bigoted, racist and dumb", new Tag("dumb stuff"));
        Tweet t3 = new Tweet(p4, "Some stupid yo mama joke", new Tag("funny joke"));
        Tweet t4 = new Tweet(p5, "Something random", new Tag("Hah"), new Tag("Gaaaaaay"));

        em.persist(t);
        em.persist(t1);
        em.persist(t2);
        em.persist(t3);
        em.persist(t4);
    }

    @Test
    public void testVerifiedPersonPersistence(){
        EntityManager em = entityManager();
        Person p = new VerifiedPerson("Ey", "lemao", "abc", "brool story co", LocalDateTime.now(), 21);
        em.persist(p);
        Assert.assertNotNull(em.find(VerifiedPerson.class, p.getId()));
    }

    @Test
    public void testRegularPersonPersistence(){
        EntityManager em = entityManager();
        Person p = new RegularPerson("Ey", "lemao", "zotpaswoord", "crazyemail", new Profile("OUD", "SINGLE", "OUD", "SINGLE"), 21);
        em.persist(p);
        Assert.assertNotNull(em.find(RegularPerson.class, p.getId()));
    }

    @Test
    public void testTweetPersistence(){
        EntityManager em = entityManager();
        Tweet t = new Tweet(new VerifiedPerson("Fre", "VH", "abc", "ayy", LocalDateTime.now(), 21), "Somemsg", new Tag("swag"));
        em.persist(t);
        Assert.assertEquals("Fre", em.find(Tweet.class, t.getId()).getUser().getFirstName());
    }
}
