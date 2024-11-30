package org.marianola.ecoparametros.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente_Data {
    private String direccionIp;
    private String navegador;
    private String sistemaOperativo;
    private String motorRenderizado;
    private String nombreHost;
    private String idiomaYLocale;
}
