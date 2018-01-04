/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;


import com.sppp.beans.DetallePasantia;
import com.sppp.beans.EnumEstado;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Proceso;
import com.sppp.beans.Tutor;
import com.sppp.beans.VisitaTutor;
import com.sppp.utils.HibernateUtil;
import com.sppp.utils.SessionUtils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DidiAndy
 */
@ManagedBean
public class VisitaDAO {
    private Tutor tutor= new Tutor();
   private VisitaTutor visita = new VisitaTutor();
      DetallePasantia dp = new DetallePasantia();
    Pasantia p = new Pasantia();

    public Tutor getTutor() {
        return tutor;
    }

    public VisitaTutor getVisita() {
        return visita;
    }
    
    
     public void guardarDatosVisita(VisitaTutor visita){
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
       
        Transaction tx=null;
       
        try {
            tx = sesion.beginTransaction();
            sesion.saveOrUpdate(visita);
            tx.commit();
            System.out.println("====================== PASO LA INFO ==================");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getLocalizedMessage());
            System.out.println("=========== NO PASO LA INFO ===============");
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
        
    }
     
     public void updateVisita(long cedula_est,VisitaTutor newVisitaTutor){
Transaction trns= null;
Session session = HibernateUtil.getSessionFactory().openSession();
         try {
             trns= session.beginTransaction();
             VisitaTutor oldVisitaTuror =(VisitaTutor) session.load(VisitaTutor.class, new Long(cedula_est));
             oldVisitaTuror.setEstado_visita("Agendada");
             session.update(oldVisitaTuror);
             trns.commit();
         } catch (RuntimeException e) {
         e.printStackTrace();
         if(trns !=null){
             trns.rollback();
         }
         e.printStackTrace();
         }finally{
             session.close();
         }
}
     
      public void updateVisitaAgendada(long cedula_tut,VisitaTutor newVisita){
Transaction trns= null;
Session session = HibernateUtil.getSessionFactory().openSession();
         try {
             trns= session.beginTransaction();
             VisitaTutor oldVisita =(VisitaTutor) session.load(VisitaTutor.class, new Long(cedula_tut));
             oldVisita.setEstado_visita("Visitado");
             session.update(oldVisita);
             trns.commit();
         } catch (RuntimeException e) {
         e.printStackTrace();
         if(trns !=null){
             trns.rollback();
         }
         e.printStackTrace();
         }finally{
             session.close();
         }
}
       public void updateCantidadTutor(long cedula_tut,Tutor newVisita){
Transaction trns= null;
Session session = HibernateUtil.getSessionFactory().openSession();
         try {
             trns= session.beginTransaction();
             Tutor oldVisita =(Tutor) session.load(Tutor.class, new Long(cedula_tut));
             int cantidad = oldVisita.getCant_visitas();
             oldVisita.setCant_visitas(cantidad +1);
             session.update(oldVisita);
             trns.commit();
         } catch (RuntimeException e) {
         e.printStackTrace();
         if(trns !=null){
             trns.rollback();
         }
         e.printStackTrace();
         }finally{
             session.close();
         }
}
      
       public void updateReporte(long cedula_tut,VisitaTutor newVisita){
Transaction trns= null;
Session session = HibernateUtil.getSessionFactory().openSession();
         try {
             trns= session.beginTransaction();
             VisitaTutor oldVisita =(VisitaTutor) session.load(VisitaTutor.class, new Long(cedula_tut));
             oldVisita.setEstado_visita("Visitado2");
             session.update(oldVisita);
             trns.commit();
         } catch (RuntimeException e) {
         e.printStackTrace();
         if(trns !=null){
             trns.rollback();
         }
         e.printStackTrace();
         }finally{
             session.close();
         }
}
   
      public void deleteVisita(long id){
          Transaction trns= null;
Session session = HibernateUtil.getSessionFactory().openSession();
         try {
             trns= session.beginTransaction();
             VisitaTutor visitaTutor =(VisitaTutor) session.load(VisitaTutor.class, new Long(id));
            session.delete(visitaTutor);
             session.getTransaction().commit();
         } catch (RuntimeException e) {
           if(trns !=null){
             trns.rollback();
         }
         e.printStackTrace();
         }finally{
             session.close();
         }
   
      }
   
