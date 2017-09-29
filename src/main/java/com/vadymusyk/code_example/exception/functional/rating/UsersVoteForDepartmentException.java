package com.vadymusyk.code_example.exception.functional.rating;

public class UsersVoteForDepartmentException extends RuntimeException {
    public UsersVoteForDepartmentException() {
        super();
    }

    public UsersVoteForDepartmentException(String message) {
        super(message);
    }
}
