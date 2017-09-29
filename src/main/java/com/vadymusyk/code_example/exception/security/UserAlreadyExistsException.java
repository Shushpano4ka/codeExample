package com.vadymusyk.code_example.exception.security;

/**
 * Created by vadymusyk on 28.08.17.
 */
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
