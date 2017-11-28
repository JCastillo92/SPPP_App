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
public class Estudiante{
    
    private String cedula;
    private int ultimoNivel;
    private int horasPasantia;
    private int porcentajeMateriasAprobadas;
    private String actividadRealizar;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getActividadRealizar() {
        return actividadRealizar;
    }

    public void setActividadRealizar(String actividadRealizar) {
        this.actividadRealizar = actividadRealizar;
    }

    public int getUltimoNivel() {
        return ultimoNivel;
    }

    public void setUltimoNivel(int ultimoNivel) {
        this.ultimoNivel = ultimoNivel;
    }

    public int getHorasPasantia() {
        return horasPasantia;
    }

    public void setHorasPasantia(int horasPasantia) {
        this.horasPasantia = horasPasantia;
    }

    public int getPorcentajeMateriasAprobadas() {
        return porcentajeMateriasAprobadas;
    }

    public void setPorcentajeMateriasAprobadas(int porcentajeMateriasAprobadas) {
        this.porcentajeMateriasAprobadas = porcentajeMateriasAprobadas;
    }
    
    
    
    
}
