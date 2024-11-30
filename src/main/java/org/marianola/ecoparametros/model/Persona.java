package org.marianola.ecoparametros.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor
@Data
public class Persona {

    private Long id;
    private String  nombre;
    private LocalDate fechaNacimiento;
    private Float peso;
}
