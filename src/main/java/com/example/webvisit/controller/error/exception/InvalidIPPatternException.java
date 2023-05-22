package com.example.webvisit.controller.error.exception;

import jakarta.persistence.PersistenceException;
import lombok.Getter;

@Getter
public class InvalidIPPatternException extends PersistenceException {

    private String ip;

    public InvalidIPPatternException(String ip) {
        this.ip = ip;
    }
}
