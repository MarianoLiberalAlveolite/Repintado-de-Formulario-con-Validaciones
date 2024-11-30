package Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailValidoValidator.class) // Vinculamos al validador
@Target(ElementType.FIELD) // Se aplica a nivel de campo
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailValido {
    String message() default "El correo electrónico no tiene un formato válido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
