/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.sppp.DAO.CitasDao;
import com.sppp.DAO.CitasDaoImp;
import com.sppp.beans.Empresa;
import com.sppp.beans.Encargado;
import com.sppp.beans.Estudiante;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;


/**
 *
 * @author KarenVanessaAchigGua
 */
@ManagedBean(name = "datosFormatos")
public class DatosFormatos implements Serializable {
   
    private List<Pasantia> pasantia;
    Estudiante estudiante=new Estudiante();
    Usuario usuario=new Usuario();
    Encargado encargado=new Encargado();
    Empresa empresa=new Empresa();
    
    private String id;

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
   
  
 
    public DatosFormatos() {
        this.pasantia= new ArrayList<Pasantia>();
        
        
    }
   
    public List<Pasantia> getPasantia(String id) {
         
        CitasDao citasdao=new CitasDaoImp();
        this.pasantia=citasdao.findUser(id);
       
        return pasantia;
    }
    
    
    
}

    

