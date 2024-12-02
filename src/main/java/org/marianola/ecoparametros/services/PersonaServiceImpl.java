package org.marianola.ecoparametros.services;

import org.marianola.ecoparametros.exception.PersonaNoEncontradaException;
import org.marianola.ecoparametros.exception.PersonaYaCreadaException;
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
        // Busca una persona por ID.
        // Si no la encuentra, lanza una excepción personalizada
        Persona persona = DatosPersonas.getPersonaPorId(id);
        if (persona == null)
            throw new PersonaNoEncontradaException(
                    "La persona con id " + id + ", no existe.");
        return persona;
    }


    @Override
    public void creaPersona(Persona persona) {
        // Verifica si la persona ya existe en la lista
        // addPersona, añade si no está en la lista y además devuelve un booleano
        boolean added = DatosPersonas.addPersona(persona);
        // Si devuelve falso quiere decir que la persona ya existe
        // Si es así lanzamos una excepción
        if (!added) {
            throw new PersonaYaCreadaException(
                    "La persona con id " + persona.getId() + " ya existe.");
        }
    }

    @Override
    public void actualizaPersona(Persona persona) {
        // Intenta actualizar una persona. Si no la encuentra, lanza una excepción
        Persona actualizada = DatosPersonas.updatePersona(persona);
        // Si no la encuentra (cosa que parece imposible, porque el metodo 'updatePersona(Persona)' o actualiza una persona, o añade una nueva) lanza la excepción:
        if (actualizada == null) {
            throw new PersonaNoEncontradaException(
                    "No se puede actualizar. La persona con id " + persona.getId() + " no existe.");
        }
    }

    @Override
    public void eliminaPersona(Long id) {
        // Intenta eliminar una persona por su ID. Si no la encuentra, lanza una excepción
        boolean eliminada = DatosPersonas.deletePersona(id);
        if (!eliminada) {
            throw new PersonaNoEncontradaException(
                    "No se puede eliminar. La persona con id " + id + " no existe.");
        }
    }

    @Override
    public void eliminaTodasPersonas() {
        // Vacía la lista de personas
        DatosPersonas.removeTodasPersonas();
    }
}
