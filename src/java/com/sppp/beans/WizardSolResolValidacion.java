/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.DAO.VisitaDAO;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jairo
 */
@ManagedBean
@ViewScoped
public class WizardSolResolValidacion {
     private Usuario usuario = new Usuario();//jairo
                private Pasantia pasantia=new Pasantia();//jairo
                List<Pasantia> empData=new LinkedList<>(); 

    public List<Pasantia> getEmpData() {
        return empData;
    }

    public Pasantia getPasantia() {
        return pasantia;
    }

    public void setPasantia(Pasantia pasantia) {
        this.pasantia = pasantia;
    }
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
        empData.clear();//vaciar la tabla
        UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id_estudiante);   
            
            PasantiaDAO passDAO=new PasantiaDAO();
            pasantia = passDAO.findPasantia(id_estudiante);
            empData.add(pasantia);
            
           

            //OBTENER EL map DE TUTORES o LISTA DE PERFIL 3
            UsuarioDAO uDAO_tut = new UsuarioDAO();
            hm_tutores = uDAO_tut.findAllUsuariosTutores();          
        
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
         VisitaDAO vi = new VisitaDAO();
       
         
         
        pasantia.setCod_resolucion_consejo(cod_resolucion);
        passDAO.actualizarPasantia(pasantia);
        vi.confirmacion(id_estudiante);//llamada de JJ a BK (union de tesis)
        } catch (Exception e) {
                    e.printStackTrace();
            }
           
           return null;//null allows you to refresh the page like an F5.
    }
    
    
}
