package org.bedu.rest.config;

import org.bedu.rest.exception.ContactAlreadyExistsException;
import org.bedu.rest.exception.ContactNotFoundException;
import org.bedu.rest.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ContactNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleNotFound(ContactNotFoundException ex) {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse(ex.getName() + " was not found in agenda"));
  }

  @ExceptionHandler(ContactAlreadyExistsException.class)
  public ResponseEntity<ErrorResponse> handleAlreadyExists() {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse("Contact already exists"));
  }

  @ExceptionHandler(NullPointerException.class)
  public ResponseEntity<ErrorResponse> handleNullPointer() {
    return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body(new ErrorResponse("Something wrong happened..."));
  }
}
