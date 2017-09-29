package com.vadymusyk.code_example.dto.security;

import com.vadymusyk.code_example.validator.phoneNumber.ContactNumberConstraint;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * Created by vadymusyk on 22.08.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDataDTO {

    @ContactNumberConstraint
    private String phoneNumber;

    @NotNull
    private String name;
}
