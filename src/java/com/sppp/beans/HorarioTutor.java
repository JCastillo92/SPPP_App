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
public class HorarioTutor {
    private long id_horario;
    private String hora;
    private String dia;
    private PeriodoTutor periodoTutor;
    
    public long getId_horario() {
        return id_horario;
    }

    public void setId_horario(long id_horario) {
        this.id_horario = id_horario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public PeriodoTutor getPeriodoTutor() {
        return periodoTutor;
    }

    public void setPeriodoTutor(PeriodoTutor periodoTutor) {
        this.periodoTutor = periodoTutor;
    }
    
    
    
    
}
