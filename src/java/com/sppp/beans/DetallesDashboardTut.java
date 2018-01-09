/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.CitasDao;
import com.sppp.DAO.CitasDaoImp;
import com.sppp.DAO.DashboardTutDAO;
import com.sppp.DAO.PeriodoDAO;
import com.sppp.DAO.VisitaDAO;
import com.sppp.classes.AlmacenamientoPDF;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
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
      List<Object[]> vista=null;
      List<Object[]> documento=null;
      List<Object[]> listarCoordinador=null;
      
      List<Object[]> listarCoordinadorResolicion=null;
      String periodo;
      int horas;
      String id;
      String codigo_resolucion_final;

    public String getCodigo_resolucion_final() {
        return codigo_resolucion_final;
    }

    public void setCodigo_resolucion_final(String codigo_resolucion_final) {
        this.codigo_resolucion_final = codigo_resolucion_final;
    }
      

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Object[]> getListarcita() {
        return listarcita;
    }

    public List<Object[]> getVista() {
        return vista;
    }

    public List<Object[]> getDocumento() {
        return documento;
    }
  

    public List<Object[]> getListarcita(long user) {
        DashboardTutDAO llamar=new DashboardTutDAO();
       listarcita= llamar.findAllDetallePasantiaconcita(user);
        return listarcita;
    }

    public List<Object[]> getVista(long user) {
           DashboardTutDAO llamar=new DashboardTutDAO();
     vista=llamar.findAllDetalleVisita(user);
        return vista;
    }

    public List<Object[]> getDocumento(long user) {
                DashboardTutDAO llamar=new DashboardTutDAO();
   documento=llamar.findAllDetalleDocumentos(user);
        return documento;
    }

    public List<Object[]> getListarCoordinador() {
                     DashboardTutDAO llamar=new DashboardTutDAO();
   listarCoordinador=llamar.ListarCoordinador();
        
        return listarCoordinador;
    }

    public List<Object[]> getListarCoordinadorResolicion() {
     DashboardTutDAO llamar=new DashboardTutDAO();
     listarCoordinadorResolicion=llamar.ListarCoordinador_Resolucion();
        return listarCoordinadorResolicion;
    }
    
    
    
    public String actividad(String n){
        String nombre;
        AlmacenamientoPDF llamar= new AlmacenamientoPDF();
        nombre=llamar.giveMeNamePPP(n);
        return nombre;
    }

 

    public String getPeriodo() {
               PeriodoDAO llamar=new PeriodoDAO();
  periodo= llamar.encontrarPeriodoActual1();

        return periodo;
    }

    public int getHoras(long user) {
            CitasDaoImp llamar=new CitasDaoImp();
        horas=llamar.horas(user);
    
        return horas;
    }
    
    public String resolucion(long user){
        
       DashboardTutDAO llamar=new DashboardTutDAO();
     llamar.resolucion(user, codigo_resolucion_final);
     
     VisitaDAO visita = new VisitaDAO();
     visita.resUltimo2(user);
    
    return "review_window";
    }

    public DetallesDashboardTut() {
        this.periodo = periodo;
        this.horas = horas;
    }

    
}
