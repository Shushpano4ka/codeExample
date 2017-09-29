package com.vadymusyk.code_example.dto.security;

import com.vadymusyk.code_example.validator.password.PasswordConstrains;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

/**
 * Created by vadymusyk on 14.08.17.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecoveryPasswordDTO {

    @PasswordConstrains
    private String newPassword, newPasswordDuplicate;

    @Email
    private String mail;

    private String token;

}
