/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.EmpresaDAO;
import com.sppp.DAO.EncargadoDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.TutorDAO;
import com.sppp.DAO.UsuarioDAO;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jairo
 */
@ManagedBean
public class WizardSolResolValidacion {
     private Usuario usuario = new Usuario();//jairo
     private Usuario usuario_perfilTutor = new Usuario();//jairo
                private Pasantia pasantia=new Pasantia();//jairo
                private Tutor tutor=new Tutor();
     
                Map<String,Long> hm_tutores=null;
int id_estudiante;
    String cod_resolucion;
    Long ced_tutor_reasigna;
    
    public Map<String, Long> getHm_tutores() {
        return hm_tutores;
    }

    public void setHm_tutores(Map<String, Long> hm_tutores) {
        this.hm_tutores = hm_tutores;
    }

    public Long getCed_tutor_reasigna() {
        return ced_tutor_reasigna;
    }

    public void setCed_tutor_reasigna(Long ced_tutor_reasigna) {
        this.ced_tutor_reasigna = ced_tutor_reasigna;
    }

    public String getCod_resolucion() {
        return cod_resolucion;
    }

    public void setCod_resolucion(String cod_resolucion) {
        this.cod_resolucion = cod_resolucion;
    }
    
    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }
    
    public void init(){
        UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id_estudiante);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(id_estudiante);
            
            //OBTENER EL map DE TUTORES o LISTA DE PERFIL 3
            UsuarioDAO uDAO_tut = new UsuarioDAO();
            hm_tutores = uDAO_tut.findAllUsuariosTutores();
            
            
            /*
            EncargadoDAO encarDAO=new EncargadoDAO();
            encargado=encarDAO.findEncargado(pasantia.getEncargado().getId_encargado());
            
            EmpresaDAO empreDAO = new EmpresaDAO();
            empresa=empreDAO.findEmpresa(encargado.getEmpresa().getId_empresa());
            */            

            
            
        
    }
    public String actualizarAlumnoTutor(){
        try {
        PasantiaDAO passDAO = new PasantiaDAO();
        
        pasantia.setCed_tutor_asignado(ced_tutor_reasigna);
        passDAO.actualizarPasantia(pasantia);
        } catch (Exception e) {
                    e.printStackTrace();
            }
        return null;
    }
    
    public String actualizarResolucion(){
           try {
        PasantiaDAO passDAO = new PasantiaDAO();
        
        pasantia.setCod_resolucion_consejo(cod_resolucion);
        passDAO.actualizarPasantia(pasantia);
        } catch (Exception e) {
                    e.printStackTrace();
            }
           return "dashboard_est";
    }
    
    
}
