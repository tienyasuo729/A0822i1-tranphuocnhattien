package com.codegym.demo_a08_spring_boot.utils.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameFormat, String> {
    @Override
    public void initialize(NameFormat constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^[A-Za-z ]{4,50}$");
    }
}
