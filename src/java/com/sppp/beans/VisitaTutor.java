/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.util.Date;

/**
 *
 * @author KarenVanessaAchigGua
 */
public class VisitaTutor {
    private long id_visita;
    private Date fecha_visita;
    private boolean estado_visita;
    private Tutor tutor;

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    

    public long getId_visita() {
        return id_visita;
    }

    public void setId_visita(long id_visita) {
        this.id_visita = id_visita;
    }

    public Date getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(Date fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public boolean isEstado_visita() {
        return estado_visita;
    }

    public void setEstado_visita(boolean estado_visita) {
        this.estado_visita = estado_visita;
    }
    
    
    
}
