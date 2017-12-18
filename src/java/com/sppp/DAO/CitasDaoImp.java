/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Estudiante;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Usuario;
import com.sppp.beans.VisitaTutor;
import com.sppp.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author KarenVanessaAchigGua
 */
public class CitasDaoImp implements CitasDao {

    
    public List<VisitaTutor> findAll(String id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        List<VisitaTutor> listado = null;
        Long id1=Long.parseLong(id);
         boolean estado=false;
         String estado1="agendada";

        String sql = "FROM VisitaTutor  WHERE cedula_tut =:id and estado_visita =:agendada and confirmada =:False";

        try {
            tx = sesion.beginTransaction();
        //      Query query = sesion.createQuery(sql);
         // listado=query.list();
         listado = sesion.createQuery(sql).setParameter("id", id1).setParameter("agendada", estado1).setParameter("False", estado).list();
//query.setInteger("id", id);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        return listado;
    }
    
     public List<VisitaTutor> confirma(String id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        List<VisitaTutor> listado2 = null;

        String sql = "FROM VisitaTutor WHERE cedula_est =:id";

        try {
            tx = sesion.beginTransaction();
        //      Query query = sesion.createQuery(sql);
         // listado=query.list();
         Long id1=Long.parseLong(id);
         listado2 = sesion.createQuery(sql).setParameter("id", id1).list();
//query.setInteger("id", id);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        return listado2;
    }

    @Override
    public List<Usuario> listar() {
         
        List<Usuario>estudiante=null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "FROM Usuario WHERE id_perfil =:num";
        int id=1;
        try {
            tx = sesion.beginTransaction();
         estudiante = sesion.createQuery(sql).setParameter("num", id).list();

            //    Query query = sesion.createQuery(sql);
        // estudiante=query.list();
         /*Long id1=Long.parseLong(id);
         boolean estado=false;
         boolean estado1=false;
         
*///query.setInteger("id", id);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        
        return estudiante;
    }

    @Override
    public List<VisitaTutor> confirmaCita(String id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        List<VisitaTutor> listado = null;

        String sql = "FROM VisitaTutor WHERE cedula_est =:id and estado_visita =:false and confirmada =:TRUE";

        try {
            tx = sesion.beginTransaction();
        //      Query query = sesion.createQuery(sql);
         // listado=query.list();
         Long id1=Long.parseLong(id);
         boolean estado=true;
         boolean estado1=false;
         listado = sesion.createQuery(sql).setParameter("id", id1).setParameter("false", estado1).setParameter("TRUE", estado).list();
//query.setInteger("id", id);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        return listado;
        }

   @Override
    public String obtenerNombre(String id) {
        String nombre;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT nombre FROM Usuario WHERE id_usuario =:idUs";
        int idUs;
        idUs=Integer.parseInt(id);
        try {
            tx = sesion.beginTransaction();
        nombre =(String) sesion.createQuery(sql).setParameter("idUs", idUs).uniqueResult();

            //    Query query = sesion.createQuery(sql);
        // estudiante=query.list();
         /*Long id1=Long.parseLong(id);
         boolean estado=false;
         boolean estado1=false;
         
*///query.setInteger("id", id);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        
        return nombre;
 
    
    
    }


    
    
    @Override
    public List<Pasantia> findUser(long id) {
    
        List<Pasantia> listado = null;
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
       // Long user=Long.parseLong(id);
        
        try {
            tx = sesion.beginTransaction();
            
            String sql=" from Pasantia WHERE cedula = :id ";
                     listado = sesion.createQuery(sql).setParameter("id", id).list();

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }
       
        return listado;
    
    
    }

    @Override
    public String obtenerCoordinador(String id) {
  String nombre;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT nombre FROM Usuario WHERE id_perfil =:idUs";
        int idUs;
        idUs=Integer.parseInt(id);
        try {
            tx = sesion.beginTransaction();
        nombre =(String) sesion.createQuery(sql).setParameter("idUs", idUs).uniqueResult();

            //    Query query = sesion.createQuery(sql);
        // estudiante=query.list();
         /*Long id1=Long.parseLong(id);
         boolean estado=false;
         boolean estado1=false;
         
*///query.setInteger("id", id);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        
        return nombre;
 
    
    
    
    }

    

  

}
