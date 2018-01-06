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
    String outcome_salida;

    public String getOutcome_salida() {
        return outcome_salida;
    }

    public void setOutcome_salida(String outcome_salida) {
        this.outcome_salida = outcome_salida;
    }

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
               outcome_salida="validarDatosBasicos";
               break;
           case 2:
              empData3=dpDAO.findAllDetallePasantiaconCIValidaCartaCompromiso();
              outcome_salida="validar_carta";
               break;
           case 3:
           empData3=dpDAO.findAllDetallePasantiaconCIValidaInicioActividades();
           outcome_salida="validarInicioPasantia";
           break;
           
           default:
               break;
       }
       
       
       
   } 

    
    
    
    
}
