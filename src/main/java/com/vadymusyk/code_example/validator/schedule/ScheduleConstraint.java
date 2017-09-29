package com.vadymusyk.code_example.validator.schedule;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ConstraintScheduleValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ScheduleConstraint {
    String message() default "invalid schedule format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
