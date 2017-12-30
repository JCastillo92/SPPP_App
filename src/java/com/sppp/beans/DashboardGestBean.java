/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.PasantiaDAO;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jairo
 */
@ManagedBean
public class DashboardGestBean {
    private int numeroPA;
    private int numeroPP;

    public int getNumeroPP() {
        PasantiaDAO obj=new PasantiaDAO();
        numeroPP=obj.countPP();
        return numeroPP;
    }
    
    public int getNumeroPA() {
        PasantiaDAO obj=new PasantiaDAO();
        numeroPA=obj.countPA();
        return numeroPA;
    }
    
    
    
    
}
