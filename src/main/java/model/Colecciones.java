package model;

import java.util.HashMap;
import java.util.Map;

public class Colecciones {

    private static Map<String, String> listaGeneros = new HashMap<>();
    static {
        listaGeneros.put("M", "Masculino");
        listaGeneros.put("F", "Femenino");
        listaGeneros.put("O", "Otros");
    }

    private static Map<String, String> listaAficiones = new HashMap<>();
    static {
        listaAficiones.put("V", "Viajes");
        listaAficiones.put("D", "Deportes");
        listaAficiones.put("L", "Libros");
        listaAficiones.put("S", "Series");
    }

    private static Map<String, String> listaPaises = new HashMap<>();
    static {
        listaPaises.put("A", "Andorra");
        listaPaises.put("F", "Francia");
        listaPaises.put("E", "España");
        listaPaises.put("P", "Portugal");
    }

    private static Map<String, String> listaMusica = new HashMap<>();
    static {
        listaMusica.put("P", "Pop");
        listaMusica.put("F", "Funky");
        listaMusica.put("R", "Rock");
        listaMusica.put("C", "Clásica");
    }

    public static Map<String, String> getListaGeneros() {
        return listaGeneros;
    }
    public static Map<String, String> getListaAficiones() {
        return listaAficiones;
    }
    public static Map<String, String> getListaPaises() {
        return listaPaises;
    }
    public static Map<String, String> getListaMusica() {
        return listaMusica;
    }

}
