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
        modelo.addAttribute("usuario", "");
        return "formulario";
    }

    @GetMapping  ("recibe-parametros")
    //@PostMapping()
    public String recibeParametros
            (@RequestParam (required = false) String usuario,
             @RequestParam (required = false) String clave,
             @RequestParam (required = false) String pi,
             @RequestParam (name="genero_seleccionado", required = false) String generoSeleccionado,
             @RequestParam (name="aficiones_seleccionadas", required = false) ArrayList<String> aficiones,
             @RequestParam (name="pais_seleccionado", required = false) String pais_seleccionado,
             @RequestParam (name= "musica_seleccionada", required = false) ArrayList<String> musica_seleccionada,
             @RequestParam (required = false) String comentarios,
             @RequestParam (required = false) String archivo,
             Model modelo) {
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("clave", clave);
        modelo.addAttribute("pi", pi);
        modelo.addAttribute("genero_seleccionado", generoSeleccionado);
        modelo.addAttribute("aficiones_seleccionadas", aficiones);
        modelo.addAttribute("pais_seleccionado", pais_seleccionado);
        modelo.addAttribute("musica_seleccionada", musica_seleccionada);
        modelo.addAttribute("comentarios", comentarios);
        modelo.addAttribute("archivo", archivo);
        return "eco-parametros";
    }
}
