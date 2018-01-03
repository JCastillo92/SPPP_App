/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.sppp.DAO.UsuarioDAO;
import com.sppp.beans.Usuario;

/**
 *
 * @author Jairo
 */
public class ChangePassword {
    
    private Usuario usuario = new Usuario();//jairo
    
    public boolean setNewPasswd(long id, String passMain,String newPass){
        boolean verdad=false;
        try {
                UsuarioDAO uDAO = new UsuarioDAO();
            usuario = uDAO.findUsuario(id);
            //aqui valido si la clave actual es igual a la clave ACTUAL-INGRESADA y de ahi cambio a la nueva clave
            if(usuario.getClave().equals(passMain)){
            usuario.setClave(newPass);
            uDAO.updateUserPassword(usuario);
            verdad=true;
            }else{
            verdad=false;    
            }
        } catch (Exception e) {
            e.printStackTrace();
            verdad=false;
        }
        return verdad;
    }

}
