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
public class PasantiaPracticaDAO {
   
    public int encontrarUltimoPA(){
        //ESTE METODO PERMITE SABER EL ULTIMO CODIGO DE PASANTIA
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        int ultimo_valor=0;
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT MAX(P.cod_ppp) from Pasantia P WHERE P.tipo_ppp = :tipo");
            query.setString("tipo", "PA");      
            ultimo_valor=(int) query.uniqueResult();       
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
         return ultimo_valor;
    }//fin metodo        
    
    public int encontrarUltimoPP(){
        //ESTE METODO PERMITE SABER EL ULTIMO CODIGO DE PRACTICA PRE PROFESIONAL
       SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        int ultimo_valor=0;
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT MAX(P.cod_ppp) from Pasantia P WHERE P.tipo_ppp = :tipo");
            query.setString("tipo", "PP");      
            ultimo_valor=(int) query.uniqueResult();       
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
         return ultimo_valor;
    }//fin metodo
}//END OF CLASS