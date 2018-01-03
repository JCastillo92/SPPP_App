/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Estudiante;
import com.sppp.beans.Usuario;
import com.sppp.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EstJhonAlexanderCast
 */
public class UsuarioDAO {
    
    public Usuario findUsuario(long user){
        
        Usuario usu = new Usuario();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        
        try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from Usuario WHERE id_cedula = :id ");
            query.setLong("id", user);
            
            usu = (Usuario) query.uniqueResult();
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
        
        return usu;
    }
    
    
    public void updateUserPassword(Usuario userNewPass){
         SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(userNewPass);
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
    
    public void findUsuarioEmail(String emailto,Long identification){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        String pass = null;
        try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("SELECT clave FROM Usuario "
                    + "WHERE correo = :email "
                    + "AND id_usuario = :ci");
            query.setString("email", emailto);
            query.setLong("ci", identification);
            query.setMaxResults(1);
            pass= (String) query.uniqueResult();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
        System.out.println("sssssxxxxxxxxxxxxxxxx"+pass);
    }
}
