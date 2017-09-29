package com.vadymusyk.code_example.exception.security;

/**
 * Created by vadymusyk on 15.08.17.
 */
public class TokenExpiredException extends RuntimeException {

    public TokenExpiredException() {
    }

    public TokenExpiredException(String message) {
        super(message);
    }
}
