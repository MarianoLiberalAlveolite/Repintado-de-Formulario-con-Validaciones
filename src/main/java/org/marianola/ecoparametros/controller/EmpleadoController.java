package org.marianola.ecoparametros.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("empleado")
//@RequestMapping(method = RequestMethod.GET)
public class EmpleadoController {


    @GetMapping("hola")
    public String hola() {
        return "empleado/di-hola";
    }

    @GetMapping("hola-mundo-cgi")
    @ResponseBody
    public String holaMundoCgi() {
        return "Hola Mundo !!!";
    }

    @GetMapping("hola-mundo")
    public String holaMundo() {
        return "index";                     //El template se escribe entre comillas
        // y sin '.html'
    }

    @GetMapping("hola-nombre")
    public String holaNombre
            (@RequestParam(required = false) String nombre, Model modelo) {
        if (nombre == null) {
            nombre = "Hola, no se ha recibido el parámetro.";
        }
        modelo.addAttribute("nombre", nombre);
        return "hola-nombre";
    }
}
