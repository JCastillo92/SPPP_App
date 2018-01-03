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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DidiAndy
 */
public class VisitaDAO {
      DetallePasantia dp = new DetallePasantia();
    Pasantia p = new Pasantia();
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
   
      public void agendacion(){
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
            dp3.setDescripcion("Agendación cita");
            dp3.setEstado(true);
            dp3.setPasantia(p);
            dp3.setProceso(new Proceso(29));
            dp3.setValidacion(EnumEstado.aprobar);
            dpDAO.insertarNuevoDetalle(dp3);
                } catch (Exception e) {
                    e.printStackTrace();
                }
      }
}
