/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.CampoDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    
    //CONTENIDO DE PRUEBA
    private Map<String, Object> respuestas_obtenidas = new HashMap<>();

    public Map<String, Object> getRespuestas_obtenidas() {
        return respuestas_obtenidas;
    }

    public void setRespuestas_obtenidas(Map<String, Object> respuestas_obtenidas) {
        this.respuestas_obtenidas = respuestas_obtenidas;
    }
    
    public void guardarDatos(){
        
        System.out.println("Punto de quiebre");
        
    }

    //FIN CONTENIDO PRUEBA
    
    
    private List<Campo> camposFormulario = new ArrayList();

    public List<Campo> getCamposFormulario() {
        return camposFormulario;
    }

    public List<Campo> getCamposFormulario(int formulario) {
        CampoDAO cd = new CampoDAO();
        camposFormulario = cd.obternerCampos(formulario);
        
        for (Iterator<Campo> iterator = camposFormulario.iterator(); iterator.hasNext();) {
            Campo next = iterator.next();
            respuestas_obtenidas.put(next.getNombre(), null);
            
        }
        
        
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

    
    
}
