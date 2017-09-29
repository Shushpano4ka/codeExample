package com.vadymusyk.code_example.exception.security;

/**
 * Created by vadymusyk on 15.08.17.
 */
public class PasswordRecoveryException extends RuntimeException {

    public PasswordRecoveryException() {
    }

    public PasswordRecoveryException(String message) {
        super(message);
    }
}
