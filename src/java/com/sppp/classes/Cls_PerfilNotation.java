/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

/**
 *
 * @author Jairo
 */
public class Cls_PerfilNotation {
    
    public String perfilChooser(int recive_perfil){
        String profile_name="0";
        if (recive_perfil==1){
            return profile_name="Estudiante";
        }else if(recive_perfil==2){
            return profile_name="Gestor";
        }else if(recive_perfil==3){
            return profile_name="Tutor";        
        }else if(recive_perfil==4){
            return profile_name="Consejo";        
        }else if(recive_perfil==5){
            return profile_name="Secretaria";
        }else if(recive_perfil==6){
            return profile_name="Coordinador";
        }else if(recive_perfil==7){
            return profile_name="Administrador";
        }
        return profile_name;
        }
}
