package org.marianola.ecoparametros.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ClaveCoincideValidator.class) // Vinculamos al validador
@Target(ElementType.TYPE) // La anotación se aplica a nivel de clase
@Retention(RetentionPolicy.RUNTIME)
public @interface ClaveCoincide {
    String message() default "{ClaveCoincide.datosFormulario.confirmarClave}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}