package com.vadymusyk.code_example.exception.measurements;

/**
 * Created by vadymusyk on 16.08.17.
 */
public class DataValidationException extends RuntimeException {

    public DataValidationException() {
    }

    public DataValidationException(String message) {
        super(message);
    }
}
