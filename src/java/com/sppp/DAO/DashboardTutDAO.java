/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Pasantia;
import com.sppp.utils.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author KarenVanessaAchigGua
 */
public class DashboardTutDAO {

public List<Object[]> findAllDetallePasantiaconCIAllTrue(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
        
        //variables a pedir
        long cedula_est=0;
        int cod_ppp=0,iddetallepasantia=0;
        String tipo_ppp="",descripcion="";
        List<Object[]> empData=null;
         try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select tb_pasantia.cedula, tb_detalle_pasantia.tipo_ppp, tb_detalle_pasantia.cod_ppp, tb_detalle_pasantia.iddetallepasantia, tb_detalle_pasantia.descripcion, tb_detalle_pasantia.id_proceso \n" +
"from tb_pasantia, tb_detalle_pasantia \n" +
"where tb_detalle_pasantia.tipo_ppp=tb_pasantia.tipo_ppp and tb_detalle_pasantia.cod_ppp=tb_pasantia.cod_ppp\n" +
"and tb_detalle_pasantia.estado=true \n"
+ "and tb_detalle_pasantia.validacion=1;");

                empData = query.list();
            for (Object[] row : empData) {
                //variables que retorna la consulta
                cedula_est = Long.parseLong(row[0].toString());
                tipo_ppp=row[1].toString();
                cod_ppp = Integer.parseInt(row[2].toString());
                iddetallepasantia=Integer.parseInt(row[3].toString());
                descripcion=row[4].toString();
            }
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
        return empData;
    }

    public List<Object[]> findAllDetallePasantiaconcita(long user){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
        
        //variables a pedir
        long cedula_est=0;
        int cod_ppp=0,iddetallepasantia=0;
        String tipo_ppp="",descripcion="";
        List<Object[]> empData=null;
         try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select tb_pasantia.cedula, tb_detalle_pasantia.tipo_ppp, tb_detalle_pasantia.cod_ppp, tb_detalle_pasantia.iddetallepasantia, tb_detalle_pasantia.descripcion, tb_detalle_pasantia.id_proceso \n" +
"from tb_pasantia, tb_detalle_pasantia \n" +
"where tb_detalle_pasantia.tipo_ppp=tb_pasantia.tipo_ppp and tb_detalle_pasantia.cod_ppp=tb_pasantia.cod_ppp\n" +
"and tb_detalle_pasantia.estado=true \n"
+ "and tb_detalle_pasantia.id_proceso=18 \n"
+ "and tb_detalle_pasantia.validacion=1 \n"
 + "and tb_detalle_pasantia.cedula_tut = ? ;");

                empData = query.setLong(0, user).list();
            for (Object[] row : empData) {
                //variables que retorna la consulta
                cedula_est = Long.parseLong(row[0].toString());
                tipo_ppp=row[1].toString();
                cod_ppp = Integer.parseInt(row[2].toString());
                iddetallepasantia=Integer.parseInt(row[3].toString());
                descripcion=row[4].toString();
            }               
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
        return empData;
    }

     public List<Object[]> findAllDetalleVisita(long user){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
        
        //variables a pedir
        long cedula_est=0;
        int cod_ppp=0,iddetallepasantia=0;
        String tipo_ppp="",descripcion="";
        List<Object[]> empData=null;
         try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select tb_pasantia.cedula, tb_detalle_pasantia.tipo_ppp, tb_detalle_pasantia.cod_ppp, tb_detalle_pasantia.iddetallepasantia, tb_detalle_pasantia.descripcion, tb_detalle_pasantia.id_proceso \n" +
"from tb_pasantia, tb_detalle_pasantia \n" +
"where tb_detalle_pasantia.tipo_ppp=tb_pasantia.tipo_ppp and tb_detalle_pasantia.cod_ppp=tb_pasantia.cod_ppp\n" +
"and tb_detalle_pasantia.estado=true \n"
+ "and tb_detalle_pasantia.id_proceso=21 \n"
+ "and tb_detalle_pasantia.validacion=0 \n"
 + "and tb_detalle_pasantia.cedula_tut = ? ;");

                empData = query.setLong(0, user).list();
            for (Object[] row : empData) {
                //variables que retorna la consulta
                cedula_est = Long.parseLong(row[0].toString());
                tipo_ppp=row[1].toString();
                cod_ppp = Integer.parseInt(row[2].toString());
                iddetallepasantia=Integer.parseInt(row[3].toString());
                descripcion=row[4].toString();
            }               
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
        return empData;
    }

      public List<Object[]> findAllDetalleDocumentos(long user){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
        
        //variables a pedir
        long cedula_est=0;
        int cod_ppp=0,iddetallepasantia=0;
        String tipo_ppp="",descripcion="";
        List<Object[]> empData=null;
         try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select tb_pasantia.cedula, tb_detalle_pasantia.tipo_ppp, tb_detalle_pasantia.cod_ppp, tb_detalle_pasantia.iddetallepasantia, tb_detalle_pasantia.descripcion, tb_detalle_pasantia.id_proceso \n" +
"from tb_pasantia, tb_detalle_pasantia \n" +
"where tb_detalle_pasantia.tipo_ppp=tb_pasantia.tipo_ppp and tb_detalle_pasantia.cod_ppp=tb_pasantia.cod_ppp\n" +
"and tb_detalle_pasantia.estado=true \n"
+ "and tb_detalle_pasantia.id_proceso=24 \n"
+ "and tb_detalle_pasantia.validacion=1 \n"
 + "and tb_detalle_pasantia.cedula_tut = ? ;");

                empData = query.setLong(0, user).list();
            for (Object[] row : empData) {
                //variables que retorna la consulta
                cedula_est = Long.parseLong(row[0].toString());
                tipo_ppp=row[1].toString();
                cod_ppp = Integer.parseInt(row[2].toString());
                iddetallepasantia=Integer.parseInt(row[3].toString());
                descripcion=row[4].toString();
            }               
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
        return empData;
    }

 
 public List<Object[]> ListarCoordinador(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
        
        //variables a pedir
        long cedula_est=0;
        int cod_ppp=0,periodo=0;
        String tipo_ppp="",fechaini="",fechafin="";
        List<Object[]> empData=null;
         try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select tb_pasantia.cedula, tb_detalle_pasantia.tipo_ppp, tb_detalle_pasantia.cod_ppp, tb_pasantia.fechafin, tb_pasantia.fechainicio \n" +
"from tb_pasantia, tb_detalle_pasantia \n" +
"where tb_detalle_pasantia.tipo_ppp=tb_pasantia.tipo_ppp and tb_detalle_pasantia.cod_ppp=tb_pasantia.cod_ppp\n" +
"and tb_detalle_pasantia.estado=true \n"
+ "and tb_detalle_pasantia.id_proceso=38 \n"
+ "and tb_detalle_pasantia.validacion=0 ;");

                empData = query.list();
            for (Object[] row : empData) {
                //variables que retorna la consulta
                cedula_est = Long.parseLong(row[0].toString());
                tipo_ppp=row[1].toString();
                cod_ppp = Integer.parseInt(row[2].toString());
                fechaini=row[3].toString();
                fechafin=row[4].toString();
            }               
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
        return empData;
    }

 public List<Object[]> ListarCoordinador_Resolucion(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
        
        //variables a pedir
        long cedula_est=0;
        int cod_ppp=0,periodo=0;
        String tipo_ppp="",fechaini="",fechafin="";
        List<Object[]> empData=null;
         try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select tb_pasantia.cedula, tb_detalle_pasantia.tipo_ppp, tb_detalle_pasantia.cod_ppp, tb_pasantia.fechafin, tb_pasantia.fechainicio \n" +
"from tb_pasantia, tb_detalle_pasantia \n" +
"where tb_detalle_pasantia.tipo_ppp=tb_pasantia.tipo_ppp and tb_detalle_pasantia.cod_ppp=tb_pasantia.cod_ppp\n" +
"and tb_detalle_pasantia.estado=true \n"
+ "and tb_detalle_pasantia.id_proceso=38 \n"
+ "and tb_detalle_pasantia.validacion=1 ;");

                empData = query.list();
            for (Object[] row : empData) {
                //variables que retorna la consulta
                cedula_est = Long.parseLong(row[0].toString());
                tipo_ppp=row[1].toString();
                cod_ppp = Integer.parseInt(row[2].toString());
                fechaini=row[3].toString();
                fechafin=row[4].toString();
            }               
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
        return empData;
    }

 
