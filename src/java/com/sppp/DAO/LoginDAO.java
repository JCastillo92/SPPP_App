/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Estudiante;
import com.sppp.beans.Usuario;
import com.sppp.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EstJhonAlexanderCast
 */
public class LoginDAO {
    
    public static Usuario validate(String user, String password){
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        
        Transaction tx=null;
        Usuario usuario=null;
        try {
            tx = sesion.beginTransaction();
        
            Estudiante xxx=new Estudiante();
            xxx.setActividadRealizar("actividad 1");
            xxx.setApellido("apellido1");
            xxx.setClave("1111");
            xxx.setCorreo("uno@correo");
            xxx.setHorasPasantia(60);
            xxx.setId_cedula("1111111111");
            xxx.setNombre("nombre1");
            xxx.getPerfil().setId_tbperfil(1);
            xxx.setPorcentajeMateriasAprobadas(60);
            xxx.setTelefono("11111111");
            xxx.setUltimoNivel(6);
            sesion.save(xxx);
            
            
            
            
            
            
            
            
        System.out.println("U: "+user+" P: "+password);
        Query query = sesion.createQuery(" from Usuario where id_cedula = :id and clave = :password");
        query.setString("id", user);
        query.setString("password", password);
        usuario = (Usuario)query.uniqueResult();
        tx.commit();
        
        } catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
        return usuario;
    }
    
}
