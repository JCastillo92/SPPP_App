/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.sppp.DAO.CitasDao;
import com.sppp.DAO.CitasDaoImp;
import com.sppp.beans.Estudiante;
import com.sppp.beans.Login;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Tutor;
import com.sppp.beans.Usuario;
import com.sppp.beans.VisitaTutor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author KarenVanessaAchigGua
 */
@ManagedBean(name = "citasAgendadas")

public class CitasAgendadas {

    private List<VisitaTutor> visitas;
    
    private List<VisitaTutor> visitasRealizadas;
    
    private List<VisitaTutor> informeCoor;
    
    private List<VisitaTutor> visitasTutor;
    private Login login;
    private String nombre;
    private String apellido_est;
    
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
      
             
   
  
    
    
    
}
