/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Pasantia;
import com.sppp.beans.Proceso;
import com.sppp.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EstJhonAlexanderCast
 */
public class ProcesoDAO {
    
    
    //OJO DEVUELVE EL OBJETO PERO NO DEBE TENER ALGUN CAMPO NULL O DARA ERROR
    public Proceso findProceso(long id){
        
        Proceso proc = new Proceso();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        
        try{
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from Proceso WHERE id_proceso = :id ");
            query.setLong("id", id);
            proc = (Proceso) query.uniqueResult();
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
        
        return proc;
    }
    
    public String findDescripcionProceso(long id){
        String descripcion="";
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        
        try{
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("select descripcion from Proceso WHERE id_proceso = :id ");
            query.setLong("id", id);
            descripcion = (String) query.uniqueResult();
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
         
        return descripcion;
    }
    
}