      public void confirmacion(){
            DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        
        PasantiaDAO ppDAO = new PasantiaDAO();
          try {
                    
                HttpSession session = SessionUtils.getSession();
                long id;
                id = (long) session.getAttribute("id");

                p = ppDAO.findPasantia(id);

                //Encontrar el detalle de esa pasantia cuyo proceso sea 4 (proceso actual, cursando, este va a ser actualizado)
                dp = dpDAO.findDetallePasantiaPorProceso(p.getTipo_ppp(), p.getCod_ppp(),7);

                //el estudiante puede usar EnumEstado.validar o llenar. ninguno mas.
                dp.setValidacion(EnumEstado.validar);
                dp.setEstado(false);
                dpDAO.actualizarDetallePasantia(dp);

            //Paso a agregar el nuevo proceso
            DetallePasantia dp3 = new DetallePasantia();
            dp3.setDescripcion("Confirmar Cita");
            dp3.setEstado(true);
            dp3.setPasantia(p);
            dp3.setProceso(new Proceso(18));
            dp3.setValidacion(EnumEstado.validar);
            dpDAO.insertarNuevoDetalle(dp3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
          
      }
      
      
      public void solicitud(){
            DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        
        PasantiaDAO ppDAO = new PasantiaDAO();
          try {
                    
                HttpSession session = SessionUtils.getSession();
                long id;
                id = (long) session.getAttribute("id");

                p = ppDAO.findPasantia(id);

                //Encontrar el detalle de esa pasantia cuyo proceso sea 4 (proceso actual, cursando, este va a ser actualizado)
                dp = dpDAO.findDetallePasantiaPorProceso(p.getTipo_ppp(), p.getCod_ppp(),18);

                //el estudiante puede usar EnumEstado.validar o llenar. ninguno mas.
                dp.setValidacion(EnumEstado.validar);
                dp.setEstado(false);
                dpDAO.actualizarDetallePasantia(dp);

            //Paso a agregar el nuevo proceso
            DetallePasantia dp3 = new DetallePasantia();
            dp3.setDescripcion("Solicitud de validación");
            dp3.setEstado(true);
            dp3.setPasantia(p);
            dp3.setProceso(new Proceso(21));
            dp3.setValidacion(EnumEstado.llenar);
            dpDAO.insertarNuevoDetalle(dp3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
}
     
      public void autoevaluacion(){
            DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        
        PasantiaDAO ppDAO = new PasantiaDAO();
          try {
                    
                HttpSession session = SessionUtils.getSession();
                long id;
                id = (long) session.getAttribute("id");

                p = ppDAO.findPasantia(id);

                //Encontrar el detalle de esa pasantia cuyo proceso sea 4 (proceso actual, cursando, este va a ser actualizado)
                dp = dpDAO.findDetallePasantiaPorProceso(p.getTipo_ppp(), p.getCod_ppp(),21);

                //el estudiante puede usar EnumEstado.validar o llenar. ninguno mas.
                dp.setValidacion(EnumEstado.validar);
                dp.setEstado(false);
                dpDAO.actualizarDetallePasantia(dp);

            //Paso a agregar el nuevo proceso
            DetallePasantia dp3 = new DetallePasantia();
            dp3.setDescripcion("Autoevaluación");
            dp3.setEstado(true);
            dp3.setPasantia(p);
            dp3.setProceso(new Proceso(23));
            dp3.setValidacion(EnumEstado.llenar);
            dpDAO.insertarNuevoDetalle(dp3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
}
     
      
      public void documentacion_est(){
            DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        
        PasantiaDAO ppDAO = new PasantiaDAO();
          try {
                    
                HttpSession session = SessionUtils.getSession();
                long id;
                id = (long) session.getAttribute("id");

                p = ppDAO.findPasantia(id);

                //Encontrar el detalle de esa pasantia cuyo proceso sea 4 (proceso actual, cursando, este va a ser actualizado)
                dp = dpDAO.findDetallePasantiaPorProceso(p.getTipo_ppp(), p.getCod_ppp(),23);

                //el estudiante puede usar EnumEstado.validar o llenar. ninguno mas.
                dp.setValidacion(EnumEstado.validar);
                dp.setEstado(false);
                dpDAO.actualizarDetallePasantia(dp);

            //Paso a agregar el nuevo proceso
            DetallePasantia dp3 = new DetallePasantia();
            dp3.setDescripcion("Descargar/Subir documentos validación");
            dp3.setEstado(true);
            dp3.setPasantia(p);
            dp3.setProceso(new Proceso(25));
            dp3.setValidacion(EnumEstado.llenar);
            dpDAO.insertarNuevoDetalle(dp3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
}
      
    public void visita_tut(String ce_tutor,long id_visita,String id){
            DetallePasantiaDAO dpDAO = new DetallePasantiaDAO();
        
        PasantiaDAO ppDAO = new PasantiaDAO();
          try {
                    
               
                long id3=Long.parseLong(id) ;
                
                p = ppDAO.findPasantia(id3);

                //Encontrar el detalle de esa pasantia cuyo proceso sea 4 (proceso actual, cursando, este va a ser actualizado)
                dp = dpDAO.findDetallePasantiaPorProceso(p.getTipo_ppp(), p.getCod_ppp(),25);

                //el estudiante puede usar EnumEstado.validar o llenar. ninguno mas.
                dp.setValidacion(EnumEstado.validar);
                //dp.setEstado(false);
                dpDAO.actualizarDetallePasantia(dp);

            //Paso a agregar el nuevo proceso
            DetallePasantia dp3 = new DetallePasantia();
            
             Long id1=Long.parseLong(ce_tutor);
             
               tutor.setCedula(id1);
            
            visita.setId_visita(id_visita);
            
            dp3.setDescripcion("Visita tut");
            dp3.setEstado(false);
            dp3.setPasantia(p);
            dp3.setProceso(new Proceso(30));
            dp3.setValidacion(EnumEstado.llenar);
            dp3.setTutor(tutor);
            dp3.setVisitaTutor(visita);
            dpDAO.insertarNuevoDetalle(dp3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
}  
      
}
