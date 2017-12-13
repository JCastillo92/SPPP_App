/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Empresa;
import com.sppp.beans.Encargado;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Usuario;
import com.sppp.utils.HibernateUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EstJhonAlexanderCast
 */
public class WizardDAO {
    
    public void guardarDatosBasicos(Usuario est, Pasantia pas, Encargado enc, Empresa emp){
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        
        Transaction tx=null;
        pas.setEstudiante(est.getEstudiante());
        pas.setEncargado(enc);
        try {
            tx = sesion.beginTransaction();
            sesion.saveOrUpdate(est);
            sesion.saveOrUpdate(emp);
            sesion.saveOrUpdate(enc);
            sesion.saveOrUpdate(pas);
            tx.commit();
            System.out.println("====================== PASO LA INFO ==================");
        } catch (Exception e) {
            e.printStackTrace();
            Logger.getAnonymousLogger().log(Level.SEVERE, e.getLocalizedMessage());
            System.out.println("=========== NO PASO LA INFO ===============");
            if (tx != null){
                tx.rollback();
            }
        }finally{
            //para cerrar seesion
            sesion.close();
        }
        
    }
    
}