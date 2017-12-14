/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.VisitaDAO;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.Set;
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
   
private Usuario usuario = new Usuario();
  private long id_visita;
    private Date fecha_visita;
    private String hora_visita;
    private boolean estado_visita;
    private boolean confirmada;
   private Tutor tutor= new Tutor();
   private String listaest;
    
    java.util.Date data;
       java.util.Date time;
      
        SimpleDateFormat sdf_data = new SimpleDateFormat("dd-MM-yyyy");  
   SimpleDateFormat sdf_time = new SimpleDateFormat("HH:mm");  
       private String nombre_est="";
     private String console="----------";
       private String fechaConFormato ="----------"; 
      private String horaConFormato ="----------"; 
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
      
     private String boton="btn btn-success btn-circle";

    public String getBoton() {
        return boton;
    }

    public void setBoton(String boton) {
        this.boton = boton;
    }
     

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

    public long getId_visita() {
        return id_visita;
    }

    public void setId_visita(long id_visita) {
        this.id_visita = id_visita;
    }

    public Date getFecha_visita() {
        return fecha_visita;
    }

    public void setFecha_visita(Date fecha_visita) {
        this.fecha_visita = fecha_visita;
    }

    public String getHora_visita() {
        return hora_visita;
    }

    public void setHora_visita(String hora_visita) {
        this.hora_visita = hora_visita;
    }

    public boolean isEstado_visita() {
        return estado_visita;
    }

    public void setEstado_visita(boolean estado_visita) {
        this.estado_visita = estado_visita;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public String getListaest() {
        return listaest;
    }

    public void setListaest(String listaest) {
        this.listaest = listaest;
    }

      public void guardarDatos(String id,String id2){
        
        Set<VisitaTutor> setVisita = new LinkedHashSet<>();
       Long id1=Long.parseLong(id);
       tutor.setCedula(id1);
          
       Long id3=Long.parseLong(id2);    
        Estudiante est = new Estudiante();
        est.setCedula(id3);
        
        VisitaTutor vt = new VisitaTutor();
        vt.setId_visita(id_visita);
        vt.setFecha_visita(data);
         vt.setHora_visita(horaConFormato);
        vt.setConfirmada(false);
        vt.setEstado_visita(false);
        vt.setTutor(tutor);
        vt.setEstudiante(est);
          System.out.println("tutor"+tutor.getCedula());
        setVisita.add(vt);
        
        VisitaDAO vi= new VisitaDAO();
        vi.guardarDatosVisita(vt);
          System.out.println(vt.getId_visita());
        try {
            
        } catch (Exception e) {
            
        }
        
    }
     public void updateVisita(long id_visita){
          VisitaTutor newVisitaTutor = new VisitaTutor();
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.updateVisita(id_visita, newVisitaTutor);
          //agregar();
         
                  System.out.println("jaaaaaaaaaaaaaaaaaaaaaaa"+id_visita);
      }
     
      public void updateVisitaAgendada(long id_visita2){
          VisitaTutor newVisitaTutor = new VisitaTutor();
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.updateVisitaAgendada(id_visita2, newVisitaTutor);
                    System.out.println("jaaaaaaaaaaaaaaaaaaaaaaajeeeeeeee"+id_visita2);
      }
     
      public String deleteVisita(long id){
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.deleteVisita(id);
           
          return "confirma_cita_est";
      }
      
  public void imprimirData(){
      
        FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.addMessage(null, new FacesMessage("La fecha debe ser de Lunes a Viernes"));
      System.out.println("hola  "+ observaciones);
      
  }
  
  public void observacion(){
      observaciones=" Observaciones:";
  }
  
  
    public void enviarCita(String id, String id2){
        horaConFormato= sdf_time.format(time);
        fechaConFormato = sdf_data.format(data); 
        
            System.out.println("nombre"+console+"dataaaa" + fechaConFormato+"timeeee"+ horaConFormato);
        guardarDatos(id, id2);
        
        System.out.println("pasoooooooooooooooooooooooo");
    }
    public void blanqueo(){
        observaciones="";
       
           }
    
    
    public void envioObservacion(){
        
       
        observaciones="";
    }
  public void enviarCitaTut(){
        fecha= sdf_time.format(time);
        hora = sdf_data.format(data); 
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
  


