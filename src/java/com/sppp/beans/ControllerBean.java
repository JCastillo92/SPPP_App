/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
/**
 *
 * @author
 */
@ManagedBean(name="controllerBean")
@SessionScoped
public class ControllerBean {
   

    java.util.Date data;
       java.util.Date time;
      
        SimpleDateFormat sdf_data = new SimpleDateFormat("dd-MM-yyyy");  
   SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm");  
       private String nombre_est="";
     private String console="----------";
       private String fechaConFormato ="----------"; 
      private String horaConFormato ="----------"; 
      private String envioCita ="Aún no cuenta con una cita previa";
      private String fecha="-------------------";
      private String hora="-------------------";
      private String nombre="------------------";
     private   String total="------------------";
     
     private   String total1="------------------";
     private   String total2="------------------";
     private   String total3="------------------";
     
     private   String total4="------------------";
     
     private   String total5="------------------";
      private String observaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_est() {
        return nombre_est;
    }

    public void setNombre_est(String nombre_est) {
        this.nombre_est = nombre_est;
    }
 
    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }
   
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

   

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
      
      
      public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFechaConFormato() {
        return fechaConFormato;
    }

    public void setFechaConFormato(String fechaConFormato) {
        this.fechaConFormato = fechaConFormato;
    }

    public String getHoraConFormato() {
        return horaConFormato;
    }

    public void setHoraConFormato(String horaConFormato) {
        this.horaConFormato = horaConFormato;
    }

    public String getEnvioCita() {
        return envioCita;
    }

    public void setEnvioCita(String envioCita) {
        this.envioCita = envioCita;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal1() {
        return total1;
    }

    public void setTotal1(String total1) {
        this.total1 = total1;
    }

    public String getTotal2() {
        return total2;
    }

    public void setTotal2(String total2) {
        this.total2 = total2;
    }

    public String getTotal3() {
        return total3;
    }

    public void setTotal3(String total3) {
        this.total3 = total3;
    }

    public String getTotal4() {
        return total4;
    }

    public void setTotal4(String total4) {
        this.total4 = total4;
    }

    public String getTotal5() {
        return total5;
    }

    public void setTotal5(String total5) {
        this.total5 = total5;
    }

    
  
     
  public void imprimirData(){
      
        FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.addMessage(null, new FacesMessage("La fecha debe ser de Lunes a Viernes"));
      System.out.println("hola  "+ observaciones);
      
  }
  
  public void observacion(){
      observaciones=" Observaciones:";
  }
  
  
    public void enviarCita(){
        horaConFormato= sdf_time.format(time);
        fechaConFormato = sdf_data.format(data); 
        console="Ing. Rodas";
        envioCita="Ud cuenta con una cita previa por confirmar";
            System.out.println("nombre"+console+"dataaaa" + fechaConFormato+"timeeee"+ horaConFormato);
    }
    public void blanqueo(){
        observaciones="";
        envioCita ="!!! Ud ya ha confirmado una cita con el tutor !!!!";
          System.out.println("nombresitoooo "+console+" dataaaa " + fechaConFormato+" timeeee"+ horaConFormato);
    }
    
    
    public void envioObservacion(){
         console="----------";
        fechaConFormato ="----------"; 
       horaConFormato ="----------"; 
        envioCita ="En espera de confirmación de parte del tutor";
        observaciones="";
    }
  public void enviarCitaTut(){
        fecha= sdf_time.format(time);
        hora = sdf_data.format(data); 
        nombre=nombre_est;   
        agregar();
        blanqueo();
    }
    
    /** evento para fecha seleccionado de agregar cita*/
  public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Fecha Seleccionada", format.format(event.getObject())));
   }
   /** convertir fecha en dias de la semana agregar cita*/
  public void agregar(){
	int dia;
 FacesContext context = FacesContext.getCurrentInstance();    
 SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
   
 GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(data);
        dia=cal.get(Calendar.DAY_OF_WEEK);
      
        hora= sdf_time.format(time);
        fecha = sdf_data.format(data); 
        System.out.println("sdgsfgfdgfsgsf"+dia);
        if(dia==6){
              
                        total4="!!PASANTIA!! "+"Cita con Est: "+nombre_est+" Fecha:    "+fecha+"   Hora:  "+hora;

        }
        if(dia==2){
                       total="!!PASANTIA!! "+"Cita con Est: "+nombre_est+" Fecha:    "+fecha+"   Hora:  "+hora;
        
        }
        
        if(dia==3){
                         total1="!!PASANTIA!! "+"Cita con Est: "+nombre_est+" Fecha:    "+fecha+"   Hora:  "+hora;
     
        }
        
        if(dia==4){
                          total2="!!PASANTIA!! "+"Cita con Est: "+nombre_est+" Fecha:    "+fecha+"   Hora:  "+hora;
  }
        if(dia==5){
                        total3="!!PASANTIA!! "+"Cita con Est: "+nombre_est+" Fecha:    "+fecha+"   Hora:  "+hora;
   
        }
        
        if(dia==7){
                        total5="!!PASANTIA!! "+"Cita con Est: "+nombre_est+" Fecha:    "+fecha+"   Hora:  "+hora;
   
        } 
        
        }
  
  
}
  


