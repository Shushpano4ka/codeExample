package com.vadymusyk.code_example.validator.phoneNumber;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by vadymusyk on 17.08.17.
 */
@Documented
@Constraint(validatedBy = DepartmentContactNumberListValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DepartmentNumbersConstraint {
    String message() default "Phone Number List must have size > 0 and contains only one MAIN phone number, phoneNumber DTO must contains number min 8 max 14 chars, only figures";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
