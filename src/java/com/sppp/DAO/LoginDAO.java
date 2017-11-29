/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.DetallePasantia;
import com.sppp.beans.Estudiante;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Perfil;
import com.sppp.beans.Proceso;
import com.sppp.beans.Usuario;
import com.sppp.utils.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            
            System.out.println("INICIO SECCION DE PRUEBAS");
            Perfil p = new Perfil();
            p.setId_tbperfil(1);
            p.setDescripcion("Docente");
            
            Usuario s = new Usuario();
            s.setId_cedula(1735);
            s.setApellido("c");
            s.setClave("1735");
            s.setCorreo("s.com");
            s.setDireccion("hola");
            s.setEstado(true);
            s.setNombre("ff");
            s.setTelefono("233");
            s.setPerfil(p);
            System.out.println("INICIO GUARDADO");
            sesion.save(p);
            //sesion.saveOrUpdate(s);
            
            Estudiante esss = new Estudiante();
            esss.setActividadRealizar("ninguna");
            esss.setHorasPasantia(4);
            esss.setPorcentajeMateriasAprobadas(40);
            esss.setUltimoNivel(6);
            
            s.setEstudiante(esss);
            esss.setUsuario(s);
            sesion.save(s);
            System.out.println("FIN SECCION DE PRUEBAS");
            
        System.out.println("U: "+user+" P: "+password);
        Query query = sesion.createQuery(" from Usuario WHERE id_cedula = :id and clave = :password");
        Long usuarioI = Long.parseLong(user);
        
        //Cambio a Long
        query.setLong("id", usuarioI);
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
