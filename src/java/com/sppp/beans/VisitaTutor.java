/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author KarenVanessaAchigGua
 */
@ManagedBean
public class VisitaTutor implements java.io.Serializable{
    private long id_visita;
    private Date fecha_visita;
    private String hora_visita;
    private String estado_visita;
    private boolean confirmada;
    private String dia;
  
    private Tutor tutor;
    private Estudiante estudiante;
    
  
     public VisitaTutor() {
    }

   

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

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

    public String getEstado_visita() {
        return estado_visita;
    }

    public void setEstado_visita(String estado_visita) {
        this.estado_visita = estado_visita;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }



    public String getHora_visita() {
        return hora_visita;
    }

    public void setHora_visita(String hora_visita) {
        this.hora_visita = hora_visita;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

   
   
    
}
