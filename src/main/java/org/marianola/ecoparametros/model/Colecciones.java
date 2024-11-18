package org.marianola.ecoparametros.model;

import java.util.HashMap;
import java.util.Map;

public class Colecciones {

    private static Map<String, String> listaGeneros = new HashMap<>();
    static {
        listaGeneros.put("M", "Masculino");
        listaGeneros.put("F", "Femenino");
        listaGeneros.put("O", "Otro");
    }

    private static Map<String, String> listaAficiones = new HashMap<>();
    static {
        listaAficiones.put("D", "Deporte");
        listaAficiones.put("L", "Lectura");
        listaAficiones.put("P", "Pintura");
        listaAficiones.put("V", "Viajes");

    }

    private static Map<String, Pais> listaPaises = new HashMap<>();
    static {
        listaPaises.put("es", new Pais("España","Castellano","34",true,"espania.jpg"));
        listaPaises.put("fr", new Pais ("Francia","Francés","33",false, "francia.jpg"));
        listaPaises.put("it", new Pais("Italia","Italiano","39",false, "italia.jpg"));
        listaPaises.put("pt", new Pais("Portugal","Portugués","351",false, "portugues.jpg"));
        listaPaises.put("en", new Pais("Reino Unido","Inglés", "44", true, "reino_unido.jpg"));
    }

    private static Map<String, String> listaMusicas = new HashMap<>();
    static {
        listaMusicas.put("E", "Electrónica");
        listaMusicas.put("F", "Funky");
        listaMusicas.put("N", "New Age");
        listaMusicas.put("P", "Pop");
        listaMusicas.put("R", "Rock");
    }

    //Añadimos a los getters la devolución de copias inmutables de las colecciones
    // para evitar que los datos puedan modificarse en tiempo de ejecución:
    public static Map<String, String> getListaGeneros() {
        return Map.copyOf(listaGeneros);
    }
    public static Map<String, String> getListaAficiones() {
        return Map.copyOf(listaAficiones);
    }
    public static Map<String, Pais> getListaPaises() {
        return Map.copyOf(listaPaises);
    }
    public static Map<String, String> getListaMusica() {
        return Map.copyOf(listaMusicas);
    }

}
