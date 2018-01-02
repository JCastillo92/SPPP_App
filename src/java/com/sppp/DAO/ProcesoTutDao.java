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
 * @author KarenVanessaAchigGua
 */
public class ProcesoTutDao {

    public long countIngresoInicioActividad() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        long numeroInicioActividades = 0;
        try {

            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT COUNT(*) FROM DetallePasantia D WHERE D.proceso.id_proceso = :id_pro AND D.validacion = :vali");
            query.setLong("id_pro", 14);//fk de tb_proceso 14
            query.setInteger("vali", 1);
            numeroInicioActividades = (long) query.uniqueResult();

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            numeroInicioActividades = 0;
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return numeroInicioActividades;
    }

    public long countIngresoDatosBasicos(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        long numeroIngresoDatosBasicos=0;
         try {

            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT COUNT(*) FROM DetallePasantia D WHERE D.proceso.id_proceso = :id_pro AND D.validacion = :vali");
            query.setLong("id_pro", 1);//fk de tb_proceso 1
            query.setInteger("vali", 1);
            numeroIngresoDatosBasicos=(long) query.uniqueResult();       
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            numeroIngresoDatosBasicos=0;
            if (tx != null){
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return numeroIngresoDatosBasicos;
    }

    public long countCitasAgendas(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        long numeroIngresoDatosBasicos=0;
         try {

            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT COUNT(*) FROM DetallePasantia D WHERE D.proceso.id_proceso = :id_pro ");
            query.setLong("id_pro", 18);//fk de tb_proceso 1
            //query.setInteger("vali", 1);
            numeroIngresoDatosBasicos=(long) query.uniqueResult();       
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            numeroIngresoDatosBasicos=0;
            if (tx != null){
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return numeroIngresoDatosBasicos;
    }

    
    public long countVisitaConcluida(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        long numeroIngresoDatosBasicos=0;
         try {

            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT COUNT(*) FROM DetallePasantia D WHERE D.proceso.id_proceso = :id_pro ");
            query.setLong("id_pro", 36);//fk de tb_proceso 1
           // query.setInteger("vali", 1);
            numeroIngresoDatosBasicos=(long) query.uniqueResult();       
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            numeroIngresoDatosBasicos=0;
            if (tx != null){
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return numeroIngresoDatosBasicos;
    } 
   
     public long countProcesoValidacion(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        long numeroIngresoDatosBasicos=0;
         try {

            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT COUNT(*) FROM DetallePasantia D WHERE D.proceso.id_proceso = :id_pro ");
            query.setLong("id_pro", 24);//fk de tb_proceso 1
           // query.setInteger("vali", 1);
            numeroIngresoDatosBasicos=(long) query.uniqueResult();       
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            numeroIngresoDatosBasicos=0;
            if (tx != null){
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return numeroIngresoDatosBasicos;
    } 
   
    
    
}
