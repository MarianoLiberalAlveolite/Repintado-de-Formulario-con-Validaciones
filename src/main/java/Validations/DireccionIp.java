package Validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;


@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = DireccionIpValidator.class)
@Documented
public @interface DireccionIp {

    String message() default "{DireccionIp.invalida}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}