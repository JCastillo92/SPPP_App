/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

/**
 *
 * @author KarenVanessaAchigGua
 */
public class Periodo {
    private long id_periodo;
    private String periodo;
    private boolean estado_periodo;

    public long getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(long id_periodo) {
        this.id_periodo = id_periodo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public boolean isEstado_periodo() {
        return estado_periodo;
    }

    public void setEstado_periodo(boolean estado_periodo) {
        this.estado_periodo = estado_periodo;
    }
    
    
}
