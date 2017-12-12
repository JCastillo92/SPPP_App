/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.util.Set;

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
    private Set<Datos> datos;
    private Tutor tutor;
    private VisitaTutor visitaTutor;
    private EnumEstado validacion;

    DetallePasantia(EnumEstado enumEstado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VisitaTutor getVisitaTutor() {
        return visitaTutor;
    }

    public void setVisitaTutor(VisitaTutor visitaTutor) {
        this.visitaTutor = visitaTutor;
    }
    
    public Set<Datos> getDatos() {
        return datos;
    }

    public void setDatos(Set<Datos> datos) {
        this.datos = datos;
    }
    

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

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    public EnumEstado getValidacion() {
        return validacion;
    }

    public void setValidacion(EnumEstado validacion) {
        this.validacion = validacion;
    }
    
}
