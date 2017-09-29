package com.vadymusyk.code_example.validator.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by vadymusyk on 15.08.17.
 */
public class PasswordValidator implements ConstraintValidator<PasswordConstrains, String> {

    @Override
    public void initialize(PasswordConstrains passwordConstrains) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password != null && password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$");
    }
}
