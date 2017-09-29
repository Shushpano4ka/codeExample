package com.vadymusyk.code_example.validator.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by vadymusyk on 15.08.17.
 */

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConstrains {
    String message() default "password must contain minimum 6 chars, min 1 Uppercase б. 1 lowercase letter and min 1 number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
