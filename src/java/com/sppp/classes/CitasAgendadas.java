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
    private Login login;
    private String nombre;
    private String apellido_est;
    
    private String coordinador;
    Tutor tutor=new Tutor();
    Estudiante estudiante=new Estudiante();
    
    Pasantia pasantia=new Pasantia();

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
        this.coordinador=citasdao.obtenerCoordinador("6");
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
      
    public void pdf(long cedula,int numero_pdf){
   AlmacenamientoPDF crear=new AlmacenamientoPDF();
  
        switch(numero_pdf){
                
             case 200:
               crear.pdf_InformeTutor(cedula, numero_pdf);
               
                break;
                case 201:
                crear.pdf_InformeSeguimientoTutor(cedula, numero_pdf);
               
                break;
                 case 203:
                crear.pdf_autoevaluacion(cedula, numero_pdf);
               
                break;
                 case 204:
                crear.pdf_solicitudFinal(cedula, numero_pdf);
               
                break;
            case 205:
                crear.pdf_InformeSeguimientoTutor(cedula, numero_pdf);
               
                break;
            default:
              System.out.println("No se ha encontrado dentro del case el numero para almacenar el .PDF");
break;
        }
                
  // crear.create_student_folder_first_time(123);
  // crear.guardado_archivo_pdf_creado(123, 200);
  // crear.guardado_archivo_pdf_creado(123, 201);
   
 //  crear.guardado_archivo_pdf_creado(123, 202);
   
  // crear.guardado_archivo_pdf_creado(123, 203);
   
  // crear.guardado_archivo_pdf_creado(123, 204);
   } 
    public void pdftut(long cedula,long cedula1,int numero_pdf){
   AlmacenamientoPDF crear=new AlmacenamientoPDF();
   crear.create_student_folder_first_time(cedula);
   crear.pdf_hojaRuta(cedula1,cedula,202);
    }
}
