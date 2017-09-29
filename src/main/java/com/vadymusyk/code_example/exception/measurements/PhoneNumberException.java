package com.vadymusyk.code_example.exception.measurements;

/**
 * Created by vadymusyk on 18.08.17.
 */
public class PhoneNumberException extends RuntimeException {

    public PhoneNumberException() {
    }

    public PhoneNumberException(String message) {
        super(message);
    }
}
