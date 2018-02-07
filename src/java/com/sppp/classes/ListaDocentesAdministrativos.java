/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.classes;

import com.sppp.DAO.EmailDAO;

/**
 *
 * @author Jairo
 */
public class ListaDocentesAdministrativos {
    public String nombreDocenteAdministrativo(int codigo_cargo){
        String retorno="",
                DireccionCarreraSistemas="\nING. PATSY MALENA PRIETO MSc. "
                + "\nDIRECTORA DE LA CARRERA DE INGENIERÍA DE SISTEMAS",
                Secretaria="\nSecretaria de la UPS",
                ConsejoCarreraSistemas="\nConsejo Carrera Sistemas",
                DelegadoUPS="\nMgst. LOLA VASQUEZ. \nDirectora técnica de vinculación UPS. \n3962800 ext.2167"
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
                retorno=DelegadoUPS;
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
    
    
    public String corrreoDocenteAdministrativo(int codigo_correo){
        String devuelvo_correo="",
                DireccionCarreraSistemas="",
                Secretaria="",
                ConsejoCarreraSistemas="",
                DelegadoUPS="",
                Gestor=""
                ;
        switch(codigo_correo){
            case 1:
                devuelvo_correo=DireccionCarreraSistemas;
                break;
            case 2:
                devuelvo_correo=Secretaria;
                break;
            case 3:
                devuelvo_correo=ConsejoCarreraSistemas;
                break;
            case 5:
                devuelvo_correo=DelegadoUPS;
                break;
            case 6:
                //Gestor="jfloresg1@est.ups.edu.ec"
                EmailDAO obj=new EmailDAO();
                Gestor=obj.searchForEmailGestor();//solo me aseguro que es para gestor
                devuelvo_correo=Gestor;//mando el estrin al string para cumplir con el CASE
                break;
            default:
                break;
        }    
        return devuelvo_correo;
    }
}
