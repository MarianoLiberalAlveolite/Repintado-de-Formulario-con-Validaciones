package org.marianola.ecoparametros.controller;

import org.marianola.ecoparametros.model.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.marianola.ecoparametros.services.PersonaService;

import java.util.List;

@Controller
@RequestMapping("persona")
public class PersonaController {
    // Declaramos un objeto de la clase personaService
    // que se usara en todos los endpoints
    private final PersonaService personaServicio;

    // @Autowired
    public PersonaController(PersonaService personaServicio) {
        this.personaServicio = personaServicio;
    }


    @GetMapping()
    @ResponseBody
    public List<Persona> devuelveTodasPersonas() {
        return personaServicio.devuelveTodasPersonas();
    }
}
