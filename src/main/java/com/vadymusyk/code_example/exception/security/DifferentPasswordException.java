package com.vadymusyk.code_example.exception.security;

/**
 * Created by vadymusyk on 14.08.17.
 */
public class DifferentPasswordException extends RuntimeException {
    public DifferentPasswordException() {
    }

    public DifferentPasswordException(String message) {
        super(message);
    }
}
