package com.vadymusyk.code_example.exception.functional;

/**
 * Created by vadymusyk on 18.08.17.
 */
public class CategoryAppropriationException extends RuntimeException {

    public CategoryAppropriationException() {
    }

    public CategoryAppropriationException(String message) {
        super(message);
    }
}
