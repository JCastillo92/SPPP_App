/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Estudiante;
import com.sppp.beans.Usuario;
import com.sppp.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EstJhonAlexanderCast
 */
public class EstudianteDAO {
    
    public Estudiante encontrarEst(long id){
        Estudiante est = new Estudiante();
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
            
        
        try {
            tx = sesion.beginTransaction();
            
            Query query = sesion.createQuery(" from Estudiante WHERE cedula = :id");

            //Cambio a Long
            query.setLong("id", id);
            est = (Estudiante) query.uniqueResult();
            
            tx.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
        
        return est;
    }
    
}
