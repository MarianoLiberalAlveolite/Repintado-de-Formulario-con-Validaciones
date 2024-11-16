package model;

import Validations.DireccionIp;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DatosFormulario {
    @NotBlank
            //(message = "{usuario.notblank}")
    private String usuario;

    @NotBlank(message = "{formulario.clave.notblank}")
    @Size(min = 6, max = 12)
    private String clave;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message ="{formulario.fechaNacimiento.past}")
    private LocalDate fechaNacimiento;

    @Min(18)
    @Max(67)
    private Integer edad;

    @Digits(integer = 3, fraction = 2)
    private Float peso;

    @NotNull
    private String generoSeleccionado;

    @DireccionIp
    private String direccionIp;

    @Email (message="{formulario.email.valido}")
    private String email;
}
