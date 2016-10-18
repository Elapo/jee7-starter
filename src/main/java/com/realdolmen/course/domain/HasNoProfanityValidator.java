package com.realdolmen.course.domain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Frederik Van Herbruggen on 17/10/2016.
 */
public class HasNoProfanityValidator implements ConstraintValidator<NoProfanity, String>{

    @Override
    public void initialize(NoProfanity constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        value = value.toLowerCase();
        return !value.contains("shit") || !value.contains("fuck");
    }
}
