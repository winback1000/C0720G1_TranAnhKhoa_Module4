package com.furama.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.PositiveOrZero;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.CLASS;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = CheckDuration.class)
public @interface ValidDuration {

    String message() default "The duration is invalid, end date must be after start date";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
