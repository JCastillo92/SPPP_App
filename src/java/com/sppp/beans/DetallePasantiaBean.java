/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DetallePasantiaDAO;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jairo
 */
@ManagedBean
public class DetallePasantiaBean {
    List<Object[]> empData2=null;
 
    public List<Object[]> getEmpData2() {
        DetallePasantiaDAO dpDAO =new DetallePasantiaDAO();
        empData2=dpDAO.findAllDetallePasantiaconCIAllTrue();
        return empData2;
    }
    
}
