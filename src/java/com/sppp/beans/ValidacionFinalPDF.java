/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DatosDAO;
import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.UsuarioDAO;
import com.sppp.DAO.VisitaDAO;
import com.sppp.mailing.MailingMain;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author DidiAndy
 */
@ManagedBean
@ViewScoped
public class ValidacionFinalPDF {


    private boolean archivo1;
    private boolean archivo2;
    private boolean archivo3;
    
    
    private String obs;
    private String errores;

    public boolean isArchivo1() {
        return archivo1;
    }

    public void setArchivo1(boolean archivo1) {
        this.archivo1 = archivo1;
    }

    public boolean isArchivo2() {
        return archivo2;
    }

    public void setArchivo2(boolean archivo2) {
        this.archivo2 = archivo2;
    }

    public boolean isArchivo3() {
        return archivo3;
    }

    public void setArchivo3(boolean archivo3) {
        this.archivo3 = archivo3;
    }

    public String getErrores() {
        return errores;
    }

    public void setErrores(String errores) {
        this.errores = errores;
    }


    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    
    public void guardarDatos(long est,long visita,String correo){
        System.out.println("bbbb"+archivo1+archivo2+archivo3);
        //Compruebo si cumple todos los checks
        
        if(archivo1 == false && archivo2 && archivo3){
            errores="Error: Autoevaluación";
        }else 
         if(archivo2 == false && archivo1 && archivo3){
             errores="Error: Certificado de culminación la actividad";
        }else 
         if(archivo3 == false && archivo2 && archivo1){
             errores="Error: Derecho de validación";
        }else 
         if(archivo1 == false && archivo2 == false && archivo3){
             errores="Error: Autoevaluación y Certificado de culminación la actividad";
        }else 
         if(archivo1 == false && archivo3 == false && archivo2){
             errores="Error: Autoevaluación y Derecho de validación";
        }else 
         if(archivo2 == false && archivo3 == false && archivo1){
             errores="Error: Certificado de culminación la actividad y Derecho de validación";
        }else
         if(archivo1 == false && archivo2 == false && archivo3 == false){errores="Error: Cuenta con error en los 3 documentos";}
        
        
           if(archivo1 && archivo2 && archivo3 ){
            VisitaDAO vi = new VisitaDAO();
            vi.resolucion(est);
            
            MailingMain por = new MailingMain();
      por.mensajes(2, correo, obs);
            
            ControllerBean con = new ControllerBean();
            con.updateListoVisita(visita);
            }else {
               String msg=obs +"\n"+errores;
               MailingMain por = new MailingMain();
      por.mensajes(1, correo, msg);
         VisitaDAO vi = new VisitaDAO();
            vi.resolucion2(est);
           }
     //   return "review_window";
    }

}
