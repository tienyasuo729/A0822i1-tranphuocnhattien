package com.example.demo_module4_spring_boot.utils.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
public @interface NameFormat {
    String message() default "Tên không đúng định dạng";
    Class<?> [] groups() default {};
    Class<? extends Payload>[] payload() default {};
}