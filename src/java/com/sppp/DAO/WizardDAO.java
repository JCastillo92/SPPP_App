/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.DetallePasantia;
import com.sppp.beans.Empresa;
import com.sppp.beans.Encargado;
import com.sppp.beans.EnumEstado;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Proceso;
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
    
    public void guardarDatosBasicos(Usuario est, Pasantia pas, Encargado enc, Empresa emp, DetallePasantia dp){
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        
        Transaction tx=null;
        
        /*
        //Datos adicionales de pasantia para agregarle el estudiante y el encargado
        pas.setEstudiante(est.getEstudiante());
        pas.setEncargado(enc);
        
        //Creando valores en detalle pasantia
        Proceso proceso = new Proceso();
        proceso.setId_proceso(1);
        DetallePasantia dp = new DetallePasantia();
        dp.setDescripcion("Dato Inicio Procesos Pasantia");
        dp.setEstado(true);
        dp.setValidacion(EnumEstado.validar);
        dp.setProceso(proceso);
        
        //Asignando a pasantia
        dp.setPasantia(pas);
        */
        
        try {
            tx = sesion.beginTransaction();
            sesion.saveOrUpdate(est);
            sesion.saveOrUpdate(emp);
            sesion.saveOrUpdate(enc);
            sesion.saveOrUpdate(pas);
            sesion.saveOrUpdate(dp);
            
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
