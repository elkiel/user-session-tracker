package com.example.webvisit.controller.error;

import com.example.webvisit.controller.error.exception.InvalidIPPatternException;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GlobalExceptionHandlerTest {

    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Test
    void shouldHandleConstraintViolationException() {
        ConstraintViolationException exception = new ConstraintViolationException("A detail message", null, "A " +
                "constraint");
        ResponseEntity responseEntity = exceptionHandler.handleConstraintViolationException(exception);

        assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    void shouldHandleInvalidIPPatternException() {
        InvalidIPPatternException exception = new InvalidIPPatternException("A detail message");
        ResponseEntity responseEntity = exceptionHandler.handleInvalidIPPatternException(exception);

        assertEquals(400, responseEntity.getStatusCodeValue());
    }

    @Test
    void shouldHandleDateTimeParseException() {
        DateTimeParseException exception = new DateTimeParseException("A detail message", "A parsed string", 0);
        ResponseEntity responseEntity = exceptionHandler.handleDateTimeParseException(exception);

        assertEquals(400, responseEntity.getStatusCodeValue());
    }


}
