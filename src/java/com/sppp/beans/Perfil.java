/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.util.Set;
/**
 *
 * @author Jairo
 */
public class Perfil {

  private int id_tbperfil;
  private String descripcion;
  private Set<Usuario> usuarios;

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public int getId_tbperfil() {
        return id_tbperfil;
    }

    public void setId_tbperfil(int id_tbperfil) {
        this.id_tbperfil = id_tbperfil;
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
  
  
}
