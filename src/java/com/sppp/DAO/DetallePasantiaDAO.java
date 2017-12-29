/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.DetallePasantia;
import com.sppp.utils.HibernateUtil;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EstJhonAlexanderCast
 */
public class DetallePasantiaDAO {

    public int findDetallePasantiaIdProcesoTrue(long id) {

        int numeroProceso=0;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        
        try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select id_proceso, cedula from tb_pasantia, tb_detalle_pasantia\n"
                    + "where  \n"
                    + "tb_pasantia.cod_ppp = tb_detalle_pasantia.cod_ppp and\n"
                    + "tb_pasantia.tipo_ppp = tb_detalle_pasantia.tipo_ppp and \n"
                    + "cedula = ? and tb_detalle_pasantia.estado = true;\n"
                    + "");

            List<Object[]> empData = query.setLong(0, id).list();
            for (Object[] row : empData) {
                numeroProceso = Integer.parseInt(row[0].toString());
                System.out.println(numeroProceso);
            }
            
            tx.commit();

        } catch (Exception e) {
            System.out.println("=================== ALGO SALIO MAL ==========================");
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        
        return numeroProceso;

    }
    
    
    public DetallePasantia findDetallePasantia(String tipo_ppp,int cod_ppp){
      DetallePasantia detallePas=new DetallePasantia();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        
        try{
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from DetallePasantia WHERE tipo_ppp = :tipo_ppp AND cod_ppp = :cod_ppp AND estado =  TRUE ");
            query.setString("tipo_ppp", tipo_ppp);//PA PP
            query.setInteger("cod_ppp", cod_ppp);//1 9
            
            detallePas = (DetallePasantia) query.uniqueResult();
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
        return detallePas;
    }
    
    public List<Integer> findDetallePasantiaTrue(long id) {
        
        List<Integer> procesoEstado = new LinkedList<>();
        int numeroProceso=0;
        int estado;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        
        try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select id_proceso, validacion from tb_pasantia, tb_detalle_pasantia\n"
                    + "where  \n"
                    + "tb_pasantia.cod_ppp = tb_detalle_pasantia.cod_ppp and\n"
                    + "tb_pasantia.tipo_ppp = tb_detalle_pasantia.tipo_ppp and \n"
                    + "cedula = ? and tb_detalle_pasantia.estado = true;\n"
                    + "");

            List<Object[]> empData = query.setLong(0, id).list();
            for (Object[] row : empData) {
                /*numeroProceso = Integer.parseInt(row[0].toString());
                estado = Integer.parseInt(row[2].toString());*/
                procesoEstado.add(Integer.parseInt(row[0].toString()));
                procesoEstado.add(Integer.parseInt(row[1].toString()));
            }
            
            tx.commit();

        } catch (Exception e) {
            System.out.println("=================== ALGO SALIO MAL ==========================");
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        
        return procesoEstado;

    }
    
  public List<DetallePasantia> findAllIngresoDatosBasicos(){
        List<DetallePasantia> todosDetIngDatBas = new LinkedList<>();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("FROM DetallePasantia D WHERE D.descripcion = :descrip AND D.validacion = :num");
            query.setString("descrip", "Dato Inicio Proesos Pasantia");
            query.setInteger("num", 2);
            todosDetIngDatBas= query.list();       
            tx.commit();
        }catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }finally{
            //para cerrar seesion
            sesion.close();
        }
        return todosDetIngDatBas;
    }

      public List<DetallePasantia> findAllCartaCompromiso(){
        List<DetallePasantia> todosDetPasCC = new LinkedList<>();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("FROM DetallePasantia D WHERE D.descripcion = :descrip AND D.validacion = :num");
            query.setString("descrip", "Ingreso Datos Carta Compromiso");
            query.setInteger("num", 2);
            todosDetPasCC= query.list();       
            tx.commit();
        }catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }finally{
            //para cerrar seesion
            sesion.close();
        }
        return todosDetPasCC;
    }

}
