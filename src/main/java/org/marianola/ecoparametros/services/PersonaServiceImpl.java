package org.marianola.ecoparametros.services;

import org.marianola.ecoparametros.exception.PersonaNoEncontradaException;
import org.marianola.ecoparametros.model.DatosPersonas;
import org.marianola.ecoparametros.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {


    @Override
    public List<Persona> devuelveTodasPersonas() {
        return DatosPersonas.getListaPersonas();
    }

    @Override
    public Persona devuelvePersonaPorId(Long id) {
        Persona persona = DatosPersonas.getPersonaPorId(id);
        if (persona == null)
            throw new PersonaNoEncontradaException(
                    "La persona con id " + id + ", no existe.");
        return persona;
    }


    @Override
    public void creaPersona(Persona persona) {

    }

    @Override
    public void actualizaPersona(Persona persona) {

    }

    @Override
    public void eliminaPersona(Long id) {

    }

    @Override
    public void eliminaTodasPersonas() {

    }
}
