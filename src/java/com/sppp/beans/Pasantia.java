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
    private String cod_resolucion_consejo;
    private Long ced_tutor_asignado;

    private Set<DetallePasantia> detallePasantias;
    private Encargado encargado;
    private Estudiante estudiante;
    private Periodo periodo;
    
    

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    

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

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
    
     public String getCod_resolucion_consejo() {
        return cod_resolucion_consejo;
    }

    public void setCod_resolucion_consejo(String cod_resolucion_consejo) {
        this.cod_resolucion_consejo = cod_resolucion_consejo;
    }
    
    
    public Long getCed_tutor_asignado() {
        return ced_tutor_asignado;
    }

    public void setCed_tutor_asignado(Long ced_tutor_asignado) {
        this.ced_tutor_asignado = ced_tutor_asignado;
    }
    
}
