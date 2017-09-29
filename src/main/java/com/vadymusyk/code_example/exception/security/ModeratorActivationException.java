package com.vadymusyk.code_example.exception.security;

/**
 * Created by vadymusyk on 28.08.17.
 */
public class ModeratorActivationException extends RuntimeException {

    public ModeratorActivationException() {
    }

    public ModeratorActivationException(String message) {
        super(message);
    }
}
