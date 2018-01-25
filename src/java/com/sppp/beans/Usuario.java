/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.classes.ChangePassword;
import com.sppp.utils.SessionUtils;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jairo
 */
@ManagedBean
public class Usuario {
    
  private long id_cedula;
  private String correo;
  private String clave;
  private String nombre;
  private String apellido;
  private String telefono;
  private String direccion;
  private boolean estado;
  private String genero;
  private Perfil perfil;
  private Estudiante estudiante;
  private Tutor tutor;


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
  

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    
    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
  
    public long getId_cedula() {
        return id_cedula;
    }

    public void setId_cedula(long id_cedula) {
        this.id_cedula = id_cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }     
}
