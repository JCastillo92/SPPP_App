/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.sppp.DAO.CitasDao;
import com.sppp.DAO.CitasDaoImp;
import com.sppp.DAO.VisitaDAO;
import com.sppp.beans.ControllerBean;
import com.sppp.beans.Estudiante;
import com.sppp.beans.Login;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Tutor;
import com.sppp.beans.VisitaTutor;
import com.sppp.mailing.MailingMain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



/**
 *
 * @author KarenVanessaAchigGua
 */
@ManagedBean(name = "citasAgendadas")
@ViewScoped
public class CitasAgendadas implements Serializable{

    private List<VisitaTutor> visitas;
    
    private List<VisitaTutor> visitasRealizadas;
    
    private List<VisitaTutor> informeCoor;
     private List<VisitaTutor> informeCoor2;
     
    private List<VisitaTutor> visitasTutor;
    private Login login;
    private String nombre;
    private String apellido_est;
    private long cedula_est;
    
    private String visitados;
    private String coordinador;
    private String nombre_completo;
    Tutor tutor=new Tutor();
    Estudiante estudiante=new Estudiante();
    VisitaTutor visita=new VisitaTutor();
    
    Pasantia pasantia=new Pasantia();

    public VisitaTutor getVisita() {
        return visita;
    }

    public void setVisita(VisitaTutor visita) {
        this.visita = visita;
    }

    
    public Pasantia getPasantia() {
        return pasantia;
    }

    public void setPasantia(Pasantia pasantia) {
        this.pasantia = pasantia;
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

    public long getCedula_est() {
        return cedula_est;
    }

    public void setCedula_est(long cedula_est) {
        this.cedula_est = cedula_est;
    }
    
    
    public CitasAgendadas() {
        this.visitas= new ArrayList<VisitaTutor>();
        
        this.informeCoor= new ArrayList<VisitaTutor>();
        this.nombre=nombre;
        this.coordinador=coordinador;
        
    }

    public List<VisitaTutor> getVisitas(String id) {
        
        CitasDao citasdao=new CitasDaoImp();
        this.visitas=citasdao.findAll(id);
       
       
        
        return visitas;
        
       
    }
    

    public String getNombre(long id) {
         CitasDao citasdao=new CitasDaoImp();
        this.nombre=citasdao.obtenerNombre(id);
        return nombre;
    }
    
     public String getApellido_est(long id) {
        CitasDao citasdao=new CitasDaoImp();
        this.apellido_est=citasdao.obtenerApellido(id);
        
        return apellido_est;
    }

    public String getCoordinador() {
         CitasDao citasdao=new CitasDaoImp();
        this.coordinador=citasdao.obtenerCoordinador(6);
        return coordinador;
    }

    public List<VisitaTutor> getVisitasRealizadas(long id) {
           CitasDao citasdao=new CitasDaoImp();
        this.visitasRealizadas=citasdao.listarVisitados(id);
     
        return visitasRealizadas;
    }
      public List<VisitaTutor> getInformeCoor() {
        CitasDao citasdao=new CitasDaoImp();
        this.informeCoor=citasdao.listarInformeCoor();
      
        return informeCoor;
    }

    public List<VisitaTutor> getInformeCoor2(long id) {
        CitasDao citasdao=new CitasDaoImp();
        this.informeCoor2=citasdao.listarInformeCoor2(id);
        return informeCoor2;
    }

   
      

    public List<VisitaTutor> getVisitasTutor(long user) {
         CitasDao citasdao=new CitasDaoImp();
        this.visitasTutor=citasdao.visitadosTuto(user);
      
        return visitasTutor;
    }

    public String getNombre_completo(long user) {
        CitasDaoImp llamar=new CitasDaoImp();
        nombre_completo=llamar.obtenerNombre(user)+"  "+llamar.obtenerApellido(user);
        return nombre_completo;
    }
      
             
   
   private boolean archivo1;
    private boolean archivo2;
    private boolean archivo3;
    
    
    private String obs;
    private String errores;

    public boolean isArchivo1() {
        return archivo1;
    }

    public void setArchivo1(boolean archivo1) {
        this.archivo1 = archivo1;
    }

    public boolean isArchivo2() {
        return archivo2;
    }

    public void setArchivo2(boolean archivo2) {
        this.archivo2 = archivo2;
    }

    public boolean isArchivo3() {
        return archivo3;
    }

    public void setArchivo3(boolean archivo3) {
        this.archivo3 = archivo3;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getErrores() {
        return errores;
    }

    public void setErrores(String errores) {
        this.errores = errores;
    }
    
    
     public String guardarDatos(long est,long visita,String correo){
        System.out.println("bbbb"+archivo1+archivo2+archivo3);
        //Compruebo si cumple todos los checks
        
        if(archivo1 == false && archivo2 && archivo3){
            errores="Error: Autoevaluación";
        }else 
         if(archivo2 == false && archivo1 && archivo3){
             errores="Error: Certificado de culminación la actividad";
        }else 
         if(archivo3 == false && archivo2 && archivo1){
             errores="Error: Derecho de validación";
        }else 
         if(archivo1 == false && archivo2 == false && archivo3){
             errores="Error: Autoevaluación y Certificado de culminación la actividad";
        }else 
         if(archivo1 == false && archivo3 == false && archivo2){
             errores="Error: Autoevaluación y Derecho de validación";
        }else 
         if(archivo2 == false && archivo3 == false && archivo1){
             errores="Error: Certificado de culminación la actividad y Derecho de validación";
        }else
         if(archivo1 == false && archivo2 == false && archivo3 == false){errores="Error: Cuenta con error en los 3 documentos";}
        
        
           if(archivo1 && archivo2 && archivo3 ){
            VisitaDAO vi = new VisitaDAO();
            vi.resolucion(est);
            
            MailingMain por = new MailingMain();
      por.mensajes(2, correo, obs);
            
            ControllerBean con = new ControllerBean();
            con.updateListoVisita(visita);
            }else {
               String msg=obs +"\n"+errores;
               MailingMain por = new MailingMain();
      por.mensajes(1, correo, msg);
         VisitaDAO vi = new VisitaDAO();
            vi.resolucion2(est);
           }
      return "review_window";
    }
    
    
    
}
