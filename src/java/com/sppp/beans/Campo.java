/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.util.List;

/**
 *
 * @author EstJhonAlexanderCast
 */
public class Campo {
    private String nombre;
    private String tipo;
    private List<String> opciones;

    public Campo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public Campo(String nombre, String tipo, List<String> opciones) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.opciones = opciones;
    }
    
    
}
