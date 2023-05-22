package com.example.webvisit.controller.error;

import com.example.webvisit.controller.error.exception.InvalidIPPatternException;
import com.example.webvisit.controller.error.model.ConstraintValidationExceptionErrorDto;
import com.example.webvisit.controller.error.model.InvalidIPPatternExceptionDto;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleConstraintViolationException(ConstraintViolationException exc) {
        return ResponseEntity.badRequest().body(new ConstraintValidationExceptionErrorDto("Database constraint has " +
                "been violated", exc.getConstraintName()));
    }

    @ExceptionHandler(InvalidIPPatternException.class)
    public ResponseEntity handleInvalidIPPatternException(InvalidIPPatternException exc) {
        return ResponseEntity.badRequest().body(new InvalidIPPatternExceptionDto("IP address constraint has been " +
                "violated", exc.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlePastDateException(MethodArgumentNotValidException exc) {
        return ResponseEntity.badRequest().body(new ConstraintValidationExceptionErrorDto("The date must be in the " +
                "past or current", exc.getMessage()));
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity handleDateTimeParseException(DateTimeParseException exc) {
        return ResponseEntity.badRequest().body(new ConstraintValidationExceptionErrorDto("Invalid data format.",
                exc.getMessage()));
    }

}
