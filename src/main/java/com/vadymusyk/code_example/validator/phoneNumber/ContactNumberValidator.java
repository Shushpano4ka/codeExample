package com.vadymusyk.code_example.validator.phoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vadymusyk on 15.08.17.
 */
public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String> {

    @Override
    public void initialize(ContactNumberConstraint contactNumberConstraint) {

    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext ctx) {
        return contactField != null && contactField.matches("[0-9]+") && contactField.length() > 8
                && contactField.length() < 14;
    }

}
