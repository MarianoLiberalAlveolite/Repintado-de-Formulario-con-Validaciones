package org.marianola.ecoparametros.exception;

public class PersonaNoEncontradaException extends RuntimeException{
    public PersonaNoEncontradaException(String mensaje){
        super(mensaje);
    }
}
