/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.utils.SessionUtils;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
public class Navegacion {
    
    private int perfil;
    
    public Navegacion() {
        
        HttpSession session = SessionUtils.getSession();
        perfil = (int) session.getAttribute("perfil");
        
    }
    
    public String redireccionamientoCambioClave(){
        switch(perfil){
            case 1:
                return "/user/estudiantes/estChPas.xhtml";
            case 2:
                return "/user/gestores/gestChPas.xhtml";
            case 3:
                return "/user/tutor/tutChPas.xhtml";
            case 5:
                return "/user/secretaria/secChPas.xhtml";
            case 6: 
                return "/user/coordinador/coorChPas.xhtml";
        }
        
        return null;
    }
    
    public String redireccionamientoHome(){

        //Ruteo segun el perfil
        switch(perfil){
            case 1:
                return "/user/estudiantes/dashboard_est.xhtml";
            case 2:
                return "/user/gestores/dashboard_gestor.xhtml";
            case 3:
                return "/user/tutor/tutor.xhtml";
            case 5:
                return "/user/secretaria/dashboard_secretaria.xhtml";
            case 6: 
                return "/user/coordinador/coordinator.xhtml";
        }
        
        return null;
        
    }
    
}
