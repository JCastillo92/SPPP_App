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
public class Formato {
    private long id_tbformato;
    private String nombre_formato;
    private boolean estado_formato;
    private Set<Preguntas> preguntas;
    private Proceso proceso;

    public Proceso getProceso() {
        return proceso;
    }

    public void setProceso(Proceso proceso) {
        this.proceso = proceso;
    }

    
    public long getId_tbformato() {
        return id_tbformato;
    }

    public void setId_tbformato(long id_tbformato) {
        this.id_tbformato = id_tbformato;
    }

    public String getNombre_formato() {
        return nombre_formato;
    }

    public void setNombre_formato(String nombre_formato) {
        this.nombre_formato = nombre_formato;
    }

    public boolean isEstado_formato() {
        return estado_formato;
    }

    public void setEstado_formato(boolean estado_formato) {
        this.estado_formato = estado_formato;
    }

    public Set<Preguntas> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Preguntas> preguntas) {
        this.preguntas = preguntas;
    }
    
    
    
}
