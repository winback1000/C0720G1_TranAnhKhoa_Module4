package com.codegym.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = AdultValidator.class)
@Target({FIELD})
@Retention(RUNTIME)

public @interface Adult {
    String message() default "The page only accepts adult people";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
