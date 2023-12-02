package com.rnd.customhandler.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = QuantityValidator.class)
public @interface QuantityValidation {

    String message() default "Invalid field format quantity";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}