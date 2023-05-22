package com.example.webvisit.controller.error.logic;

import com.example.webvisit.controller.error.annotation.CorrectIP;
import com.example.webvisit.controller.error.exception.InvalidIPPatternException;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class CorrectIPValidator implements ConstraintValidator<CorrectIP, String> {

    private static final String IP_ADDRESS_PATTERN =
            "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!Pattern.matches(IP_ADDRESS_PATTERN, value)) {
            throw new InvalidIPPatternException(value);
        }
        return true;
    }
}
