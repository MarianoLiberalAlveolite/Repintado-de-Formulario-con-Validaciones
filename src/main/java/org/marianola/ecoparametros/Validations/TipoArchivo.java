package org.marianola.ecoparametros.Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TipoArchivoValidator.class) // Vincula con el validador
@Target(ElementType.FIELD) // Se aplica a nivel de campo
@Retention(RetentionPolicy.RUNTIME) // Se mantiene en tiempo de ejecución
public @interface TipoArchivo {
    String message() default "{TipoArchivo.datosFormulario.archivo}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
