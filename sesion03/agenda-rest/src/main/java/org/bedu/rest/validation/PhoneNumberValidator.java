package org.bedu.rest.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return false;
  }
}
