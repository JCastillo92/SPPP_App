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
import javax.faces.bean.ManagedBean;

/**
 *
 * @author KarenVanessaAchigGua
 */
@ManagedBean(name = "citasAgendadas")

public class CitasAgendadas {

    private List<VisitaTutor> visitas;
    
    private List<VisitaTutor> visitasRealizadas;
    private Login login;
    private String nombre;
    
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
        this.nombre=nombre;
        this.coordinador=coordinador;
        
    }

    public List<VisitaTutor> getVisitas(String id) {
        
        CitasDao citasdao=new CitasDaoImp();
        this.visitas=citasdao.findAll(id);
       
       
        
        return visitas;
        
       
    }

    public String getNombre(String id) {
         CitasDao citasdao=new CitasDaoImp();
        this.nombre=citasdao.obtenerNombre(id);
        return nombre;
    }

    public String getCoordinador() {
         CitasDao citasdao=new CitasDaoImp();
        this.coordinador=citasdao.obtenerCoordinador("6");
        return coordinador;
    }

    public List<VisitaTutor> getVisitasRealizadas(String id) {
           CitasDao citasdao=new CitasDaoImp();
        this.visitasRealizadas=citasdao.listarVisitados(id);
     
        return visitasRealizadas;
    }
    public void pdf(){
   AlmacenamientoPDF crear=new AlmacenamientoPDF();
   crear.create_student_folder_first_time(123);
   crear.guardado_archivo_pdf_creado(123, 200);
   } 
    
}
