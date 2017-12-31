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

        int numeroProceso = 0;
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

    public DetallePasantia findDetallePasantia(String tipo_ppp, int cod_ppp) {
        DetallePasantia detallePas = new DetallePasantia();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;

        try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from DetallePasantia WHERE tipo_ppp = :tipo_ppp AND cod_ppp = :cod_ppp AND estado =  TRUE ");
            query.setString("tipo_ppp", tipo_ppp);//PA PP
            query.setInteger("cod_ppp", cod_ppp);//1 9

            detallePas = (DetallePasantia) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return detallePas;
    }

    public List<Integer> findDetallePasantiaTrue(long id) {

        List<Integer> procesoEstado = new LinkedList<>();
        int numeroProceso = 0;
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

    public List<DetallePasantia> findAllIngresoDatosBasicos() {
        List<DetallePasantia> todosDetIngDatBas = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("FROM DetallePasantia D WHERE D.proceso.id_proceso = :proc AND D.validacion = :num");
            query.setLong("proc", 1);
            query.setInteger("num", 1);
            todosDetIngDatBas = query.list();
            tx.commit();

        }catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return todosDetIngDatBas;
    }

    public List<DetallePasantia> findAllCartaCompromiso() {
        List<DetallePasantia> todosDetPasCC = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("FROM DetallePasantia D WHERE D.proceso.id_proceso = :proc AND D.validacion = :num");
            query.setLong("proc", 7);
            query.setInteger("num", 1);
            todosDetPasCC = query.list();
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            if (tx != null){

                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return todosDetPasCC;
    }

       public List<DetallePasantia> findAllInicioActividades(){
        List<DetallePasantia> todosDetPasCC = new LinkedList<>();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("FROM DetallePasantia D WHERE D.proceso.id_proceso = :proc AND D.validacion = :num");
            query.setLong("proc", 14);
            query.setInteger("num", 1);
            todosDetPasCC= query.list();       
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }finally{
            //para cerrar seesion
            sesion.close();
        }
        return todosDetPasCC;
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

 
    public long countIngresoCartaCompromiso(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        long numeroCartasCompromiso=0;
         try {

            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT COUNT(*) FROM DetallePasantia D WHERE D.proceso.id_proceso = :id_pro AND D.validacion = :vali");
            query.setLong("id_pro", 7);//fk de tb_proceso 7
            query.setInteger("vali", 1);
            numeroCartasCompromiso=(long) query.uniqueResult();    
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            numeroCartasCompromiso=0;
            if (tx != null){

                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return numeroCartasCompromiso;
    }

        public long countIngresoInicioActividad(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        long numeroInicioActividades=0;
         try {

            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT COUNT(*) FROM DetallePasantia D WHERE D.proceso.id_proceso = :id_pro AND D.validacion = :vali");
            query.setLong("id_pro", 14);//fk de tb_proceso 14
            query.setInteger("vali", 1);
            numeroInicioActividades=(long) query.uniqueResult();       

            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            numeroInicioActividades=0;
            if (tx != null){
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return numeroInicioActividades;
    }

    
    public void actualizarDetallePasantia(DetallePasantia dp){
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(dp);
            tx.commit();
        } catch (Exception e) {
            
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
   
    }
    
    public void insertarNuevoDetalle(DetallePasantia dp){
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.save(dp);
            tx.commit();
        } catch (Exception e) {
            
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        
    }
    
    public DetallePasantia findDetallePasantiaPorProceso(String tipo_ppp, int cod_ppp, int tipoProceso) {
        DetallePasantia detallePas = new DetallePasantia();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;

        try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from DetallePasantia WHERE tipo_ppp = :tipo_ppp AND cod_ppp = :cod_ppp AND estado =  TRUE AND proceso.id_proceso = :proc ");
            query.setString("tipo_ppp", tipo_ppp);//PA PP
            query.setInteger("cod_ppp", cod_ppp);//1 9
            query.setInteger("proc", tipoProceso);

            detallePas = (DetallePasantia) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return detallePas;
    }


        public List<DetallePasantia> findAllDetallePasantiaAllTrue(){
        List<DetallePasantia> todosDetPasAllTrue = new LinkedList<>();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
         try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("FROM DetallePasantia D WHERE D.estado = :verdad ORDER BY D.idDetallePasantia DESC");
            query.setBoolean("verdad", true);
            todosDetPasAllTrue= query.list();       
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }finally{
            //para cerrar seesion
            sesion.close();
        }
        return todosDetPasAllTrue;
    }
}//end fo class
