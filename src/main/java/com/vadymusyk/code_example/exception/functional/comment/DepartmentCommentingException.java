package com.vadymusyk.code_example.exception.functional.comment;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentCommentingException extends RuntimeException {

    private String reason;
    private String message;

    public DepartmentCommentingException() {
        super();
    }

    public DepartmentCommentingException(String reason, String message) {
        this.reason = reason;
        this.message = message;
    }
}
