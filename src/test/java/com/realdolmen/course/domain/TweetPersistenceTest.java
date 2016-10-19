package com.realdolmen.course.domain;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by Frederik Van Herbruggen on 18/10/2016.
 */
public class TweetPersistenceTest extends JpaPersistenceTest {

    private ValidatorFactory fact;
    private Validator valid;

    @Before
    public void initValidator(){
        fact = Validation.buildDefaultValidatorFactory();
        valid = fact.getValidator();
    }

    @After
    public void destroyValidator(){
        fact.close();
    }
    /*@Test
    public void canGetTweets(){
        EntityManager em = entityManager();
        Tweet t = em.find(Tweet.class, 1000);
        Assert.assertNotNull(t);
        Assert.assertEquals("Jimi", t.getUserName());
        Assert.assertEquals("ayy, lmao", t.getMessage());
    }

    @Test
    public void tweetCanBePersisted(){
        EntityManager em = entityManager();
        Tweet t = new Tweet("Amy", "Sheldon is the best!", "bbt");
        em.persist(t);
        Assert.assertNotNull(t.getId());
    }

    @Test
    public void tagsArePersistent(){
        EntityManager em = entityManager();
        Tweet t = new Tweet("test", "taggy", "a tag", "another tag");
        em.persist(t);
        Tweet tweetFromDB = em.find(Tweet.class, t.getId());
        Assert.assertNotNull(tweetFromDB.getTags());
        Assert.assertArrayEquals(new String[]{"a tag", "another tag"}, tweetFromDB.getTags());
    }

    @Test
    public void statusIsPersistent(){
        EntityManager em = entityManager();
        Tweet t = new Tweet("test", "taggy", "tagtag");
        t.setStatus(Status.INACTIVE);
        em.persist(t);
        Assert.assertNotNull(t.getId());
        Tweet tweetFromDB = em.find(Tweet.class, t.getId());
        Assert.assertEquals(Status.INACTIVE, tweetFromDB.getStatus());
    }

    @Test
    public void dateIsPersistent(){
        EntityManager em = entityManager();
        Tweet t = new Tweet("test", "taggy", "tagtag");
        LocalDateTime date = LocalDateTime.now();
        t.setDate(date);
        em.persist(t);
        Tweet tweetFromDB = em.find(Tweet.class, t.getId());
        Assert.assertEquals(date, tweetFromDB.getDate());
    }

    @Test
    public void dateCannotBeInFuture(){
        EntityManager em = entityManager();
        Tweet t = new Tweet("test", "taggy", "tagtag");
        LocalDateTime date = LocalDateTime.of(2018,10,26,0,0);
        t.setDate(date);
        Set<ConstraintViolation<Tweet>> violations = valid.validate(t);
        System.out.println(t.getDate());
        System.out.println(t.getOldDate());
        System.out.println(violations);
     }*/
}
