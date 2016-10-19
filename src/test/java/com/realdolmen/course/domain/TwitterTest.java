package com.realdolmen.course.domain;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;
import org.junit.Test;

import javax.persistence.EntityManager;

/**
 * Created by Frederik Van Herbruggen on 18/10/2016.
 */
public class TwitterTest extends JpaPersistenceTest{

    @Test
    public void testTwitterPersistence(){
        EntityManager em = entityManager();
        Tweet t = new Tweet(new Person("Fre", "VH", "abc", "ayy"), "Somemsg", new Tag("swag"));
        em.persist(t);
    }
}
