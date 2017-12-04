/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.util.Set;

/**
 *
 * @author KarenVanessaAchigGua
 */
public class PeriodoTutor {
    private long id_tbpt;
    private int cantidad_visitas;
    private Set<HorarioTutor> horarioTutor ; 
    private Tutor tutor;
    private Periodo periodo;

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    

    public long getId_tbpt() {
        return id_tbpt;
    }

    public void setId_tbpt(long id_tbpt) {
        this.id_tbpt = id_tbpt;
    }

    public int getCantidad_visitas() {
        return cantidad_visitas;
    }

    public void setCantidad_visitas(int cantidad_visitas) {
        this.cantidad_visitas = cantidad_visitas;
    }

    public Set<HorarioTutor> getHorarioTutor() {
        return horarioTutor;
    }

    public void setHorarioTutor(Set<HorarioTutor> horarioTutor) {
        this.horarioTutor = horarioTutor;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    
}
