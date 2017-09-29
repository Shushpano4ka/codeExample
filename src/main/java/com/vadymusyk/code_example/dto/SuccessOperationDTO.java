package com.vadymusyk.code_example.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SuccessOperationDTO {
    private String message;
}
