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
public class Respuesta {
    private long id_tbrespuesta;
    private String descripcion_resp;
    private Set<Datos> datos;
    private Preguntas preguntas;

    public Preguntas getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Preguntas preguntas) {
        this.preguntas = preguntas;
    }
    

    public long getId_tbrespuesta() {
        return id_tbrespuesta;
    }

    public void setId_tbrespuesta(long id_tbrespuesta) {
        this.id_tbrespuesta = id_tbrespuesta;
    }

    public String getDescripcion_resp() {
        return descripcion_resp;
    }

    public void setDescripcion_resp(String descripcion_resp) {
        this.descripcion_resp = descripcion_resp;
    }

    public Set<Datos> getDatos() {
        return datos;
    }

    public void setDatos(Set<Datos> datos) {
        this.datos = datos;
    }
    
}
