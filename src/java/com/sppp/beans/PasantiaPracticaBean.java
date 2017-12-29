/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.PasantiaPracticaDAO;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author EstJhonAlexanderCast
 */
@ManagedBean
public class PasantiaPracticaBean {
    
    List<Pasantia> procesos = new LinkedList<>();
    
    public List<Pasantia> findAll(){
        
        
        return procesos;
    }

    public List<Pasantia> getProcesos() {
        PasantiaPracticaDAO ppDAO = new PasantiaPracticaDAO();
        procesos = ppDAO.findAll();
        return procesos;
    }
    
}
