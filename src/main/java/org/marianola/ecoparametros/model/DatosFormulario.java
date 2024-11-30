package org.marianola.ecoparametros.model;

import Validations.*;
import org.marianola.ecoparametros.Validations.DireccionIp;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@ClaveCoincide(message = "{ClaveCoincide.datosFormulario.confirmarClave}")
@FechaEdadValida(message = "{FechaEdadValida.datosFormulario.fechaNacimiento}")
public class DatosFormulario {

    /* DATOS DE USUARIO */

    @NotBlank(message = "{NotBlank.datosFormulario.nombre}")
    private String nombre = "Lola";

    @NotBlank(message = "{NotBlank.datosFormulario.clave}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!#$%&]).{6,12}$",
            message = "{Pattern.datosFormulario.clave}")
    @Size(min = 6, max = 12, message = "{Size.datosFormulario.clave}")
    private String clave;

    @NotBlank(message = "{formulario.clave.notblank}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!#$%&]).{6,12}$", message = "{Pattern.datosFormulario.confirmarClave}")
    private String confirmarClave;

    /* DATOS PERSONALES */

    @NotNull
    private String generoSeleccionado;

    @NotNull
    private String paisSeleccionado;

    @NotNull
    @EsAdulto(message = "{EsAdulto.datosFormulario.fechaNacimiento}")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past(message ="{Past.datosFormulario.fechaNacimiento}")
    private LocalDate fechaNacimiento;

    @Min(value = 18, message = "{Min.datosFormulario.edad}")
    @Max(value = 67, message = "{Max.datosFormulario.edad}")
    private Integer edad;

    @Digits(integer = 3, fraction = 2, message = "{Digits.datosFormulario.peso}")
    private Float peso;

    /* DATOS DE CONTACTO */

    @NotNull
    private String prefijoSeleccionado;

    @NotNull
    @Pattern(regexp = "\\d{9}", message = "{Pattern.datosFormulario.telefono}")
    private String telefono;

    @EmailValido(message = "{EmailValido.datosFormulario.email}")
    private String email;

    @DireccionIp (message = "{DireccionIp.datosFormulario.direccionIp}")
    private String direccionIp;

    /* DATOS DE INTERÉS */

    @NotNull
    @Size(min = 1, message = "{Size.datosFormulario.musicasSeleccionadas}")
    private List<String> aficionesSeleccionadas;

    @NotNull
    @Size(min = 1, message = "{Size.datosFormulario.aficionesSeleccionadas}")
    private List<String> musicasSeleccionadas;

    private String comentarios;

    @NotNull (message = "{NotNull.datosFormulario.licencia}")
    private Boolean licencia;

    @TipoArchivo (message = "{TipoArchivo.datosFormulario.archivo}")
    private MultipartFile archivo;
}
