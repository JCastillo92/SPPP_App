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
public class TipoPregunta {
    
    private long id_tipopregunta;
    private String tipo;
    private Set<Preguntas> preguntas;

    public long getId_tipopregunta() {
        return id_tipopregunta;
    }

    public void setId_tipopregunta(long id_tipopregunta) {
        this.id_tipopregunta = id_tipopregunta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Preguntas> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(Set<Preguntas> preguntas) {
        this.preguntas = preguntas;
    }
    
    
}
