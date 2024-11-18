package org.marianola.ecoparametros.controller;

import jakarta.validation.Valid;
import org.marianola.ecoparametros.model.Colecciones;
import org.marianola.ecoparametros.model.DatosFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
@RequestMapping("/formulario")
public class PrincipalController {


    //Este metodo sirve para declarar los Maps y que sean globales en la clase Controller
    @ModelAttribute
    private void aniadeAttributesGlobalesAlModelo(Model modelo) {
        modelo.addAttribute("generos", Colecciones.getListaGeneros());
        modelo.addAttribute("aficiones", Colecciones.getListaAficiones());
        modelo.addAttribute("paises", Colecciones.getListaPaises());
        modelo.addAttribute("musica", Colecciones.getListaMusica());
    }

    @GetMapping("/formulario/lang")
    public String cambiarLenguaje(@RequestParam ("lang") String lang){
        return "formulario/vistas/formulario";
    }

    @GetMapping ("devuelve-formulario")
    public String devuelveFormularioValidado(
            Model modelo,
        @ModelAttribute DatosFormulario datosFormulario) {
        modelo.addAttribute("usuario", "Lola");
        modelo.addAttribute("pais_seleccionado", "pt"); // Portugal
        modelo.addAttribute("aficiones_seleccionadas", new ArrayList<String>() {{
            add("D"); // Deporte
            add("P"); // Pintura
            add("V"); // Viajes
        }});
        modelo.addAttribute("musica_seleccionada", new ArrayList<String>() {{
            add("F"); // Funky
            add("R"); // Rock
        }});
        return "formulario/vistas/formulario";
    }

    /* CONVERTIR A POST */
    //@PostMapping
    @GetMapping("recibe-parametros") //De la clase DatosFormulario creo un objeto que se llama datosFormulario
    public String recibeParametrosYrepinta(
            @Valid
            @ModelAttribute DatosFormulario datosFormulario,
            BindingResult resultadoValidacion,
            @RequestParam (required = false) Map<String,String> contadorParametros,
            @RequestParam (defaultValue = "0") int iteraciones,
            @RequestParam (name= "enviarFlecha.x", required = false, defaultValue = "0") int imagenX,
            @RequestParam (name= "enviarFlecha.y", required = false, defaultValue = "0") int imagenY,
            Model modelo
            ) {
            iteraciones ++;
            modelo.addAttribute("iteraciones", iteraciones);
            modelo.addAttribute("contadorParametros", contadorParametros.size());
            modelo.addAttribute("imagenX", imagenX);
            modelo.addAttribute("imagenY", imagenY);
            if (resultadoValidacion.hasErrors()){
                modelo.addAttribute("mensajeNOK","ALERTA: Formulario con errores.");
                return "formulario/vistas/formulario";
            }
            modelo.addAttribute("mensajeOK","ALELUYA: Formulario sin errores.");

        return "formulario/vistas/formulario";
    }
    //Prueba de sintaxis para ver como funciona fragmentos
    /*
    @GetMapping("devuelvePruebaformulario")
    public String devuelvePruebaFormulario(Model modelo) {
        modelo.addAttribute("vista","formulario_practica1.html");
        return "principal";
    }*/

    /* *************** IGNORAR *********************
       ******* MÉTODOS DE LA PRÁCTICA ANTERIOR ********************


    //Este metodo devuelve el formulario vacío y es desde donde se inicia la aplicación
    @GetMapping ("devuelve-formulario")
    public String devuelveFormulario(Model modelo) {
        modelo.addAttribute("titulo", "Formulario Original");
        modelo.addAttribute("usuario", "Pepe");
        modelo.addAttribute("iteraciones", 1);
        modelo.addAttribute("aficiones_seleccionadas", new ArrayList<String>() {{
            add("D"); // Deporte
            add("P"); // Pintura
            add("V"); // Viajes
        }});
        modelo.addAttribute("musica_seleccionada", new ArrayList<String>() {{
            add("F"); // Funky
            add("R"); // Rock
        }});
        modelo.addAttribute("pais_seleccionado", "F"); // Francia
        return "formulario/formulario";
    }

    //Este metodo utiliza POST en lugar de GET y es el que repinta el formulario con los valores seleccionados
    @PostMapping  ("recibe-parametros")
    public String recibeParametros
            (@RequestParam (required = false) String usuario,
             @RequestParam (required = false) String clave,
             @RequestParam (defaultValue = "0") int iteraciones,
             @RequestParam (name="genero_seleccionado", required = false) String generoSeleccionado,
             @RequestParam (name="aficiones_seleccionadas", required = false) ArrayList<String> aficionesSeleccionadas,
             @RequestParam (name="pais_seleccionado", required = false) String paisSeleccionado,
             @RequestParam (name= "musica_seleccionada", required = false) ArrayList<String> musicasSeleccionadas,
             @RequestParam (required = false) String comentarios,
             @RequestParam (defaultValue = "false") boolean licencia,
             @RequestParam (required = false) String archivo,
             @RequestParam (name= "enviarFlecha.x", required = false, defaultValue = "0") int imagenX,
             @RequestParam (name= "enviarFlecha.y", required = false, defaultValue = "0") int imagenY,
             @RequestParam (required = false) Map<String,String> contadorParametros,
             Model modelo) {

        iteraciones ++;
        modelo.addAttribute("titulo", "Formulario Repintado");
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("clave", clave);
        modelo.addAttribute("iteraciones", iteraciones);
        modelo.addAttribute("genero_seleccionado", generoSeleccionado);
        modelo.addAttribute("aficiones_seleccionadas", aficionesSeleccionadas);
        modelo.addAttribute("pais_seleccionado", paisSeleccionado);
        modelo.addAttribute("musica_seleccionada", musicasSeleccionadas);
        modelo.addAttribute("comentarios", comentarios);
        modelo.addAttribute("licencia", licencia);
        modelo.addAttribute("imagenX", imagenX);
        modelo.addAttribute("imagenY", imagenY);
        modelo.addAttribute("archivo", archivo);
        modelo.addAttribute("contadorParametros", contadorParametros.size());

        return "formulario/formulario";
    }*/
}
