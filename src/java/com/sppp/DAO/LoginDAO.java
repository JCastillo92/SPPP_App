/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Datos;
import com.sppp.beans.DetallePasantia;
import com.sppp.beans.Respuesta;
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

    public static Usuario validate(String user, String password) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        Transaction tx = null;
        Usuario usuario = null;
        try {
            tx = sesion.beginTransaction();
            
            /*
            System.out.println("INICIO SECCION PRUEBAS");
            
            System.out.println("FIN SECCION DE PRUEBAS");
            */
            
            System.out.println("U: " + user + " P: " + password);
            Query query = sesion.createQuery(" from Usuario WHERE id_cedula = :id and clave = :password");
            Long usuarioI = Long.parseLong(user);

            //Cambio a Long
            query.setLong("id", usuarioI);
            query.setString("password", password);
            usuario = (Usuario) query.uniqueResult();
            tx.commit();

        } catch (NumberFormatException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        return usuario;
    }

}
