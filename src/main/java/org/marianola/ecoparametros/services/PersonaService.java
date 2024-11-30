package org.marianola.ecoparametros.services;

import org.marianola.ecoparametros.model.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> devuelveTodasPersonas();
    Persona devuelvePersonaPorId(Long id);
    void creaPersona (Persona persona);
    void actualizaPersona (Persona persona);
    void eliminaPersona (Long id);
    void eliminaTodasPersonas ();
}
