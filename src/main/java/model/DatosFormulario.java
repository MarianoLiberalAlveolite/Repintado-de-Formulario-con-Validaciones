package model;

import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DatosFormulario {
    private String usuario;
    private String clave;
    private String pi;
    private String generoSeleccionado;
    private ArrayList<String> aficiones;
    private String pais;
    private ArrayList<String> musica;
    private String comentarios;
    private String archivo;
}
