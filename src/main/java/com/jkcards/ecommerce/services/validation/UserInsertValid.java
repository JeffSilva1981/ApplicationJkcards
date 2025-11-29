package com.jkcards.ecommerce.services.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;




@Constraint(validatedBy = UserInsertValidator.class)//UserInsertValidator -> é a minha classe com tuda a funcionalidade
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)

//classe que servirá como anotação pra verificar email
public @interface UserInsertValid {
    String message() default "Validation error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
