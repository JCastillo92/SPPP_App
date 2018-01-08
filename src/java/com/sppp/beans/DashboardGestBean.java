/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.PasantiaDAO;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jairo
 */
@ManagedBean
public class DashboardGestBean {
    private long numeroPA;
    private long numeroPP;
    private long numeroPPyPA;
    private long numeroIngresoDatosBasicos;
    private long numeroIngresoCartaCompromiso;
    private long numeroDetallePasantiaconCIValidaPDFs;

    public long getNumeroDetallePasantiaconCIValidaPDFs() {
        DetallePasantiaDAO obj=new DetallePasantiaDAO();
        numeroDetallePasantiaconCIValidaPDFs=obj.countAllDetallePasantiaconCIValidaPDFs();
        return numeroDetallePasantiaconCIValidaPDFs;
    }

    public long getNumeroIngresoCartaCompromiso() {
        DetallePasantiaDAO obj=new DetallePasantiaDAO();
        numeroIngresoCartaCompromiso=obj.countIngresoCartaCompromiso();
        return numeroIngresoCartaCompromiso;
    }

    public long getNumeroIngresoInicioActividad() {
        DetallePasantiaDAO obj=new DetallePasantiaDAO();
        numeroIngresoInicioActividad=obj.countIngresoInicioActividad();
        return numeroIngresoInicioActividad;
    }
    private long numeroIngresoInicioActividad;

    public long getNumeroIngresoDatosBasicos() {
        DetallePasantiaDAO obj=new DetallePasantiaDAO();
        numeroIngresoDatosBasicos=obj.countIngresoDatosBasicos();
        return numeroIngresoDatosBasicos;
    }

    public long getNumeroPPyPA() {
        PasantiaDAO obj=new PasantiaDAO();
        numeroPPyPA=obj.countPPyPA();
        return numeroPPyPA;
    }

    public long getNumeroPP() {
        PasantiaDAO obj=new PasantiaDAO();
        numeroPP=obj.countPP();
        return numeroPP;
    }
    
    public long getNumeroPA() {
        PasantiaDAO obj=new PasantiaDAO();
        numeroPA=obj.countPA();
        return numeroPA;
    }
    
    
    
    
}
