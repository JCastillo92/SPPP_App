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
         

        String sql = "FROM VisitaTutor  WHERE cedula_tut =:id";

        try {
            tx = sesion.beginTransaction();
        //      Query query = sesion.createQuery(sql);
         // listado=query.list();
         listado = sesion.createQuery(sql).setParameter("id", id1).list();
//query.setInteger("id", id);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
            sesion.close();
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
        }finally{
            sesion.flush();
             sesion.close();
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
        }finally{
            sesion.flush();
            sesion.close();
        }
        
        return estudiante;
    }

   @Override
    public String obtenerNombre(long id) {
        String nombre;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT nombre FROM Usuario WHERE id_usuario =:id";
       
        try {
            tx = sesion.beginTransaction();
        nombre =(String) sesion.createQuery(sql).setParameter("id", id).uniqueResult();

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
        }finally{
            sesion.flush();
             sesion.close();
         }
        
        return nombre;
    
    }
    
    @Override
    public String obtenerApellido(long id) {
        String apellido;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT apellido FROM Usuario WHERE id_usuario =:idUs";
       long idUs;
        idUs=id;
        try {
            tx = sesion.beginTransaction();
        apellido =(String) sesion.createQuery(sql).setParameter("idUs", idUs).uniqueResult();

            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
             sesion.close();
         }
          return apellido;
 
    }
    
      @Override
    public String obtenerCorreo(long id) {
        String correo;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT correo FROM Usuario WHERE id_usuario =:idUs";
        long idUs;
        idUs=id;
        try {
            tx = sesion.beginTransaction();
        correo =(String) sesion.createQuery(sql).setParameter("idUs", idUs).uniqueResult();

            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
            sesion.close();
        }
          return correo;
 
    }
    
    @Override
    public String obtenerTelefono(long id) {
        String telefono;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT telefono FROM Usuario WHERE id_usuario =:idUs";
        long idUs;
        idUs=id;
        try {
            tx = sesion.beginTransaction();
        telefono =(String) sesion.createQuery(sql).setParameter("idUs", idUs).uniqueResult();

            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
             sesion.close();
         }
          return telefono;
 
    }
    
      @Override
    public String obtenerCorreoDirector(int id) {
  String correo_dir;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT correo FROM Usuario WHERE id_perfil =:id";
     
        try {
            tx = sesion.beginTransaction();
        correo_dir =(String) sesion.createQuery(sql).setParameter("id", id).uniqueResult();

            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
             sesion.close();
         }
        
        return correo_dir;
 
    }


    @Override
    public List<Pasantia> findUser(String id) {
    
        List<Pasantia> listado = null;
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        Long user=Long.parseLong(id);
        
        try {
            tx = sesion.beginTransaction();
            
            String sql=" from Pasantia WHERE cedula = :id ";
                     listado = sesion.createQuery(sql).setParameter("id", user).list();

            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }finally{
            sesion.flush();
           // sesion.close();
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
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
             sesion.close();
         }
        
        return nombre;
 
    
    
    
    }

    @Override
    public List<VisitaTutor> listarVisitados(long id) {
    SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        List<VisitaTutor> listado = null;
       

        String sql = "FROM VisitaTutor  WHERE cedula_tut =:id and estado_visita =:visitado";

        try {
            tx = sesion.beginTransaction();
        //      Query query = sesion.createQuery(sql);
         // listado=query.list();
         String estado="Visitado";
       //    Query query = sesion.createQuery(sql);
         //   query.setLong("id", id);
           // query.setString("visitado", estado);
           // listado = (VisitaTutor) query.uniqueResult();
          //  tx.commit();
         listado = sesion.createQuery(sql).setParameter("id", id).setParameter("visitado",estado).list();
//query.setInteger("id", id);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
            //sesion.close();
        }
        return listado;
    
    
    
    }
 public VisitaTutor findTutor(long user){
        
        VisitaTutor usu = new VisitaTutor();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        
        try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from VisitaTutor WHERE cedula_est = :id ");
            query.setLong("id", user);
            
            usu = (VisitaTutor) query.uniqueResult();
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }finally{
            sesion.flush();
           // sesion.close();
        }
        
        return usu;
    }
    
    @Override
    public List<VisitaTutor> listarInformeCoor() {
    SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        List<VisitaTutor> listado = null;
       
        String sql = "FROM VisitaTutor  WHERE estado_visita =:visitado";
        String estado="Visitado";
        try {
            tx = sesion.beginTransaction();
        //      Query query = sesion.createQuery(sql);
         // listado=query.list();
         listado = sesion.createQuery(sql).setParameter("visitado", estado).list();
//query.setInteger("id", id);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
            //sesion.close();
        }
        return listado;
    
    
    
    }


  

}
