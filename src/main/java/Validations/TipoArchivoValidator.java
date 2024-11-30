package Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public class TipoArchivoValidator implements ConstraintValidator<TipoArchivo, MultipartFile> {

    // Lista de tipos MIME permitidos
    private static final List<String> TIPOS_PERMITIDOS = Arrays.asList(
            "application/pdf",
            "image/jpeg",
            "image/jpg",
            "image/gif"
    );

    @Override
    public boolean isValid(MultipartFile archivo, ConstraintValidatorContext context) {
        if (archivo == null || archivo.isEmpty()) {
            return true; // Permitir archivos nulos o vacíos; otro validador puede validar esto si es obligatorio
        }
        return TIPOS_PERMITIDOS.contains(archivo.getContentType());
    }
}
