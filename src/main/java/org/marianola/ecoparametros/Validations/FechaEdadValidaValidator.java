package org.marianola.ecoparametros.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.marianola.ecoparametros.model.DatosFormulario;

import java.time.LocalDate;
import java.time.Period;

public class FechaEdadValidaValidator implements ConstraintValidator<FechaEdadValida, DatosFormulario> {

    @Override
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext context) {
        // Verifica que los campos no sean nulos
        if (datosFormulario.getFechaNacimiento() == null || datosFormulario.getEdad() == null) {
            return true; // Otros @NotNull se encargan de esto
        }

        LocalDate fechaNacimiento = datosFormulario.getFechaNacimiento();
        Integer edad = datosFormulario.getEdad();

        // Calcula la edad según la fecha de nacimiento
        int edadCalculada = Period.between(fechaNacimiento, LocalDate.now()).getYears();

        // Devuelve si la edad coincide con la calculada
        return edadCalculada == edad;
    }
}
