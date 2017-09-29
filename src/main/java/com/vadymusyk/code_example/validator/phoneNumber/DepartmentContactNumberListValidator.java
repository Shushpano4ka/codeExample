package com.vadymusyk.code_example.validator.phoneNumber;

import com.vadymusyk.code_example.dto.company.PhoneNumberDTO;
import com.vadymusyk.code_example.entity.company.contacts.NumberPriority;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

/**
 * Created by vadymusyk on 17.08.17.
 */
public class DepartmentContactNumberListValidator implements ConstraintValidator<DepartmentNumbersConstraint, List<PhoneNumberDTO>> {

    @Override
    public void initialize(DepartmentNumbersConstraint departmentNumbersConstraint) {

    }

    @Override
    public boolean isValid(List<PhoneNumberDTO> phoneNumbers, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumbers != null && !phoneNumbers.isEmpty() && phoneNumbers.stream()
                .anyMatch(phoneNumberDTO -> phoneNumberDTO.getPriority().equals(NumberPriority.MAIN)) && phoneNumbers.stream()
                .allMatch(phoneNumberDTO -> phoneNumberDTO.getPhoneNumber() != null && phoneNumberDTO.getPhoneNumber().matches("[0-9]+") && phoneNumberDTO.getPhoneNumber().length() > 8
                        && phoneNumberDTO.getPhoneNumber().length() < 14) && checkOnlyOneMainNumber(phoneNumbers);

    }

    private boolean checkOnlyOneMainNumber(List<PhoneNumberDTO> phoneNumbers) {
        int i = 0;
        for (PhoneNumberDTO phoneNumberDTO : phoneNumbers) {
            if (phoneNumberDTO.getPriority().equals(NumberPriority.MAIN)) {
                i++;
            }
        }
        return i == 1;
    }
}
