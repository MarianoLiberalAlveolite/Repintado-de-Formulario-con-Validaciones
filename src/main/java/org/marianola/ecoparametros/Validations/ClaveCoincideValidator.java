package org.marianola.ecoparametros.Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.marianola.ecoparametros.model.DatosFormulario;

public class ClaveCoincideValidator implements ConstraintValidator<ClaveCoincide, DatosFormulario> {

    @Override
    public boolean isValid(DatosFormulario datosFormulario, ConstraintValidatorContext context) {
        // Verificar si la clave y la confirmación de la clave son iguales
        return datosFormulario.getClave().equals(datosFormulario.getConfirmarClave());
    }
}

