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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
     public List<VisitaTutor> confirma(long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        List<VisitaTutor> listado2 = null;

        String sql = "FROM VisitaTutor WHERE cedula_est =:id";

        try {
            tx = sesion.beginTransaction();
        //      Query query = sesion.createQuery(sql);
         // listado=query.list();
        // Long id1=Long.parseLong(id);
         listado2 = sesion.createQuery(sql).setParameter("id", id).list();
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
    public List<Pasantia> listar(long user) {
         
        List<Pasantia>estudiante=null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "FROM Pasantia WHERE ced_tutor_asignado =:num and estado_tut =:true";
        boolean estado=true;
        try {
            tx = sesion.beginTransaction();
         estudiante = sesion.createQuery(sql).setParameter("num", user).setParameter("true", estado).list();

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
    public Date obtenerFecha(long id) {
        Date nombre;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT fecha_registro FROM Pasantia WHERE cedula =:id";
       
        try {
            tx = sesion.beginTransaction();
        nombre =(Date) sesion.createQuery(sql).setParameter("id", id).uniqueResult();
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
    public long obtenercedulaTut(long id) {
        long cedula;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "Select ced_tutor_asignado from Pasantia where cedula =:id";
       
        try {
            tx = sesion.beginTransaction();
        cedula =(Long) sesion.createQuery(sql).setParameter("id", id).uniqueResult();

            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
             sesion.close();
         }
        
        return cedula;
    
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
        
        String sql = "SELECT correo FROM Usuario WHERE id_perfil =:id ";
     
        try {
            tx = sesion.beginTransaction();
            
        correo_dir =(String) sesion.createQuery(sql).setParameter("id", id).setMaxResults(1).uniqueResult();

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
    public List<Pasantia> findUser(long id) {
    
        List<Pasantia> listado = null;
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
       // Long user=Long.parseLong(id);
        
        try {
            tx = sesion.beginTransaction();
            
            String sql=" from Pasantia  WHERE cedula = :id ";
                     listado = sesion.createQuery(sql).setParameter("id", id).list();

                     
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }finally{
            sesion.flush();
      sesion.close();
        
        }
        return listado;
    
    
    }

    @Override
    public String obtenerCoordinador(long id) {
  String nombre;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT nombre FROM Usuario WHERE id_perfil =:idUs";
       
        try {
            tx = sesion.beginTransaction();
        nombre =(String) sesion.createQuery(sql).setParameter("idUs", id).uniqueResult();
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
       

        String sql = "FROM VisitaTutor  WHERE cedula_est =:id";

        try {
            tx = sesion.beginTransaction();
        //      Query query = sesion.createQuery(sql);
         // listado=query.list();
       //  String estado="Visitado";
       //    Query query = sesion.createQuery(sql);
         //   query.setLong("id", id);
           // query.setString("visitado", estado);
           // listado = (VisitaTutor) query.uniqueResult();
          //  tx.commit();
         listado = sesion.createQuery(sql).setParameter("id", id).list();
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
           sesion.close();
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
        String estado="Validacion";
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
            sesion.close();
        }
        return listado;
    
    
    }
     
     @Override
    public List<VisitaTutor> listarInformeCoor2(long id) {
    SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        List<VisitaTutor> listado = null;
       
        String sql = "FROM VisitaTutor  WHERE estado_visita =:visitado and cedula_est = :cedu";
        String estado="Validacion";
        try {
            tx = sesion.beginTransaction();
        //      Query query = sesion.createQuery(sql);
         // listado=query.list();
         listado = sesion.createQuery(sql).setParameter("visitado", estado).setParameter("cedu", id).list();
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
   
   
@Override
public List<VisitaTutor> visitadosTuto(long user) {
    SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        List<VisitaTutor> listado = null;
       
        String sql = "FROM VisitaTutor  WHERE cedula_tut =:user and estado_visita =:visitado";
        String estado="Visitado";
        try {
            tx = sesion.beginTransaction();
        //      Query query = sesion.createQuery(sql);
         // listado=query.list();
         listado = sesion.createQuery(sql).setParameter("user", user).setParameter("visitado", estado).list();
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

    public long id_secretaria(){
    long nombre;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT id_cedula FROM Usuario WHERE id_perfil =:idUs";
       int id=5;
        try {
            tx = sesion.beginTransaction();
        nombre =(long) sesion.createQuery(sql).setParameter("idUs", id).uniqueResult();
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
    
public int horas(long user){
    int horas;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
            
        Transaction tx = null;
        
        String sql = "SELECT horasPasantia FROM Estudiante WHERE cedula =:idUs";
       int id=5;
        try {
            tx = sesion.beginTransaction();
        horas =(int) sesion.createQuery(sql).setParameter("idUs", user).uniqueResult();
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }finally{
            sesion.flush();
             sesion.close();
         }
        
        return horas;
 
  
    
    }
  


    
    
}
