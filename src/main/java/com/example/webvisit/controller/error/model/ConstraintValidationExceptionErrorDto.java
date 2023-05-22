package com.example.webvisit.controller.error.model;

import lombok.Value;

@Value
public class ConstraintValidationExceptionErrorDto {
    private String message;
    private String constraintName;
}
