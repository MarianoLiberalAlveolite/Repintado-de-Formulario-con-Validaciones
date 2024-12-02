package org.marianola.ecoparametros.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.marianola.ecoparametros.exception.PersonaNoEncontradaException;
import org.marianola.ecoparametros.exception.PersonaYaCreadaException;
import org.marianola.ecoparametros.services.PersonaServiceImpl;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonaServiceImplTest {

    private PersonaServiceImpl personaService;

    @BeforeEach //Limpia y configura los datos iniciales antes de cada prueba.
    public void setUp() {
        // Inicializamos la implementación real del servicio
        personaService = new PersonaServiceImpl();

        // Agregamos algunos datos iniciales a la lista
        /*DatosPersonas.removeTodasPersonas();
        DatosPersonas.addPersona(new Persona(1L, "Pepe", LocalDate.of(2000, 1, 2), 72.36F));
        DatosPersonas.addPersona(new Persona(2L, "Charo", LocalDate.of(2005, 5, 20), 63.28F));
        DatosPersonas.addPersona(new Persona(3L, "Luismi", LocalDate.of(1995, 10, 18), 81.36F));*/
    }

    @Test
    public void testDevuelveTodasPersonas() {
        // Ejecutar
        List<Persona> personas = personaService.devuelveTodasPersonas();

        // Assert
        assertNotNull(personas);
        assertEquals(3, personas.size()); // Hay 3 personas en la lista inicial
    }

    @Test
    public void testDevuelvePersonaPorIdEncontrada() {
        // Ejecutar
        Persona persona = personaService.devuelvePersonaPorId(1L);

        // Assert
        assertNotNull(persona);
        assertEquals("Pepe", persona.getNombre());
    }

    @Test
    public void testDevuelvePersonaPorIdNoEncontrada() {
        // Ejecutar y verificar excepción
        PersonaNoEncontradaException exception = assertThrows(PersonaNoEncontradaException.class, () -> {
            personaService.devuelvePersonaPorId(99L); // ID que no existe
        });

        // Assert
        assertEquals("La persona con id 99, no existe.", exception.getMessage());
    }

    @Test
    public void testCreaPersonaExito() {
        // Crear una nueva persona
        Persona nuevaPersona = new Persona(4L, "Ana", LocalDate.of(1990, 8, 15), 58.0F);

        // Ejecutar
        personaService.creaPersona(nuevaPersona);

        // Assert
        List<Persona> personas = personaService.devuelveTodasPersonas();
        assertEquals(4, personas.size()); // Ahora hay 4 personas
        assertNotNull(personaService.devuelvePersonaPorId(4L));
    }

    @Test
    public void testCreaPersonaDuplicada() {
        // Intentar crear una persona con un ID existente
        Persona duplicada = new Persona(1L, "Pepe", LocalDate.of(2000, 1, 2), 72.36F);

        // Ejecutar y verificar excepción
        PersonaYaCreadaException exception = assertThrows(PersonaYaCreadaException.class, () -> {
            personaService.creaPersona(duplicada);
        });

        // Assert
        assertEquals("La persona con id 1 ya existe.", exception.getMessage());
    }

    @Test
    public void testActualizaPersonaExito() {
        // Crear persona actualizada
        Persona actualizada = new Persona(1L, "Pepe Actualizado", LocalDate.of(2000, 1, 2), 80.0F);

        // Ejecutar
        personaService.actualizaPersona(actualizada);

        // Assert
        Persona persona = personaService.devuelvePersonaPorId(1L);
        assertEquals("Pepe Actualizado", persona.getNombre());
        assertEquals(80.0F, persona.getPeso());
    }

    @Test
    public void testActualizaPersonaNoEncontrada() {
        // Crear persona con un ID que no existe
        Persona inexistente = new Persona(99L, "Desconocido", LocalDate.of(1990, 1, 1), 70.0F);

        // Ejecutar y verificar excepción
        PersonaNoEncontradaException exception = assertThrows(PersonaNoEncontradaException.class, () -> {
            personaService.actualizaPersona(inexistente);
        });

        // Assert
        assertEquals("No se puede actualizar. La persona con id 99 no existe.", exception.getMessage());
    }

    @Test
    public void testEliminaPersonaExito() {
        // Ejecutar
        personaService.eliminaPersona(1L);

        // Assert
        PersonaNoEncontradaException exception = assertThrows(PersonaNoEncontradaException.class, () -> {
            personaService.devuelvePersonaPorId(1L);
        });
        assertEquals("La persona con id 1, no existe.", exception.getMessage());
    }

    @Test
    public void testEliminaPersonaNoEncontrada() {
        // Ejecutar y verificar excepción
        PersonaNoEncontradaException exception = assertThrows(PersonaNoEncontradaException.class, () -> {
            personaService.eliminaPersona(99L); // ID inexistente
        });

        // Assert
        assertEquals("No se puede eliminar. La persona con id 99 no existe.", exception.getMessage());
    }

    @Test
    public void testEliminaTodasPersonas() {
        // Ejecutar
        personaService.eliminaTodasPersonas();

        // Assert
        assertTrue(personaService.devuelveTodasPersonas().isEmpty());
    }
}
