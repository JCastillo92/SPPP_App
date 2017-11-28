/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

/**
 *
 * @author Jairo
 */
public class DetallePasantia {
    private int idDetallePasantia;
    private String descripcion;
    private boolean estado;
    private Proceso proceso;
    private Pasantia pasantia;

    public Pasantia getPasantia() {
        return pasantia;
    }

    public void setPasantia(Pasantia pasantia) {
        this.pasantia = pasantia;
    }

    public int getIdDetallePasantia() {
        return idDetallePasantia;
    }

    public void setIdDetallePasantia(int idDetallePasantia) {
        this.idDetallePasantia = idDetallePasantia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }
    
}
