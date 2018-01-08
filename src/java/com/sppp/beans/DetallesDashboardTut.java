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
import com.sppp.classes.AlmacenamientoPDF;
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
      List<Object[]> vista=null;
      List<Object[]> documento=null;
      List<Object[]> listarCoordinador=null;
      

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
    
    
    public String actividad(String n){
        String nombre;
        AlmacenamientoPDF llamar= new AlmacenamientoPDF();
        nombre=llamar.giveMeNamePPP(n);
        return nombre;
    }
   public String periodo(){
String periodo;
       PeriodoDAO llamar=new PeriodoDAO();
  periodo= llamar.encontrarPeriodoActual1();
   return periodo;
   }
    public int hors(long user){
        int horas;
        CitasDaoImp llamar=new CitasDaoImp();
        horas=llamar.horas(user);
        return horas;
    }
    
}
