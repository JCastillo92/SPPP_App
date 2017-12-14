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
import com.sppp.beans.Usuario;
import com.sppp.beans.VisitaTutor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;


@ManagedBean(name = "confirmaCita")

public class ConfirmaCita {

    private List<VisitaTutor> visitas;
    private List<VisitaTutor> confirmaVisitas;
    private List<SelectItem>listarEstudiantes;
    private Usuario estudiantes;

    public List<SelectItem> getListarEstudiantes() {
        this.listarEstudiantes=new ArrayList<SelectItem>();
        CitasDao citasDAO = new CitasDaoImp();
        List <Usuario> est=citasDAO.listar();
        
        for(Usuario est2: est){
            SelectItem listar = new SelectItem(est2.getId_cedula(),est2.getNombre());
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

    public List<VisitaTutor> getConfirmaVisitas(String id) {
        CitasDao citasdao=new CitasDaoImp();
        this.confirmaVisitas=citasdao.confirmaCita(id);
        return confirmaVisitas;
    }

    
  
}
