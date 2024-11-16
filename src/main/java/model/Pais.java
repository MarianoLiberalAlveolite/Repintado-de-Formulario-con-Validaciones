package model;

public class Pais {
    private String nombre;
    private String idioma;
    private String prefijoTelefonicoPais;
    private boolean muestraIdioma;
    private String nombreArchivoBandera;

    public Pais(String nombre, String idioma, String prefijoTelefonicoPais, boolean muestraIdioma, String nombreArchivoBandera) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.prefijoTelefonicoPais = prefijoTelefonicoPais;
        this.muestraIdioma = muestraIdioma;
        this.nombreArchivoBandera = nombreArchivoBandera;
    }
}