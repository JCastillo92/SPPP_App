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
import com.sppp.beans.Pasantia;

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
            ultimo_valor=0;
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
         //en el retorno le sumo 1 para que el codigo de pasantia se setee en el NUEVO registro.
         return ultimo_valor+1;
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
            ultimo_valor=0;
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
         //en el retorno le sumo 1 para que el codigo de practica pre profesional se setee en el NUEVO registro.
         return ultimo_valor+1;
    }//fin metodo
    
    
    
    
    //metodos de busqueda
    public static Pasantia findPasantiaPractica(String tipoPasantia, String codigoPasantia){
           SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        
        Transaction tx=null;
        Pasantia pasantia_practicapreprofesional=null;
        int ultimo_valor=0;
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("from Pasantia P WHERE P.tipo_ppp = :tipo AND P.cod_ppp = :cod_ppp");
            query.setString("tipo", tipoPasantia);  
            query.setString("cod_ppp", codigoPasantia);
            
            pasantia_practicapreprofesional= (Pasantia) query.uniqueResult();       
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
         //en el retorno le sumo 1 para que el codigo de practica pre profesional se setee en el NUEVO registro.
         return pasantia_practicapreprofesional;
      
    }//fin findPasantia   
}//END OF CLASS