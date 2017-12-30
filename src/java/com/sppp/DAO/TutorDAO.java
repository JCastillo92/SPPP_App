/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Tutor;

/**
 *
 * @author Jairo
 */
public class TutorDAO {
        public Tutor findProceso(long id){
        /*
        Tutor proc = new Tutor();
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
*/
        return null;
    }
}
