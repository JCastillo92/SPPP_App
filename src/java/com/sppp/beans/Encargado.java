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
public class Encargado {
    private int id_encargado;
    private long ci_encargado;
    private String nombre_encargado;
    private String cargo_encargado;
    private Set<Pasantia> pasantias;

    public int getId_encargado() {
        return id_encargado;
    }

    public void setId_encargado(int id_encargado) {
        this.id_encargado = id_encargado;
    }

    public long getCi_encargado() {
        return ci_encargado;
    }

    public void setCi_encargado(long ci_encargado) {
        this.ci_encargado = ci_encargado;
    }

    public String getNombre_encargado() {
        return nombre_encargado;
    }

    public void setNombre_encargado(String nombre_encargado) {
        this.nombre_encargado = nombre_encargado;
    }

    public String getCargo_encargado() {
        return cargo_encargado;
    }

    public void setCargo_encargado(String cargo_encargado) {
        this.cargo_encargado = cargo_encargado;
    }

    public Set<Pasantia> getPasantias() {
        return pasantias;
    }

    public void setPasantias(Set<Pasantia> pasantias) {
        this.pasantias = pasantias;
    }
    
    
}
