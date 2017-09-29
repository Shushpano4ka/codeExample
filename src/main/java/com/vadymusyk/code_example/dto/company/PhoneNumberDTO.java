package com.vadymusyk.code_example.dto.company;

import com.vadymusyk.code_example.entity.company.contacts.NumberPriority;
import com.vadymusyk.code_example.validator.phoneNumber.ContactNumberConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vadymusyk on 11.08.17.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumberDTO {

    private NumberPriority priority;

    @ContactNumberConstraint
    private String phoneNumber;
}
