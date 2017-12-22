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
                ConsejoCarreraSistemas="\nConsejo Carrera Sistemas",
                DelegadoUPS="\nNombre delegado UPS. \nDirectora técnica de vinculación UPS. \n3962800 ext.2167"
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
                DireccionCarreraSistemas="blarat@est.ups.edu.ec",
                Secretaria="kachig@est.ups.edu.ec",
                ConsejoCarreraSistemas="jfloresg1@est.ups.edu.ec",
                DelegadoUPS="jcastillor1@est.ups.edu.ec",
                RevisorInicioProcesoPasantia="jfloresg1@est.ups.edu.ec"
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
                devuelvo_correo=RevisorInicioProcesoPasantia;
                break;
            default:
                break;
        }    
        return devuelvo_correo;
    }
}
