package org.marianola.ecoparametros.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = FechaEdadValidaValidator.class)
@Target(ElementType.TYPE) // Aplica a nivel de clase
@Retention(RetentionPolicy.RUNTIME)
public @interface FechaEdadValida {
    String message() default "{FechaEdadValida.datosFormulario.fechaNacimiento}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}