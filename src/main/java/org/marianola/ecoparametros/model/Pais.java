package org.marianola.ecoparametros.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString

//Aseguramos la inmutabilidad de la clase usando 'final' en los atributos y no incluyendo setters
public class Pais {
    private final String nombre;
    private final String idioma;
    private final String prefijoTelefonicoPais;
    private final boolean muestraIdioma;
    private final String nombreArchivoBandera;

    //Nos aseguramos que el nombre y el idioma de cada país no sean ni nulos ni vacíos
    @Builder
    public Pais(String nombre, String idioma, String prefijoTelefonicoPais, boolean muestraIdioma, String nombreArchivoBandera) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        if (idioma == null || idioma.isEmpty()) {
            throw new IllegalArgumentException("El idioma no puede ser nulo o vacío.");
        }
        this.nombre = nombre;
        this.idioma = idioma;
        this.prefijoTelefonicoPais = prefijoTelefonicoPais;
        this.muestraIdioma = muestraIdioma;
        this.nombreArchivoBandera = nombreArchivoBandera;
    }

}