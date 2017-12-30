/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Tutor;
import com.sppp.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jairo
 */
public class TutorDAO {
    /*
        public Tutor findTutorVisita(){
        Tutor datoTutor = new Tutor();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        try{
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from Tutor WHERE id_proceso = :id ");
            datoTutor = (Tutor) query.uniqueResult();
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
        return datoTutor;

    }
*/
}
