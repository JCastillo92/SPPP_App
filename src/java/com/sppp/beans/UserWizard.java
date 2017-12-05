/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.CampoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
@ViewScoped
public class UserWizard implements Serializable{
    
    private Usuario usuario = new Usuario();
    private Estudiante est = new Estudiante();
    private Empresa emp = new Empresa();
    private boolean skip;
    
    private List<Campo> camposFormulario = new ArrayList();

    public List<Campo> getCamposFormulario() {
        return camposFormulario;
    }

    public List<Campo> getCamposFormulario(int formulario) {
        CampoDAO cd = new CampoDAO();
        camposFormulario = cd.obternerCampos(formulario);
        
        return camposFormulario;
    }

    public Empresa getEmp() {
        return emp;
    }

    public void setEmp(Empresa emp) {
        this.emp = emp;
    }

    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estudiante getEst() {
        return est;
    }

    public void setEst(Estudiante est) {
        this.est = est;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    
    //Averiguar como usar este metodo
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    public void guardar(){
        //Realizar el proceso de guardado de datos
        
    }
    
    
}
