package com.vadymusyk.code_example.exception.security;

public class UserRegistrationException extends RuntimeException {

    public UserRegistrationException() {
    }

    public UserRegistrationException(String message) {
        super(message);
    }
}
