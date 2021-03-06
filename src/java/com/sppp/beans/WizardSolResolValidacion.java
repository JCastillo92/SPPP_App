/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.DAO.VisitaDAO;
import com.sppp.classes.ConfirmaCita;
import com.sppp.mailing.MailingMain;
import com.sppp.utils.SessionUtils;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jairo
 */
@ManagedBean
@ViewScoped
public class WizardSolResolValidacion {
     private Usuario usuario = new Usuario();//jairo
     private MailingMain email_aprobado=new MailingMain();
                private Pasantia pasantia=new Pasantia();//jairo
                List<Pasantia> empData=new LinkedList<>(); 
                private Usuario usuarioActual= new Usuario();//jairo

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
    
    public String actualizarResolucion(long tut, Date fechita){
        
        long est = Long.valueOf(id_estudiante);
        
          System.out.println("bryansi"+ "est"+est+"tutor"+tutor+"lolo"+tut);
           try {
        PasantiaDAO passDAO = new PasantiaDAO();
         VisitaDAO vi = new VisitaDAO();
         
       
         String agregaUnaObservacion="vacio";
         if(!cod_resolucion.equals("")){
             //preparo datos del USUARIO LOGUEADO (GESTOR)
            HttpSession session = SessionUtils.getSession();
                long id;
                id = (long) session.getAttribute("id");
                UsuarioDAO uDAO = new UsuarioDAO();
                usuarioActual = uDAO.findUsuario(id);
             
         //envio email al estudiante de aprobado
         agregaUnaObservacion="La Resolución de Inicio de Actividades es favorable. El código es: "+cod_resolucion+". Para la visita a las empresas por parte de los tutores es necesario que presenten a los tutores la resolución de consejo donde se autoriza el inicio de las actividades en las empresas. si no existe dicha resolución no se podrá realizar las visitas";
            email_aprobado.mensajes(3, usuario.getCorreo(), agregaUnaObservacion+"\n\nAtentamente:\n"+usuarioActual.getApellido()+" "+usuarioActual.getNombre()+"");
            
            //este mensaje le llegara al tutor asignado.
             ConfirmaCita confirma = new ConfirmaCita();
            
             //envio email al tutor asignado
            email_aprobado.mensajes(1009,confirma.getCorreo(tut) , "vacio");
         }
        pasantia.setCod_resolucion_consejo(cod_resolucion);//seteo el codigo de resolucion PART 1
        pasantia.setFecha_registro(fechita);
        passDAO.actualizarPasantia(pasantia);//guardo/actualizo  el codigo de resolucion de PART 1
        
        vi.updateEstudianteAgendado2(est);
        vi.confirmacion(est,tut); //llamada de JJ a BK (union de tesis)
               System.out.println("bryansi"+ "est"+est+"tutor"+tutor);
        } catch (Exception e) {
                    e.printStackTrace();
            }
           
           //return null;//null allows you to refresh the page like an F5.
           return "dashboard_gestor";
    }
    
    
}
