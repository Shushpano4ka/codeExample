package com.vadymusyk.code_example.dto.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * Created by vadymusyk on 14.08.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionDTO {

    private HttpStatus status;
    private String message, reason;
}
