package model;

import Validations.DireccionIp;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DatosFormulario {

    /* DATOS DE USUARIO */

    @NotBlank
    private String usuario;

    @NotBlank(message = "{formulario.clave.notblank}")
    @Size(min = 6, max = 12)
    private String clave;

    @NotBlank(message = "{formulario.clave.notblank}")
    @Size(min = 6, max = 12)
    private String confirmacionClave;

    /* DATOS PERSONALES */

    @NotNull
    private String generoSeleccionado;

    @NotNull
    private String paisSeleccionado;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message ="{formulario.fechaNacimiento.past}")
    private LocalDate fechaNacimiento;

    @Min(18)
    @Max(67)
    private Integer edad;

    @Digits(integer = 3, fraction = 2)
    private Float peso;

    /* DATOS DE CONTACTO */

    @NotNull
    private String prefijo;

    @NotNull
    private String telefono;

    @Email (message="{formulario.email.valido}")
    private String email;

    @DireccionIp
    private String direccionIp;

    /* DATOS DE INTERÉS */

    @NotNull
    private List<String> Aficiones;

    @NotNull
    private List<String> Musica;

    private String comentarios;

    @NotNull
    private boolean licencia;
}
