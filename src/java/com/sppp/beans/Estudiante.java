/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.EstudianteDAO;
import com.sppp.utils.SessionUtils;
import java.util.Set;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jairo
 */
public class Estudiante{
    
    private long cedula;
    private int ultimoNivel;
    private int horasPasantia;
    private int porcentajeMateriasAprobadas;
    private String actividadRealizar;
    private Usuario usuario;
    private Set<Pasantia> pasantia;

    public Set<Pasantia> getPasantia() {
        return pasantia;
    }

    public void setPasantia(Set<Pasantia> pasantia) {
        this.pasantia = pasantia;
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
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
        horasPasantia = 200;
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

    public Estudiante() {
        /*
        HttpSession session = SessionUtils.getSession();
        int perfil;
        long id;
        //Obtengo el perfil
        try {
            perfil = (int)session.getAttribute("perfil");
        } catch (Exception e) {
            perfil = 0;
        }
        
        //Lo clasifico con sus datos
        if (perfil == 1){
            System.out.println("============= Bienvenido a Usuario ===================");
            id = (long) session.getAttribute("id");
            
            //TraerData
            EstudianteDAO eDAO = new EstudianteDAO();
            eDAO.encontrarEst(id);
            
        }
        */
        
        
    }
    
    
}
