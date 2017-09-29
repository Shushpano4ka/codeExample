package com.vadymusyk.code_example.dto.security;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by vadymusyk on 28.08.17.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModeratorActivationDTO {

    @Email
    @NotEmpty
    private String email;
}
