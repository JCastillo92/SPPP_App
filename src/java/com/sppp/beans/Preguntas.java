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
public class Preguntas {
    private long id_tbpreguntas;
    private String descripcion;
    private boolean estado_preguntas;
    private Set<Respuesta> respuesta;
    private TipoPregunta tipoPregunta;

    public long getId_tbpreguntas() {
        return id_tbpreguntas;
    }

    public void setId_tbpreguntas(long id_tbpreguntas) {
        this.id_tbpreguntas = id_tbpreguntas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado_preguntas() {
        return estado_preguntas;
    }

    public void setEstado_preguntas(boolean estado_preguntas) {
        this.estado_preguntas = estado_preguntas;
    }

    public Set<Respuesta> getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Set<Respuesta> respuesta) {
        this.respuesta = respuesta;
    }

    public TipoPregunta getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }
    
    
}