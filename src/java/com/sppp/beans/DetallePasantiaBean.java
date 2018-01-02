/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DetallePasantiaDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jairo
 */
@ManagedBean
public class DetallePasantiaBean {
    
      List<Object[]> empData2=null;//lista table pasantias y practicas pre profesionales
    List<Object[]> empData3=null;//tabla

    public List<Object[]> getEmpData3() {
        return empData3;
    }
   int id_tabla;

    public int getId_tabla() {
        return id_tabla;
    }

    public void setId_tabla(int id_tabla) {
        this.id_tabla = id_tabla;
    }
   
    public List<Object[]> getEmpData2() {
        DetallePasantiaDAO dpDAO =new DetallePasantiaDAO();
        empData2=dpDAO.findAllDetallePasantiaconCIAllTrue();
        return empData2;
    }

   

   public void init(){
       DetallePasantiaDAO dpDAO =new DetallePasantiaDAO();
       switch(id_tabla){
           case 1:
               empData3=dpDAO.findAllDetallePasantiaconCIValidaInicioProceso();
               break;
           case 2:
              empData3=dpDAO.findAllDetallePasantiaconCIValidaCartaCompromiso();
               break;
           default:
               break;
       }
       
       
       
   } 

    
    
    
    
}
