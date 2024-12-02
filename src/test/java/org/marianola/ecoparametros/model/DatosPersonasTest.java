package org.marianola.ecoparametros.model;

import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.marianola.ecoparametros.services.PersonaService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DatosPersonasTest {

   @Test
    public void testGetPersonaPorId_Encontrado() {
        long idEmpleado = 1L;

        Persona personaPrueba = new Persona(idEmpleado, "Pepe",  LocalDate.of(2000, 1, 2), 72.36F);

        Optional<Persona> personaRecuperada = DatosPersonas.getPersonaPorId(idEmpleado);

        // Assert
        assertNotNull(personaRecuperada);
        assertEquals(personaPrueba.getId(), personaRecuperada.get().getId());
        assertEquals(personaPrueba.getNombre(), personaRecuperada.get().getNombre());
        assertEquals(personaPrueba.getFechaNacimiento(), personaRecuperada.get().getFechaNacimiento());
        //assert.equals(personaPrueba, PersonaRecuperada);
    }

    @Test
    public void testGetPersonaPorId_NoEncontrado() {
        long idEmpleado = 5L;
        //No haría falta declarar toda la persona, solo con el ID bastaría
//        Persona personaPrueba = new Persona(3L, "Lolo",  LocalDate.of(1996, 5, 6), 79.62F);

        Optional<Persona> personaRecuperada = DatosPersonas.getPersonaPorId(idEmpleado);

        // Assert
        assertFalse(personaRecuperada.isPresent());
    }

    @Test
    public void testRemoveTodasPersonas() {
        // Ejecutar el metodo
        DatosPersonas.removeTodasPersonas();

        // Assert
        assertTrue(DatosPersonas.getListaPersonas().isEmpty()); // Verificar que la lista está vacía
    }

    @Test
    public void testAddPersona_Existe() {
        Persona personaPrueba = new Persona(1L, "Pepe",  LocalDate.of(2000, 1, 2), 72.36F);

        // Assert
        assertFalse(DatosPersonas.addPersona(personaPrueba));
    }

    @Test
    public void testAddPersona_NoExiste() {
        Persona personaPrueba = new Persona(3L, "Lolo",  LocalDate.of(1996, 5, 6), 79.62F);

        // Assert
        assertTrue(DatosPersonas.addPersona(personaPrueba));
    }

    @Test
    public void testUpdatePersona_ActualizaExistente() {
        // Persona existente en la lista inicial
        Persona personaActualizada = new Persona(1L, "Pepe Actualizado", LocalDate.of(2000, 1, 2), 80.0F);

        // Ejecutar el metodo
        Persona resultado = DatosPersonas.updatePersona(personaActualizada);

        // Assert
        assertNotNull(resultado);
        assertEquals("Pepe Actualizado", resultado.getNombre());
        assertEquals(80.0F, resultado.getPeso());
    }

    @Test
    public void testUpdateOrAddPersona_AñadeNueva() {
        // Persona nueva que no existe
        Persona personaNueva = new Persona(4L, "Nuevo Usuario", LocalDate.of(1995, 4, 15), 68.0F);

        // Ejecutar el metodo
        Persona resultado = DatosPersonas.updatePersona(personaNueva);

        // Assert
        assertNotNull(resultado);
        assertEquals(personaNueva.getId(), resultado.getId());
        assertEquals(personaNueva.getNombre(), resultado.getNombre());

        // Verificar que la lista contiene la nueva persona
        assertEquals(personaNueva, DatosPersonas.getPersonaPorId(4L));
    }

    @Test
    public void testDeletePersona_Existe() {
        long idEmpleado = 1L; // ID que existe en la lista inicial

        // Ejecutar el metodo
        boolean eliminado = DatosPersonas.deletePersona(idEmpleado);

        // Assert
        assertTrue(eliminado);
        assertNull(DatosPersonas.getPersonaPorId(idEmpleado)); // Verificar que ya no está en la lista
    }

    @Test
    public void testDeletePersona_NoExiste() {
        long idEmpleado = 99L; // ID que no existe

        // Ejecutar el metodo
        boolean eliminado = DatosPersonas.deletePersona(idEmpleado);

        // Assert
        assertFalse(eliminado);
    }
}

