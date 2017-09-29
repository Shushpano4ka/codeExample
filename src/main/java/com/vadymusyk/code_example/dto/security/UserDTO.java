package com.vadymusyk.code_example.dto.security;

import com.vadymusyk.code_example.entity.secutity.Role;
import com.vadymusyk.code_example.validator.password.PasswordConstrains;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Data
@Builder
public class UserDTO {

    @PasswordConstrains
    private String password;

    @NotBlank
    private String token;

    @NotBlank(message = "enter users name")
    private String name;

    @Email(message = "wrong mail construction")
    private String email;

    private String avatarUrl;

    private String phoneNumber;

    private Role role;

    private Boolean active;

    private Long userId;

}
