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
import com.sppp.beans.Usuario;
import com.sppp.beans.VisitaTutor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;


@ManagedBean(name = "confirmaCita")

public class ConfirmaCita {

    private List<VisitaTutor> visitas;
     private List<Usuario> usuarios;
    private List<VisitaTutor> confirmaVisitas;
    private List<SelectItem>listarEstudiantes;
    
    private Usuario estudiantes;
     private String nombre_est;
     private String apellido_est;
     private String correo;
     private String telefono;
     private String co_director;
     private String co_coord;
     
    public List<SelectItem> getListarEstudiantes(long user) {
        this.listarEstudiantes=new ArrayList<SelectItem>();
        CitasDao citasDAO = new CitasDaoImp();
        List <Pasantia> est=citasDAO.listar(user);
        
        for(Pasantia est2: est){
            SelectItem listar = new SelectItem(est2.getEstudiante().getCedula(),est2.getEstudiante().getUsuario().getNombre()+"  "+est2.getEstudiante().getUsuario().getApellido());
            this.listarEstudiantes.add(listar);
            
        }
        return listarEstudiantes;
    }


    public Usuario getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Usuario estudiantes) {
        this.estudiantes = estudiantes;
    }
    
    
    
    public ConfirmaCita() {
        this.visitas= new ArrayList<VisitaTutor>();
        this.confirmaVisitas= new ArrayList<VisitaTutor>();
        estudiantes=new Usuario();
        
    }

    public List<VisitaTutor> getVisitas(String id) {
        
        CitasDao citasdao=new CitasDaoImp();
        this.visitas=citasdao.confirma(id);
        return visitas;
       
    }

//cambio aca
    public String getNombre_est(long id) {
        
         CitasDao citasdao=new CitasDaoImp();
        this.nombre_est=citasdao.obtenerNombre(id);
        
        return nombre_est;
    }

    public String getApellido_est(long id) {
        CitasDao citasdao=new CitasDaoImp();
        this.apellido_est=citasdao.obtenerApellido(id);
        
        return apellido_est;
    }

    public String getCorreo(long id) {
        CitasDao citasdao=new CitasDaoImp();
        this.correo=citasdao.obtenerCorreo(id);
        return correo;
    }

    public String getTelefono(long id) {
         CitasDao citasdao=new CitasDaoImp();
        this.telefono=citasdao.obtenerTelefono(id);
        return telefono;
    }

    

    public String getCo_director() {
         CitasDao citasdao=new CitasDaoImp();
        this.co_director=citasdao.obtenerCorreoDirector(8);
        return co_director;
    }

    public String getCo_coord() {
         CitasDao citasdao=new CitasDaoImp();
        this.co_director=citasdao.obtenerCorreoDirector(6);
        return co_director;
    }
    
    
    
  
}
