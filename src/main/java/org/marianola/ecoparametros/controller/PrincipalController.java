package org.marianola.ecoparametros.controller;

import model.Colecciones;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PrincipalController {

    @ModelAttribute
    private void aniadeAttributesGlobalesAlModelo(Model modelo) {
        modelo.addAttribute("generos", Colecciones.getListaGeneros());
        modelo.addAttribute("aficiones", Colecciones.getListaAficiones());
        modelo.addAttribute("paises", Colecciones.getListaPaises());
        modelo.addAttribute("musica", Colecciones.getListaMusica());
    }

    @GetMapping("devuelve-formulario")
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

    @GetMapping  ("recibe-parametros")
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
             Model modelo) {

        int contadorParametros = 0;
        if (usuario != null) contadorParametros++;
        if (clave != null) contadorParametros++;
        if (generoSeleccionado != null && !generoSeleccionado.isEmpty()) contadorParametros++;
        if (aficionesSeleccionadas != null  && !aficionesSeleccionadas.isEmpty()) contadorParametros++;
        if (paisSeleccionado != null && !paisSeleccionado.isEmpty()) contadorParametros++;
        if (musicasSeleccionadas != null && !musicasSeleccionadas.isEmpty()) contadorParametros++;
        if (comentarios != null) contadorParametros++;
        if (archivo != null) contadorParametros++;
        if (licencia) contadorParametros++;
        if (imagenX != 0 || imagenY != 0) contadorParametros++;

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
        modelo.addAttribute("contadorParametros", contadorParametros);

        return "formulario/formulario";
    }
}
