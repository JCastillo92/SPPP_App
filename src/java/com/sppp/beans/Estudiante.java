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
public class Estudiante extends Usuario{
    private int ultimoNivel;
    private int horasPasantia;
    private int porcentajeMateriasAprobadas;
    private String actividadRealizar;

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
