/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author EstJhonAlexanderCast
 */
public abstract class WizardDB {
     
    protected Usuario usuario = new Usuario();
    protected Estudiante est = new Estudiante();
    protected Empresa emp = new Empresa();
    protected Encargado enc = new Encargado();
    protected Pasantia p = new Pasantia();
    protected String tipo_p;

    public Pasantia getP() {
        return p;
    } 

    public void setP(Pasantia p) {
        this.p = p;
    }

    public String getTipo_p() {
        return tipo_p;
    }

    public void setTipo_p(String tipo_p) {
        this.tipo_p = tipo_p;
    }
    
    protected boolean skip;

    public Encargado getEnc() {
        return enc;
    }

    public void setEnc(Encargado enc) {
        this.enc = enc;
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
    
    //CONTENIDO DE PRUEBA
    protected Map<String, Object> respuestas_obtenidas = new HashMap<>();

    public Map<String, Object> getRespuestas_obtenidas() {
        return respuestas_obtenidas;
    }

    public void setRespuestas_obtenidas(Map<String, Object> respuestas_obtenidas) {
        this.respuestas_obtenidas = respuestas_obtenidas;
    }
    
}
