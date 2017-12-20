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
public class ListaDocentesAdministrativos {
    public String nombreDocenteAdministrativo(int codigo_cargo){
        String retorno="",
                DireccionCarreraSistemas="\nING. PATSY MALENA PRIETO MSc. \nDirectora de la Carrera de Ingeniería de Sistemas",
                Secretaria="\nSecretaria de la UPS",
                ConsejoCarreraSistemas="\nConsejo Carrera Sistemas"
                
                ;
        try{
        switch(codigo_cargo){
            case 1:
                retorno=DireccionCarreraSistemas;
                break;
            case 2:
                retorno=Secretaria;
                break;
            case 3:
                retorno=ConsejoCarreraSistemas;
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            default:
                retorno="";
                break;
        }
        }catch(Exception e){
            System.out.println("Erro en clase ListaDocentesAdministrativos.java en el metodo nombreDocenteAdministrativo");
        }
        
        return retorno;
    }
}
