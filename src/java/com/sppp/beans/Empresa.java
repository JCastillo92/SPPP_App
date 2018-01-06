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
public class Empresa {
    private long id_empresa;
    private String nombre_empresa;
    private String nombre_gerente;
    private String telefono_empresa;
    private String direccion_empresa;
    private String actividad_principal_empresa;
    private Set<Encargado> encargado;

    public Empresa() {
    }

    public Empresa(long id_empresa) {
        this.id_empresa = id_empresa;
    }

    
    
    public String getActividad_principal_empresa() {
        return actividad_principal_empresa;
    }

    public void setActividad_principal_empresa(String actividad_principal_empresa) {
        this.actividad_principal_empresa = actividad_principal_empresa;
    }
    

    public long getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(long id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getNombre_gerente() {
        return nombre_gerente;
    }

    public void setNombre_gerente(String nombre_gerente) {
        this.nombre_gerente = nombre_gerente;
    }

    public String getTelefono_empresa() {
        return telefono_empresa;
    }

    public void setTelefono_empresa(String telefono_empresa) {
        this.telefono_empresa = telefono_empresa;
    }

    public String getDireccion_empresa() {
        return direccion_empresa;
    }

    public void setDireccion_empresa(String direccion_empresa) {
        this.direccion_empresa = direccion_empresa;
    }

    public Set<Encargado> getEncargado() {
        return encargado;
    }

    public void setEncargado(Set<Encargado> encargado) {
        this.encargado = encargado;
    }
    
    
    
}
