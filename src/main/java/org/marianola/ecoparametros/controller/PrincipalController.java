package org.marianola.ecoparametros.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.marianola.ecoparametros.model.Colecciones;
import org.marianola.ecoparametros.model.DatosFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("formulario")
public class PrincipalController {

    // Pequeño metodo que analiza la String userAgent
    // y nos la traduce para que sea obvia
    private String getSistemaOperativo(String userAgent) {
        if (userAgent.contains("Windows")) return "Windows";
        if (userAgent.contains("Mac")) return "Mac OS";
        if (userAgent.contains("X11")) return "Unix";
        if (userAgent.contains("Linux")) return "Linux";
        return "Desconocido";
    }

    // Lo mismo con el motor de renderizado usado por el navegador
    private String getMotorRenderizado(String userAgent) {
        if (userAgent.contains("WebKit")) return "WebKit";
        if (userAgent.contains("Gecko")) return "Gecko";
        if (userAgent.contains("Trident")) return "Trident";
        return "Desconocido";
    }

    // Aunamos todos los atributos de modelo comunes a nuestros 2 endpoints principales
    @ModelAttribute
    private void agregarAtributosGlobalesAlModelo(Model modelo, HttpServletRequest request, Locale locale) {

        // Creamos una lista para almacenar los nombres de los parametros
        List<String> parametrosRellenados = new ArrayList<>();

        // Sacamos los nombres de todos los parámetros
        Enumeration<String> parameterNames = request.getParameterNames();
        int count = 0;

        // Vamos iterando sobre los parámetros y agregando los que no están vacíos
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = request.getParameter(paramName);

            if (paramValue != null && !paramValue.isEmpty()) {
                parametrosRellenados.add(paramName); // Para agregar solo el nombre del parámetro
            }
            count++;
        }

        // Cogemos la información del cliente HTTP con HttpServletRequest
        String direccionIP = request.getRemoteAddr(); // Dirección IP del cliente
        String navegador = request.getHeader("User-Agent"); // Navegador usado
        String sistemaOperativo = getSistemaOperativo(navegador); // Sistema operativo
        String motorRenderizado = getMotorRenderizado(navegador); // Motor de renderizado
        String nombreHost = request.getServerName(); // Nombre del host
        String idiomaYLocale = request.getLocale().toString(); // Idioma y locale preferidos

        // Pasamos los datos al modelo para la vista
        modelo.addAttribute("parametrosRellenados", parametrosRellenados);
        modelo.addAttribute("totalParametros", count);
        modelo.addAttribute("totalRellenados", parametrosRellenados.size());

        // Añadimos la información de la solicitud HTTP al modelo
        modelo.addAttribute("direccionIP", direccionIP);
        modelo.addAttribute("navegador", navegador);
        modelo.addAttribute("sistemaOperativo", sistemaOperativo);
        modelo.addAttribute("motorRenderizado", motorRenderizado);
        modelo.addAttribute("nombreHost", nombreHost);
        modelo.addAttribute("idiomaYLocale", idiomaYLocale);

        // Añadimos también las 4 colecciones que usamos en ambos endpoints
        modelo.addAttribute("generos", Colecciones.getListaGeneros());
        modelo.addAttribute("aficiones", Colecciones.getListaAficiones());
        modelo.addAttribute("paises", Colecciones.getListaPaises());
        modelo.addAttribute("musica", Colecciones.getListaMusica());

        //Iniciamos las iteraciones a '1'
        modelo.addAttribute("iteraciones", 1);

