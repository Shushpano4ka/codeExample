package com.vadymusyk.code_example.exception.functional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFullDepartmentInfoException extends RuntimeException {

    private String reason;
    private String message;

    public NotFullDepartmentInfoException() {
    }

    public NotFullDepartmentInfoException(String reason, String message) {
        this.reason = reason;
        this.message = message;
    }
}
