/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DashboardTutDAO;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author KarenVanessaAchigGua
 */

@ManagedBean
public class DetallesDashboardTut {

      List<Object[]> listarcita=null;

    public List<Object[]> getListarcita() {
        DashboardTutDAO llamar=new DashboardTutDAO();
       listarcita= llamar.findAllDetallePasantiaconcita();
        return listarcita;
    }
    public DetallesDashboardTut() {
        this.listarcita=listarcita;
    }
    
    
}