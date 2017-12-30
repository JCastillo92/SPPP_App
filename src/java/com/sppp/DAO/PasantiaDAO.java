/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Pasantia;
import com.sppp.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Jairo
 */
public class PasantiaDAO {
    public Pasantia findPasantia(long cedulaest){
         Pasantia passp=new Pasantia();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        
        try{
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from Pasantia WHERE cedula = :id ");
            query.setLong("id", cedulaest);
            
            passp = (Pasantia) query.uniqueResult();
            tx.commit();
        }catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
        return passp;
    }
    
    
     public List<Pasantia> findAllPA(){
        List<Pasantia> todosPasantiasPA = new LinkedList<>();
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        
        Transaction tx=null;    
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("FROM Pasantia P WHERE P.tipo_ppp = :tipo AND P.estado = :verdad");
            query.setString("tipo", "PA");
            query.setBoolean("verdad", true); 
            todosPasantiasPA= query.list();       
            tx.commit();
        }catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }finally{
            //para cerrar seesion
            sesion.close();
        }
        return todosPasantiasPA;
    }
     
     
     public List<Pasantia> findAllPP(){
        List<Pasantia> todosPasantiasPP = new LinkedList<>();
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        
        Transaction tx=null;    
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("FROM Pasantia P WHERE P.tipo_ppp = :tipo AND P.estado = :verdad");
            query.setString("tipo", "PP");
            query.setBoolean("verdad", true); 
            todosPasantiasPP= query.list();       
            tx.commit();
        }catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }finally{
            //para cerrar seesion
            sesion.close();
        }
        return todosPasantiasPP;
    }
     
     public int countPA(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        int numeroPA=0;
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT COUNT(*) from Pasantia P WHERE P.tipo_ppp = :tipo AND D.estado = est");
            query.setString("tipo", "PA");
            query.setBoolean("est", true);
            numeroPA=(int) query.uniqueResult();       
            tx.commit();
        }catch (Exception e) {
            numeroPA=0;
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
         return numeroPA;
    }
     
     public int countPP(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        int numeroPP=0;
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT COUNT(*) from Pasantia P WHERE P.tipo_ppp = :tipo AND D.estado = est");
            query.setString("tipo", "PP");
            query.setBoolean("est", true);
            numeroPP=(int) query.uniqueResult();       
            tx.commit();
        }catch (Exception e) {
            numeroPP=0;
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
         return numeroPP;
    }
     
}
