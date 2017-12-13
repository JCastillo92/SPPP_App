/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;


import com.sppp.beans.VisitaTutor;
import com.sppp.utils.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author DidiAndy
 */
public class VisitaDAO {
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
     
     public void updateVisita(long id_tutor,VisitaTutor newVisitaTutor){
Transaction trns= null;
Session session = HibernateUtil.getSessionFactory().openSession();
         try {
             trns= session.beginTransaction();
             VisitaTutor oldVisitaTuror =(VisitaTutor) session.load(VisitaTutor.class, new Long(id_tutor));
             oldVisitaTuror.setConfirmada(true);
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
     
      public void updateVisitaAgendada(long id_tutor,VisitaTutor newVisitaTutor){
Transaction trns= null;
Session session = HibernateUtil.getSessionFactory().openSession();
         try {
             trns= session.beginTransaction();
             VisitaTutor oldVisitaTuror =(VisitaTutor) session.load(VisitaTutor.class, new Long(id_tutor));
             oldVisitaTuror.setEstado_visita(true);
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
   
}
