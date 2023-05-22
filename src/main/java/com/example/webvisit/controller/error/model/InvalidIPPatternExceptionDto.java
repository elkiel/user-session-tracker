package com.example.webvisit.controller.error.model;

import lombok.Value;

@Value
public class InvalidIPPatternExceptionDto {
    private String message;
    private String constraintName;
}

