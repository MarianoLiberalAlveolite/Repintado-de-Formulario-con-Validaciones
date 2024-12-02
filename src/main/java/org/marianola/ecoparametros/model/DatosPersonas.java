package org.marianola.ecoparametros.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DatosPersonas {
    // @Getter
    private static List<Persona> listaPersonas =
            // MANERA 1 de inicializar
            /*
            new ArrayList<Persona>(){{
               add(new Persona(1L, "Pepe", LocalDate.of(2000, 1, 2), 72.36F));
               add(new Persona(2L, "Charo", LocalDate.of(2005, 5, 20), 63.28F));
               add(new Persona(3L, "Luismi", LocalDate.of(1995, 10, 18), 81.36F));
            }};
            */

            // MANERA 2 de inicializar
            /*
            Arrays.asList(
                    new Persona(1L, "Pepe", LocalDate.of(2000, 1, 2), 72.36F),
                    new Persona(2L, "Charo", LocalDate.of(2005, 5, 20), 63.28F),
                    new Persona(3L, "Luismi", LocalDate.of(1995, 10, 18), 81.36F)
            );
            */

            // MANERA 3 de inicializar
            Stream.of(
                    new Persona(1L, "Pepe",  LocalDate.of(2000, 1, 2), 72.36F),
                    new Persona(2L, "Charo", LocalDate.of(2005, 5, 20), 63.28F),
                    new Persona(3L, "Luismi", LocalDate.of(1995, 10, 18), 81.36F)
            ).collect(Collectors.toList());


    public static List<Persona> getListaPersonas() { return listaPersonas;}

    public static Persona getPersonaPorId(Long id) {
        /* for (Persona persona : listaPersonas) {
            if (persona.getId().equals(id)) {
                return persona;
            }
        }
        return null; */
        //Retornamos una Persona, que se obtiene con 'filter' que busca una coincidencia
        //'findFirst()' busca la primera coincidencia obtenida con el 'filter'
        //si no la encuentra devuelve 'null'
        return listaPersonas.stream()
                .filter(persona -> persona.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static void removeTodasPersonas() {
        //lista.clear = remueve a todas las personas de una lista
        listaPersonas.clear();
    }

    public static boolean addPersona(Persona persona) {
        // + anyMatch(condición) = devuelve boolean
        if (!listaPersonas.stream().anyMatch(p -> p.getId().equals(persona.getId()))) {
            return listaPersonas.add(persona);
        }
        return false;
    }

    public static Persona updatePersona(Persona personaActualizada) {
        //Convertimos una lista nueva en un 'stream' de nuestra lista (BBDD)
        //Con 'map' convertimos/cambiamos cada elemento que cumpla con una condición
        // + en este caso que coincidan por Id, si coinciden la actualizo (machacando la anterior), si no coinciden no hago nada
        //Lo hago utilizando un operador ternario
        //Con 'collect(Collectors.toList()) = hacemos que el stream vuelva a ser una lista
        List<Persona> nuevaLista = listaPersonas.stream()
                .map(p -> p.getId().equals(personaActualizada.getId()) ? personaActualizada : p)
                .collect(Collectors.toList());

        // Verificamos si la persona fue actualizada usando un booleano
        // + anyMatch(condición) = devuelve boolean
        boolean personaEncontrada = nuevaLista.stream()
                .anyMatch(p -> p.getId().equals(personaActualizada.getId()));

        // Si no se encuentra la persona, notificar y agregarla a la lista
        if (!personaEncontrada) {
            System.out.printf("La persona %s con ID %d no existe en la BBDD, procedemos a insertarla.\n",personaActualizada.getNombre(), personaActualizada.getId());
            nuevaLista.add(personaActualizada);
        }

        // Reemplazar la lista original con la nueva lista
        listaPersonas = nuevaLista;

        // Retornar la persona actualizada o añadida
        return personaActualizada;
    }

    public static boolean deletePersona(Long id) {
         return listaPersonas.removeIf(persona -> persona.getId().equals(id));
    }
}
