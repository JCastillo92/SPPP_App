/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.beans;

import com.sppp.DAO.DashboardTutDAO;
import com.sppp.DAO.VisitaDAO;
import com.sppp.classes.AlmacenamientoPDF;
import com.sppp.classes.CitasAgendadas;
import com.sppp.mailing.MailingMain;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;

import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author DidiAndy
 */
@ManagedBean(name="controllerBean")
@SessionScoped
public class ControllerBean {
   
private Usuario usuario = new Usuario();
  private long id_visita;
  private String dia;
    private Date fecha_visita;
    private String hora_visita;
    private String estado_visita;
   private Tutor tutor= new Tutor();
   private String listaest;
  private long numerotutor;
  private long numerotutor2; 
  private long numerotutor3;
  private long numerotutor4;
  private long numerotutor5;
  private long numerotutor6;
  
   private String mensajeMail;
   private String mensajeMail2;
   
   private String mensajeMail_asunto;
   private boolean paso=false;
   private boolean cancel=false;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    public String getEstado_visita() {
        return estado_visita;
    }

    public void setEstado_visita(String estado_visita) {
        this.estado_visita = estado_visita;
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

    public String getMensajeMail() {
        return mensajeMail;
    }

    public void setMensajeMail(String mensajeMail) {
        this.mensajeMail = mensajeMail;
    }

    public String getMensajeMail_asunto() {
        return mensajeMail_asunto;
    }

    public void setMensajeMail_asunto(String mensajeMail_asunto) {
        this.mensajeMail_asunto = mensajeMail_asunto;
    }

    public boolean isPaso() {
        return paso;
    }

    public void setPaso(boolean paso) {
        this.paso = paso;
    }

    public String getMensajeMail2() {
        return mensajeMail2;
    }

    public void setMensajeMail2(String mensajeMail2) {
        this.mensajeMail2 = mensajeMail2;
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    

    
    
      public void guardarDatos(String id,String id2,String dia){
        
        Set<VisitaTutor> setVisita = new LinkedHashSet<>();
       Long id1=Long.parseLong(id);
       tutor.setCedula(id1);
          
       Long id3=Long.parseLong(id2);    
        Estudiante est = new Estudiante();
        est.setCedula(id3);
        
        VisitaTutor vt = new VisitaTutor();
        vt.setId_visita(id_visita);
        vt.setDia(dia);
        vt.setFecha_visita(data);
         vt.setHora_visita(horaConFormato);
        vt.setEstado_visita("Enviada");
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
      
     public void updateVisita(long id_visita, String tutor, String apellido,String correo, String dia ,Date fecha, String hora,String est, String ap_est,String co_est,String tele_est ,long cedula_tuto,String cedula_est){
      
        fechaConFormato = sdf_data.format(fecha); 
        
         sendConfirmacion(tutor, apellido, correo, dia, fechaConFormato, hora, est, ap_est, co_est, tele_est);
          VisitaTutor newVisitaTutor = new VisitaTutor();
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.updateVisita(id_visita, newVisitaTutor);
          //agregar();
      VisitaDAO vi = new VisitaDAO();
       vi.visita_tut(cedula_tuto, id_visita, cedula_est);
       
      
                  System.out.println("jaaaaaaaaaaaaaaaaaaaaaaa"+id_visita);
      }
     public void updateCantidadVisita(long id_visita2){
          Tutor newTutor = new Tutor();
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.updateCantidadTutor(id_visita2, newTutor);
                    System.out.println("jaaaaaaaaaaaaaaaaaaaaaaajeeeeeeee"+id_visita2);
      }
     
      public String updateVisitaAgendada(long id_visita2, String cedula,String ced_est){
          long cedu= Long.parseLong(cedula);
          VisitaTutor newVisitaTutor = new VisitaTutor();
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.updateVisitaAgendada(id_visita2, newVisitaTutor);
                    System.out.println("jaaaaaaaaaaaaaaaaaaaaaaajeeeeeeee"+id_visita2);
                    updateCantidadVisita(cedu);
                    
                   
                 visitaDAO.validacion_visita(ced_est,cedu);
                 // visitaDAO.autoevaluacion(ced_est);
                    System.out.println("bryanttt"+ cedu+""+""+ced_est);
                    return "agendar_cita_tut";
      }
      
    /*   public String updateCompletado(long id_visita2){
          
          VisitaTutor newVisitaTutor = new VisitaTutor();
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.updateCompletado(id_visita2, newVisitaTutor);
                  
                   return "revision_window";
      }*/
       
       public String docs_tut(long ced_est){
          
          VisitaDAO visitaDAO = new VisitaDAO();
         
                  visitaDAO.autoevaluacion(ced_est);
                   
                    return "revision_window";
      }
       
        public void updateListoVisita(long id_visita2){
         
          VisitaTutor newVisitaTutor = new VisitaTutor();
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.updateListoVisita(id_visita2, newVisitaTutor);
                  
      }
       
      public String cargarArchivos(String correo){
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.solicitud();
          MailingMain por = new MailingMain();
      por.mensajes(1006, correo,"vacio");
          return"revision_window";
      }
      
       public String cargarArchivos2(String correo){
          MailingMain por = new MailingMain();
      por.mensajes(1006, correo,"vacio");
          return"revision_window";
      }
     
      public long getNumerotutor(String tutor) {
        VisitaDAO obj=new VisitaDAO();
        numerotutor=obj.countTut_agendacion(tutor);
        return numerotutor;
    }
      public long getNumerotutor2(String tutor) {
        VisitaDAO obj=new VisitaDAO();
        numerotutor2=obj.countTut_cita(tutor);
        return numerotutor2;
    }
       public long getNumerotutor3(String tutor) {
        VisitaDAO obj=new VisitaDAO();
        numerotutor3=obj.countTut_documentacion(tutor);
        return numerotutor3;
    }
        public long getNumerotutor4() {
        VisitaDAO obj=new VisitaDAO();
        numerotutor4=obj.countRevision();
        return numerotutor4;
    }
    
    public long getNumerotutor5() {
        VisitaDAO obj=new VisitaDAO();
        numerotutor5=obj.countReporte();
        return numerotutor5;
    }
    
    public long getNumerotutor6() {
        VisitaDAO obj=new VisitaDAO();
        numerotutor6=obj.countEstResol();
        return numerotutor6;
    }
    
    public String updateReporte(long id_visita2){
          VisitaTutor newVisitaTutor = new VisitaTutor();
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.updateReporte(id_visita2, newVisitaTutor);
                    System.out.println("jaaaaaaaaaaaaaaaaaaaaaaajeeeeeeee"+id_visita2);
                    return "reporte_coordinador";
      }
      
   
       public void deleteVisitaEst(long id,String tutor, String apellido,String correo,String est, String ap_est,String co_est,String tele_est,long id2){
           sendCancelacionEst(tutor,apellido,correo,est,ap_est,co_est,tele_est);
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.deleteVisita(id);
          visitaDAO.updateEstudianteAgendado1(id2);
        
      }
       
       public void deleteVisitaTut(long id,String tutor, String apellido,String correo,long id2){
           sendCancelacionTut(tutor,apellido,correo);
          VisitaDAO visitaDAO = new VisitaDAO();
          visitaDAO.deleteVisita(id);
          
           cancel=true;
          visitaDAO.updateEstudianteAgendado1(id2);
          
      }
      
  public void imprimirData(){
      
        FacesContext facesContext = FacesContext.getCurrentInstance();
                facesContext.addMessage(null, new FacesMessage("La fecha debe ser de Lunes a Viernes"));
      
      
  }
  
 
  
  public void sendTutor(String alumno, String apellido,String correo , String dia, String fecha_visita, String hora ){
     String observaciones="Estimado(a) alumno(a) "+alumno+" "+apellido+", la visita a la institución en la que realiza su pasantía se llevará a cabo el dia "+dia+" con fecha "+fecha_visita+" en la siguiente hora: "+ hora +"."+"\n"+" Porfavor confirmar la visita en el Sistema (SPPP).";
      MailingMain po = new MailingMain();
      
      po.mensajes(5, correo, observaciones);
      System.out.println("probarrrr");  
  }
 
public void sendConfirmacion(String tutor, String apellido, String correo, String dia, String fecha_visita, String hora ,String est, String ap_est,String co_est,String tele_est){
     String observaciones="Estimado(a) Ing. "+tutor+" "+apellido+", acepto que la visita se lleve a cabo el dia "+dia+" con fecha "+fecha_visita+" en la siguiente hora: "+ hora +"."+"\n"+"Observacion para visita:"+"\n"+ mensajeMail2+"\n"+"\n"+"**DATOS DEL ESTUDIANTE**"+"\n"+ "Nombre: "+est
             +" "+ap_est+"\n"+"Correo: "+co_est+"\n"+"Telefono: "+tele_est;
     
    MailingMain por = new MailingMain();
      por.mensajes(7, correo, observaciones);
      
    
}

public void sendCancelacionEst(String tutor, String apellido,String correo,String est, String ap_est,String co_est,String tele_est){
     String observaciones="Estimado(a) Ing. "+tutor+" "+apellido+", la visita no puede darse por el siguiente motivo:"+"\n"+mensajeMail+"\n"+" Espero una nueva fecha!!"+"\n"+"\n"+"**DATOS DEL ESTUDIANTE**"+"\n"+ "Nombre: "+est
             +" "+ap_est+"\n"+"Correo: "+co_est+"\n"+"Telefono: "+tele_est;
     
      MailingMain por = new MailingMain();
      por.mensajes(6, correo, observaciones);
      
 }

public void sendCancelacionTut(String tutor, String apellido,String correo){
     String observaciones="Estimado(a) "+tutor+" "+apellido+", la visita fue cancelada por el tutor. Pronto se le enviara una nueva fecha de visita.";
     
      MailingMain por = new MailingMain();
      por.mensajes(6, correo, observaciones);
      
 }

public String sendValidacion(String correo,String nombre,String apellido,String cedula,String actividad,String empresa,String fechaI,String fechaF){
    
  //  String observación= mensajeMail_asunto.toUpperCase(Locale.ENGLISH)+"\n"+"\n"+mensajeMail;
   String observación="Yo  "+nombre+"  " + apellido+" con cédula de ciudadanía: "+cedula+" , solicito a Ud. la autorización para la validaciòn de "+actividad+"  ,en "+empresa+" desde "+fechaI+" hasta "+fechaF;
        
  MailingMain por = new MailingMain();
      por.mensajes(8, correo, observación);
      paso=true;
      
      
      VisitaDAO visitaDAO = new VisitaDAO();
      visitaDAO.validacionDocs();
      long ced = Long.parseLong(cedula);
      
      visitaDAO.validacion_docs(ced);
     return"revision_window_est"; 
 }


  
    public void enviarCita(String id, String id2,String alumno, String apellido,String correo ){
        
        
        
        
        horaConFormato= sdf_time.format(time);
        fechaConFormato = sdf_data.format(data); 
        int dia;
        String dia1 = null;
         GregorianCalendar cal = new GregorianCalendar();
	cal.setTime(data);
        dia=cal.get(Calendar.DAY_OF_WEEK);
      
        if(dia==6){
              
               dia1="Viernes";
        }
        if(dia==2){
        

               dia1="Lunes";
        }

           
 
        
        if(dia==3){
                
               dia1="Martes";
        }
        
        if(dia==4){
                     
               dia1="Miercoles";
  }
        if(dia==5){
         
               dia1="Jueves";
        }
        
        if(dia==7){
   
               dia1="Sabado";
        } 
        
        
        
        sendTutor(alumno,apellido,correo,dia1,fechaConFormato,horaConFormato);
        
        guardarDatos(id, id2,dia1);
        long rid2=Long.parseLong(id2);
        VisitaDAO llamar=new VisitaDAO();
        llamar.updateEstudianteAgendado(rid2);
        
       /* VisitaDAO visi = new VisitaDAO();
        visi.confirmacion2(rid2, id);*/
        
        time=null;
        data=null;
        
    }
   
   
  public void enviarCitaTut(){
        fecha= sdf_time.format(time);
        hora = sdf_data.format(data); 
        agregar();
      
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
  
  public String reporte_coor(long user){
  
      SimpleDateFormat sdf_data = new SimpleDateFormat("dd-MM-yyyy"); 
        DateFormat formatoHora = new SimpleDateFormat("HH-mm-ss");
         java.util.Date fecha = new Date();
         String fecha1=sdf_data.format(fecha);
      String hora=formatoHora.format(fecha);
            AlmacenamientoPDF obj_crearpdf = new AlmacenamientoPDF();
            
           obj_crearpdf.create_coordinador_folder_first_time(user);
             obj_crearpdf.listar(user,fecha1,hora);
       
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
  
  public String doc_coor(){
  
  
  return "review_window";
  } 
}
