package com.vadymusyk.code_example.dto.security;

import com.vadymusyk.code_example.validator.phoneNumber.ContactNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vadymusyk on 15.08.17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    @ContactNumberConstraint
    private String phoneNumber;
}
