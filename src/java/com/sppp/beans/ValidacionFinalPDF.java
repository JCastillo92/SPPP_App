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
    private boolean archivo4;
    
    private String obs;

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

    public boolean isArchivo4() {
        return archivo4;
    }

    public void setArchivo4(boolean archivo4) {
        this.archivo4 = archivo4;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    

    public String guardarDatos(long est,long visita,String correo){
        System.out.println("bbbb"+archivo1+archivo2+archivo3+archivo4);
        //Compruebo si cumple todos los checks
        
          //  if(archivo1 && archivo2 && archivo3 && archivo4){
            VisitaDAO vi = new VisitaDAO();
            vi.resolucion(est);
            
            MailingMain por = new MailingMain();
      por.mensajes(2, correo, obs);
            
            ControllerBean con = new ControllerBean();
            con.updateListoVisita(visita);
            //}
        return "coordinator";
    }

}
