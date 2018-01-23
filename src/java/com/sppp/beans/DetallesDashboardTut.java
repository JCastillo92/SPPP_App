/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.CitasDao;
import com.sppp.DAO.CitasDaoImp;
import com.sppp.DAO.DashboardTutDAO;
import com.sppp.DAO.DatosTutDAO;
import com.sppp.DAO.DetallePasantiaDAO;
import com.sppp.DAO.PasantiaDAO;
import com.sppp.DAO.PeriodoDAO;
import com.sppp.DAO.VisitaDAO;
import com.sppp.classes.AlmacenamientoPDF;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.sppp.mailing.MailingMain;
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
      
      List<Object[]> listarInforEst=null;
      List<Object[]> listarCoordinadorResolicion=null;
      String periodo;
      int horas;
      String id;
      String codigo_resolucion_final;
      String telefono;
      String direccion;
      String observaciones_finales;
      
      
public Pasantia pasantia;

    public String getObservaciones_finales() {
        return observaciones_finales;
    }

    public void setObservaciones_finales(String observaciones_finales) {
        this.observaciones_finales = observaciones_finales;
    }



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

    public List<Object[]> getListarInforEst(long user) {
                      DashboardTutDAO llamar=new DashboardTutDAO();
  listarInforEst=llamar.listarInforEst(user);
        return listarInforEst;
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

    public String getDireccion(long cedula) {
         AlmacenamientoPDF llamar=new AlmacenamientoPDF();
        direccion=llamar.direccion_est(cedula);
       
        return direccion;
    }

    
    
    
    public String getTelefono(long cedula) {
        
        AlmacenamientoPDF llamar=new AlmacenamientoPDF();
        telefono=llamar.telefono_est(cedula);
        return telefono;
    }

    
    
    public int getHoras(long user) {
            CitasDaoImp llamar=new CitasDaoImp();
        horas=llamar.horas(user);
    
        return horas;
    }
    
    public String resolucion(long user,String correo){
        
       DashboardTutDAO llamar=new DashboardTutDAO();
     llamar.resolucion(user, codigo_resolucion_final);
     
     
     
     VisitaDAO visita = new VisitaDAO();
     visita.resUltimo2(user);
     
        MailingMain mail  = new MailingMain();
        mail.mensajes(9, correo, "vacio");
    
    return "review_window";
    }

    public DetallesDashboardTut() {
        this.periodo = periodo;
        this.horas = horas;
    }

    public String reporte_coor(long user){
        
      SimpleDateFormat sdf_data = new SimpleDateFormat("dd-MM-yyyy"); 
        DateFormat formatoHora = new SimpleDateFormat("HH-mm-ss");
         java.util.Date fecha = new Date();
         String fecha1=sdf_data.format(fecha);
      String hora=formatoHora.format(fecha);
            AlmacenamientoPDF obj_crearpdf = new AlmacenamientoPDF();
            obj_crearpdf.create_student_folder_first_time(user);
           obj_crearpdf.create_coordinador_folder_first_time(user);
             obj_crearpdf.listar(user,fecha1,hora,observaciones_finales);
       
      List<Object[]> estudiantes;
DashboardTutDAO llamar=new DashboardTutDAO();
      
  estudiantes=llamar.ListarCoordinador();
  VisitaDAO vi = new VisitaDAO();
   for (Object[] row : estudiantes) {
             long id=Long.parseLong(row[0].toString());
  vi.resUltimo(id);
   }
   
        
   
  return "review_window";
  }
  
}
