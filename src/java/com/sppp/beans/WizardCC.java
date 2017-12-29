/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

/**
 *
 * @author KRUGER
 */
public abstract class WizardCC {

    protected Usuario usuario = new Usuario();//jairo
    protected Pasantia pasantia = new Pasantia();//jairo
    protected Encargado encargado = new Encargado();//jairo
    protected Empresa empresa = new Empresa();//jairo

    //Campo Oculto
    protected String carrera_grado;
    protected String tipo_actividad_academica;
    protected String objetoDeLaActividad;
    protected String horarioPrevisto;
    protected String nombrePrograma;
    protected String areaAcademica;
    protected String actividadPrevista;
    protected String resultadosPrevistos;
    protected String productosEntregables;
    protected String cargo;
    protected String delegadoUPS;
    protected String cargoDelegado;
    protected String telefonoDelegado;
    protected String lugarFecha; //Quito, 30-10-1992;
    
    public String getLugarFecha() {
        return lugarFecha;
    }

    public void setLugarFecha(String lugarFecha) {
        this.lugarFecha = lugarFecha;
    }

    public String getTelefonoDelegado() {
        //telefonoDelegado = "3962800 Ext.-2167";
        return telefonoDelegado;
    }

    public void setTelefonoDelegado(String telefonoDelegado) {
        this.telefonoDelegado = telefonoDelegado;
    }

    public String getCargoDelegado() {
        //cargoDelegado = "Directora Técnica de Vinculación UPS";
        return cargoDelegado;
    }

    public void setCargoDelegado(String cargoDelegado) {
        this.cargoDelegado = cargoDelegado;
    }

    public String getDelegadoUPS() {
        //delegadoUPS = "Lola Vazquez";
        return delegadoUPS;
    }

    public void setDelegadoUPS(String delegadoUPS) {
        this.delegadoUPS = delegadoUPS;
    }

    public String getCargo() {
        
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
                
                //Cambiar Tutor
                private String tutorXXX;

    public String getTutorXXX() {
        return tutorXXX;
    }

    public void setTutorXXX(String tutorXXX) {
        this.tutorXXX = tutorXXX;
    }
                

    public String getProductosEntregables() {
        return productosEntregables;
    }

    public void setProductosEntregables(String productosEntregables) {
        this.productosEntregables = productosEntregables;
    }

    public String getResultadosPrevistos() {
        return resultadosPrevistos;
    }

    public void setResultadosPrevistos(String resultadosPrevistos) {
        this.resultadosPrevistos = resultadosPrevistos;
    }

    public String getActividadPrevista() {
        return actividadPrevista;
    }

    public void setActividadPrevista(String actividadPrevista) {
        this.actividadPrevista = actividadPrevista;
    }

    public String getAreaAcademica() {
        return areaAcademica;
    }

    public void setAreaAcademica(String areaAcademica) {
        this.areaAcademica = areaAcademica;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }
                

    public String getHorarioPrevisto() {
        return horarioPrevisto;
    }

    public void setHorarioPrevisto(String horarioPrevisto) {
        this.horarioPrevisto = horarioPrevisto;
    }
                
                

    public String getObjetoDeLaActividad() {
        return objetoDeLaActividad;
    }

    public void setObjetoDeLaActividad(String objetoDeLaActividad) {
        this.objetoDeLaActividad = objetoDeLaActividad;
    }
                

    public String getTipo_actividad_academica() {
        if(pasantia.getTipo_ppp().equals("PA")){
            tipo_actividad_academica="pasantía";
        }
        if(pasantia.getTipo_ppp().equals("PP")){
            tipo_actividad_academica="práctica pre profesional";
        }
        return tipo_actividad_academica;
    }

    public void setTipo_actividad_academica(String tipo_actividad_academica) {
        this.tipo_actividad_academica = tipo_actividad_academica;
    }

    

    public String getCarrera_grado() {
        carrera_grado = "Ingenieria de Sistemas";
        return carrera_grado;
    }

    public void setCarrera_grado(String carrera_grado) {
        this.carrera_grado = carrera_grado;
    }
                

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pasantia getPasantia() {
        return pasantia;
    }

    public void setPasantia(Pasantia pasantia) {
        this.pasantia = pasantia;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    //Constructor
    public WizardCC() {
        
        //Datos Quemados Generales
        delegadoUPS="Lola Vazquez";;
        cargoDelegado="Directora Técnica de Vinculación UPS";
        telefonoDelegado="3962800 Ext.-2167";
        FechaSistema fc = new FechaSistema();
        lugarFecha= "Quito,  "+fc.fecha(); //Quito, 30-10-1992;
        cargo = "Gerente";
        
    }
    
    

}
