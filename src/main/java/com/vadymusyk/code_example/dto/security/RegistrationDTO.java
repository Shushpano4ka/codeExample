package com.vadymusyk.code_example.dto.security;

import com.vadymusyk.code_example.entity.registration.ConfirmType;
import lombok.*;

/**
 * Created by vadymusyk on 11.08.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistrationDTO {

    private Long id;
    private String message;
    private ConfirmType confirmType;
}
