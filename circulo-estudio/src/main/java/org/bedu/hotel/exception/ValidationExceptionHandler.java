package org.bedu.hotel.exception;

import java.util.LinkedList;
import java.util.List;

import org.bedu.hotel.dto.ResponseErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ResponseErrorDTO> handleValidationErrors(MethodArgumentNotValidException ex) {
    /*
     * Versión chafa
     * List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
     * List<String> errors = new LinkedList<>();
     * 
     * for (FieldError fieldError : fieldErrors) {
     * errors.add(fieldError.getDefaultMessage());
     * }
     */

    List<String> errors = ex
        .getBindingResult()
        .getFieldErrors()
        .stream()
        .map(FieldError::getDefaultMessage)
        .toList();

    return ResponseEntity
        .badRequest()
        .body(ResponseErrorDTO
            .builder()
            .error(true)
            .message("Los datos ingresados son inválidos")
            .errors(errors)
            .build());
  }
}
