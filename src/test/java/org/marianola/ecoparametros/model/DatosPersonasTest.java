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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DatosPersonasTest {

   @Test
    public void testGetPersonaPorId_Encontrado() {
        long idEmpleado = 1L;

        Persona personaPrueba = new Persona(idEmpleado, "Pepe",  LocalDate.of(2000, 1, 2), 72.36F);

        Persona personaRecuperada = DatosPersonas.getPersonaPorId(idEmpleado);

        // Assert
        assertNotNull(personaRecuperada);
        assertEquals(personaPrueba.getId(), personaRecuperada.getId());
        assertEquals(personaPrueba.getNombre(), personaRecuperada.getNombre());
        assertEquals(personaPrueba.getFechaNacimiento(), personaRecuperada.getFechaNacimiento());
        //assert.equals(personaPrueba, PersonaRecuperada);
    }

    @Test
    public void testGetPersonaPorId_NoEncontrado() {
        long idEmpleado = 3L;
        //No haría falta declarar toda la persona, solo con el ID bastaría
        Persona personaPrueba = new Persona(3L, "Lolo",  LocalDate.of(1996, 5, 6), 79.62F);

        Persona personaRecuperada = DatosPersonas.getPersonaPorId(idEmpleado);

        // Assert
        assertNotNull(personaRecuperada);
    }

    @Test
    public void testAddPersona_Existe() {
        long idEmpleado = 1L;

        Persona personaPrueba = new Persona(1L, "Pepe",  LocalDate.of(2000, 1, 2), 72.36F);

        // Assert
        assertFalse(DatosPersonas.addPersona(personaPrueba));
    }

    @Test
    public void testAddPersona_NoExiste() {
        long idEmpleado = 3L;

        Persona personaPrueba = new Persona(3L, "Lolo",  LocalDate.of(1996, 5, 6), 79.62F);

        // Assert
        assertTrue(DatosPersonas.addPersona(personaPrueba));
    }
}

