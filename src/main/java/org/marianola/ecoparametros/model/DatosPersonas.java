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
        if (!listaPersonas.stream().anyMatch(p -> p.getId().equals(persona.getId()))) {
            return listaPersonas.add(persona);
        }
        return false;
    }

    /*public static Persona updatePersona(Long id, ) {

        Persona persona = getPersonaPorId(id);
        if (persona == null) {
            addPersona(persona);
        } else {
            Persona p = listaPersonas.stream().anyMatch(persona::equals) ? persona : null;
            if (p != null) {

            }
        }

        return persona;
    }*/

    public static boolean deletePersona(Long id) {
         return listaPersonas.removeIf(persona -> persona.getId().equals(id));
    }
}