public String resolucion(long cedula_est,String numero){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
       
        try {
            tx = sesion.beginTransaction();
              Query query = sesion.createQuery("update Pasantia set cod_resolucion_final =:num where cedula =:id");
              query.setParameter("num", numero);
              query.setParameter("id", cedula_est);

            int result=query.executeUpdate();
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
            sesion.close();
        }
        return "review_window";
   }

      public List<Object[]> listarInforEst(long user){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;    
        
        //variables a pedir
        long cedula_est=0;
        int cod_ppp=0,iddetallepasantia=0;
        String tipo_ppp="",descripcion="";
        List<Object[]> empData=null;
         try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select tb_pasantia.cedula, tb_detalle_pasantia.tipo_ppp, tb_detalle_pasantia.cod_ppp, tb_detalle_pasantia.iddetallepasantia, tb_detalle_pasantia.descripcion, tb_detalle_pasantia.id_proceso \n" +
"from tb_pasantia, tb_detalle_pasantia \n" +
"where tb_detalle_pasantia.tipo_ppp=tb_pasantia.tipo_ppp and tb_detalle_pasantia.cod_ppp=tb_pasantia.cod_ppp\n" +
"and tb_detalle_pasantia.estado=true \n"
+ "and tb_detalle_pasantia.id_proceso=18 \n"
+ "and tb_detalle_pasantia.validacion=0 \n"
 + "and tb_detalle_pasantia.cedula_tut = ? ;");

                empData = query.setLong(0, user).list();
            for (Object[] row : empData) {
                //variables que retorna la consulta
                cedula_est = Long.parseLong(row[0].toString());
                tipo_ppp=row[1].toString();
                cod_ppp = Integer.parseInt(row[2].toString());
                iddetallepasantia=Integer.parseInt(row[3].toString());
                descripcion=row[4].toString();
            }               
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
        return empData;
    }

 
}
