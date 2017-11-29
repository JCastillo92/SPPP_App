/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Jairo
 */
public class Pasantia implements Serializable{
    private String tipo_ppp;
    private int cod_ppp;
    private Date fechaInicio;
    private Date fechaFin;
    private int tiempoEsperaEstado;
    private boolean estado;
    private Set<DetallePasantia> detallePasantias;
    private Encargado encargado;

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public String getTipo_ppp() {
        return tipo_ppp;
    }

    public void setTipo_ppp(String tipo_ppp) {
        this.tipo_ppp = tipo_ppp;
    }

    public int getCod_ppp() {
        return cod_ppp;
    }

    public void setCod_ppp(int cod_ppp) {
        this.cod_ppp = cod_ppp;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTiempoEsperaEstado() {
        return tiempoEsperaEstado;
    }

    public void setTiempoEsperaEstado(int tiempoEsperaEstado) {
        this.tiempoEsperaEstado = tiempoEsperaEstado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Set<DetallePasantia> getDetallePasantias() {
        return detallePasantias;
    }

    public void setDetallePasantias(Set<DetallePasantia> detallePasantias) {
        this.detallePasantias = detallePasantias;
    }
    
    
    
    
}
