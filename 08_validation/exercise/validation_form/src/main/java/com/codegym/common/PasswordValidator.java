package com.codegym.common;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      Pattern pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
      Matcher matcher = pattern.matcher(obj);
      return matcher.matches();
   }
}
