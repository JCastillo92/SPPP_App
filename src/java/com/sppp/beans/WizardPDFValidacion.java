/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.mailing.MailingMain;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jairo
 */

@ManagedBean
public class WizardPDFValidacion {
    int id_estudiante;

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }
      
    public void init(){
        
    }
    
}
