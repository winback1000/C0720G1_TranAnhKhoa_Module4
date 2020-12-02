package com.codegym.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AdultValidator implements ConstraintValidator<Adult,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            LocalDate birthDate = LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
            return birthDate.plusYears(18).isBefore(LocalDate.now());
        }
        catch (Exception e) {
            return false;
        }
    }
}
