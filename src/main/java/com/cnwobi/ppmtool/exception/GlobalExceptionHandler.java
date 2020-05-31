package com.cnwobi.ppmtool.exception;

import com.cnwobi.ppmtool.valueObjects.ErrorHolder;
import java.time.Instant;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<?> constraintViolation(ConstraintViolationException ex, WebRequest request){
    ErrorHolder errorHolder = ErrorHolder.builder()
        .timeStamp(Instant.now())
        .message(ex.getMessage())
        .details(request.getDescription(true)).build();
    return new ResponseEntity<>(errorHolder, HttpStatus.BAD_REQUEST);

  }

}
