package com.realdolmen;

import com.realdolmen.course.domain.Tweet;
import org.junit.*;

import javax.validation.*;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Locale;
import java.util.Set;

/**
 * Created by Frederik Van Herbruggen on 17/10/2016.
 */
public class TweetTest {
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

    @Test
    public void TweetCantHaveProfanity(){
        Locale.setDefault(new Locale("en", "UK"));
        Tweet t = new Tweet("Jimi", "FUCK SHIT STACK BOIS", "memes");
        Set<ConstraintViolation<Tweet>> violations = valid.validate(t);
        ConstraintViolation<Tweet> error = violations.iterator().next();
        Assert.assertEquals("Swearing is not allowed on here!", error.getMessage());
        System.out.println(violations);
    }

    @Test
    public void TweetMustBeInPast() throws Exception{
        Tweet t = new Tweet("Jimi", "HaiAll", "memes");
        Thread.sleep(1000);
        Set<ConstraintViolation<Tweet>> violations = valid.validate(t);
        Assert.assertEquals(0, violations.size());
        System.out.println(violations);
    }

    @Test
    public void UserNameIsMandatory(){
        Tweet t = new Tweet(null, "HaiAll", "memes");
        Set<ConstraintViolation<Tweet>> violations = valid.validate(t);
        Assert.assertEquals(1, violations.size());
        ConstraintViolation<Tweet> error = violations.iterator().next();
        Assert.assertEquals("may not be null", error.getMessage());
        System.out.println(violations);
    }
}
