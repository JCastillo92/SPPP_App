/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jairo
 */
public class PeriodoDAO {
    public long encontrarPeriodoActual(){
        //ESTE METODO PERMITE SABER EL PERIODO EL CUAL ESTA HABILITADO
       SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
      long retorno_id_periodo=0;
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT P.id_periodo FROM Periodo P WHERE P.estado_periodo = :estado");
            query.setBoolean("estado", true);      
            retorno_id_periodo=(long) query.uniqueResult();       
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
         return retorno_id_periodo;
    }//fin metodo
    
    public String encontrarPeriodoActual1(){
        //ESTE METODO PERMITE SABER EL PERIODO EL CUAL ESTA HABILITADO
       SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
      String retorno_id_periodo=null;
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT P.periodo FROM Periodo P WHERE P.estado_periodo = :estado");
            query.setBoolean("estado", true);      
            retorno_id_periodo=(String) query.uniqueResult();       
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
         return retorno_id_periodo;
    }//fin metodo
    
    
    
}