        //????????????????????????????????????
        // Añadimos datos marcados por defecto
        /*ArrayList<String> aficionesSeleccionadas = new ArrayList<>();
        aficionesSeleccionadas.add("D");
        aficionesSeleccionadas.add("P");
        aficionesSeleccionadas.add("V");*/
        /*modelo.addAttribute("titulo", "Original");
        modelo.addAttribute("nombre", "Lola");
        modelo.addAttribute("paisSeleccionado", "pt");
        modelo.addAttribute("aficionesSeleccionadas", Arrays.asList("D","P","V"));
        modelo.addAttribute("prefijoSeleccionado", "fr");
        modelo.addAttribute("musicasSeleccionadas", Arrays.asList("F", "R"));*/
    }

    @PostMapping ("/formulario/lang")
    public String cambiarLenguaje(@RequestParam ("idioma") String idioma){
        return "formulario";
    }

    @GetMapping ("devuelve-formulario")
    public String devuelveFormularioValidado(
        @ModelAttribute DatosFormulario datosFormulario) {
        return "formulario";
    }


    @PostMapping("recibe-parametros")
    public String recibeParametrosYrepinta(Model modelo,
                                           @Valid DatosFormulario datosFormulario,
                                           BindingResult resultadoValidacion,
                                           @RequestParam (name = "iteraciones", required = false) int iteraciones,
                                           @RequestParam (name= "enviarFlecha.x", required = false, defaultValue = "0") int imagenX,
                                           @RequestParam (name= "enviarFlecha.y", required = false, defaultValue = "0") int imagenY,
                                           @RequestParam Map<String, List<String>> mapaParametros
            ) {
            modelo.addAttribute("iteraciones", ++iteraciones);
            modelo.addAttribute("imagenX", imagenX);
            modelo.addAttribute("imagenY", imagenY);
            modelo.addAttribute("paramPasados", mapaParametros);
            modelo.addAttribute("paramNum", mapaParametros.size());
            modelo.addAttribute("paisSeleccionado", datosFormulario.getPaisSeleccionado());
            modelo.addAttribute("musicasSeleccionadas", datosFormulario.getMusicasSeleccionadas());
            modelo.addAttribute("aficionesSeleccionadas", datosFormulario.getAficionesSeleccionadas());
            modelo.addAttribute("comentarios", datosFormulario.getComentarios());

            if (resultadoValidacion.hasErrors()){
                modelo.addAttribute("mensajeNOK","ALERTA: Formulario con errores.");
                return "formulario";
            }
            modelo.addAttribute("mensajeOK","ALELUYA: Formulario sin errores.");

        return "formulario";
    }

    /* *************** IGNORAR *********************
       ******* MÉTODOS DE LA PRÁCTICA ANTERIOR ********************


    //Este metodo devuelve el formulario vacío y es desde donde se inicia la aplicación
    @GetMapping ("devuelve-formulario")
    public String devuelveFormulario(Model modelo) {
        modelo.addAttribute("titulo", "Formulario Original");
        modelo.addAttribute("usuario", "Pepe");
        modelo.addAttribute("iteraciones", 1);
        modelo.addAttribute("aficiones_seleccionadas", new ArrayList<String>() {{
            add("D"); // Deporte
            add("P"); // Pintura
            add("V"); // Viajes
        }});
        modelo.addAttribute("musica_seleccionada", new ArrayList<String>() {{
            add("F"); // Funky
            add("R"); // Rock
        }});
        modelo.addAttribute("pais_seleccionado", "F"); // Francia
        return "formulario/formulario";
    }

    //Este metodo utiliza POST en lugar de GET y es el que repinta el formulario con los valores seleccionados
    @PostMapping  ("recibe-parametros")
    public String recibeParametros
            (@RequestParam (required = false) String usuario,
             @RequestParam (required = false) String clave,
             @RequestParam (defaultValue = "0") int iteraciones,
             @RequestParam (name="genero_seleccionado", required = false) String generoSeleccionado,
             @RequestParam (name="aficiones_seleccionadas", required = false) ArrayList<String> aficionesSeleccionadas,
             @RequestParam (name="pais_seleccionado", required = false) String paisSeleccionado,
             @RequestParam (name= "musica_seleccionada", required = false) ArrayList<String> musicasSeleccionadas,
             @RequestParam (required = false) String comentarios,
             @RequestParam (defaultValue = "false") boolean licencia,
             @RequestParam (required = false) String archivo,
             @RequestParam (name= "enviarFlecha.x", required = false, defaultValue = "0") int imagenX,
             @RequestParam (name= "enviarFlecha.y", required = false, defaultValue = "0") int imagenY,
             @RequestParam (required = false) Map<String,String> contadorParametros,
             Model modelo) {

        iteraciones ++;
        modelo.addAttribute("titulo", "Formulario Repintado");
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("clave", clave);
        modelo.addAttribute("iteraciones", iteraciones);
        modelo.addAttribute("genero_seleccionado", generoSeleccionado);
        modelo.addAttribute("aficiones_seleccionadas", aficionesSeleccionadas);
        modelo.addAttribute("pais_seleccionado", paisSeleccionado);
        modelo.addAttribute("musica_seleccionada", musicasSeleccionadas);
        modelo.addAttribute("comentarios", comentarios);
        modelo.addAttribute("licencia", licencia);
        modelo.addAttribute("imagenX", imagenX);
        modelo.addAttribute("imagenY", imagenY);
        modelo.addAttribute("archivo", archivo);
        modelo.addAttribute("contadorParametros", contadorParametros.size());

        return "formulario/formulario";
    }*/
}
