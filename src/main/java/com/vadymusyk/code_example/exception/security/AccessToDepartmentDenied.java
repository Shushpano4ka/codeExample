package com.vadymusyk.code_example.exception.security;

/**
 * Created by vadymusyk on 17.08.17.
 */
public class AccessToDepartmentDenied extends RuntimeException {

    public AccessToDepartmentDenied() {
    }

    public AccessToDepartmentDenied(String message) {
        super(message);
    }
}
