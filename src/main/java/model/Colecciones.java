package model;

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

    private static Map<String, String> listaPaises = new HashMap<>();
    static {
        listaPaises.put("A", "Andorra");
        listaPaises.put("F", "Francia");
        listaPaises.put("E", "España");
        listaPaises.put("P", "Portugal");
    }

    private static Map<String, String> listaMusica = new HashMap<>();
    static {
        listaMusica.put("E", "Electrónica");
        listaMusica.put("F", "Funky");
        listaMusica.put("N", "New Age");
        listaMusica.put("P", "Pop");
        listaMusica.put("R", "Rock");
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
