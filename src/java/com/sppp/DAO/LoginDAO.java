/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Estudiante;
import com.sppp.beans.Perfil;
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
            /*
            Perfil p = new Perfil();
            p.setId_tbperfil(1);
            p.setDescripcion("Estudiante");
            
            Usuario s = new Usuario();
            s.setId_cedula("46");
            s.setApellido("c");
            s.setClave("12");
            s.setCorreo("s.com");
            s.setDireccion("hola");
            s.setEstado(true);
            s.setNombre("ff");
            s.setTelefono("233");
            s.setPerfil(p);*/
            
            
            /*
            Estudiante esss = new Estudiante();
            esss.setActividadRealizar("ninguna");
            esss.setHorasPasantia(4);
            esss.setPorcentajeMateriasAprobadas(40);
            esss.setUltimoNivel(6);
            
            s.setEstudiante(esss);
            esss.setUsuario(s);*/
            //sesion.saveOrUpdate(s);
            
            
            
            
        System.out.println("U: "+user+" P: "+password);
        Query query = sesion.createQuery(" from Usuario WHERE id_cedula = :id and clave = :password");
        query.setString("id", user);
        query.setString("password", password);
        usuario = (Usuario)query.uniqueResult();
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
        return usuario;
    }
    
}
