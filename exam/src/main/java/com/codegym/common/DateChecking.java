package com.codegym.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateChecking implements ConstraintValidator<CheckDate, String> {


   public boolean isValid(String value, ConstraintValidatorContext context) {
      try {
         LocalDate birthDate = LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
         return birthDate.isAfter(LocalDate.now()) ;
      }
      catch (Exception e) {
         return false;
      }
   }
}
