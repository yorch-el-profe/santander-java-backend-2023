package org.bedu.rest.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    Pattern pattern = Pattern.compile("(^\\d{8,10})$");
    Matcher matcher = pattern.matcher(value);
    return matcher.matches();
  }
}
