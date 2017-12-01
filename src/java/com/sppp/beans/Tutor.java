/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.util.Set;

/**
 *
 * @author KarenVanessaAchigGua
 */
public class Tutor {
    
    private long cedula;
    private int cant_visitas;
    private String sector_preferencia;
    private Set<DetallePasantia> detallePasantia;

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public int getCant_visitas() {
        return cant_visitas;
    }

    public void setCant_visitas(int cant_visitas) {
        this.cant_visitas = cant_visitas;
    }

    public String getSector_preferencia() {
        return sector_preferencia;
    }

    public void setSector_preferencia(String sector_preferencia) {
        this.sector_preferencia = sector_preferencia;
    }

    public Set<DetallePasantia> getDetallePasantia() {
        return detallePasantia;
    }

    public void setDetallePasantia(Set<DetallePasantia> detallePasantia) {
        this.detallePasantia = detallePasantia;
    }
 
    
}
