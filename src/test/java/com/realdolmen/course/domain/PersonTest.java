package com.realdolmen.course.domain;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PersonTest {
    @Test
    public void nameReturnsConcatenationOfFirstNameAndLastName() throws Exception {
        assertEquals("George Orwell", new VerifiedPerson("George", "Orwell", "pass", "mail", LocalDateTime.now(), 21).name());
    }

    @Test
    public void personIsInstantiatedWithNullId() throws Exception {
        assertNull("Person ID is supposed to be null before saving", new VerifiedPerson("Paul", "McCartney", "pass", "mail", LocalDateTime.now(), 21).getId());
    }
}
