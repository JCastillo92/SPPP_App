/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Datos;
import com.sppp.beans.DetallePasantia;
import com.sppp.beans.Empresa;
import com.sppp.beans.Encargado;
import com.sppp.beans.Pasantia;
import com.sppp.beans.Respuesta;
import com.sppp.beans.Usuario;
import com.sppp.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author KarenVanessaAchigGua
 */
public class DatosTutDAO {
    
    public void guardarDatosAutoevaluacion(String at1,String at2,String at3,String at4,String at5, DetallePasantia dp){
        
        Respuesta idRespuesta = new Respuesta();
        
        //GUARDO LA DATA EN TABLA DATOS
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            
            idRespuesta.setId_tbrespuesta(52);
            Datos d30 = new Datos(at1, dp, idRespuesta,true);
            sesion.saveOrUpdate(d30);
            
            idRespuesta.setId_tbrespuesta(53);
            Datos d31 = new Datos(at2, dp, idRespuesta,true);
            sesion.saveOrUpdate(d31);
            
            idRespuesta.setId_tbrespuesta(54);
            Datos d32 = new Datos(at3, dp, idRespuesta,true);
            sesion.saveOrUpdate(d32);
            
            idRespuesta.setId_tbrespuesta(55);
            Datos d33 = new Datos(at4, dp, idRespuesta,true);
            sesion.saveOrUpdate(d33);
            
            idRespuesta.setId_tbrespuesta(56);
            Datos d34 = new Datos(at5, dp, idRespuesta,true);
            sesion.saveOrUpdate(d34);
            
            tx.commit();

        } catch (NumberFormatException e) {
            System.out.println("================ ERROR ACA =====================");
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        
    }
    
     public void guardarDatosInformeTut(String at1,String at2,String at3,String at4,String at5,String at6,String at7,String at8,String at9,String observaciones, DetallePasantia dp){
        
        Respuesta idRespuesta = new Respuesta();
        
        //GUARDO LA DATA EN TABLA DATOS
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            
            idRespuesta.setId_tbrespuesta(57);
            Datos d30 = new Datos(at1, dp, idRespuesta,true);
            sesion.saveOrUpdate(d30);
            
            idRespuesta.setId_tbrespuesta(58);
            Datos d31 = new Datos(at2, dp, idRespuesta,true);
            sesion.saveOrUpdate(d31);
            
            idRespuesta.setId_tbrespuesta(59);
            Datos d32 = new Datos(at3, dp, idRespuesta,true);
            sesion.saveOrUpdate(d32);
            
            idRespuesta.setId_tbrespuesta(60);
            Datos d33 = new Datos(at4, dp, idRespuesta,true);
            sesion.saveOrUpdate(d33);
            
            idRespuesta.setId_tbrespuesta(61);
            Datos d34 = new Datos(at5, dp, idRespuesta,true);
            sesion.saveOrUpdate(d34);
            
            idRespuesta.setId_tbrespuesta(62);
            Datos d35 = new Datos(at6, dp, idRespuesta,true);
            sesion.saveOrUpdate(d35);
            
            idRespuesta.setId_tbrespuesta(63);
            Datos d36 = new Datos(at7, dp, idRespuesta,true);
            sesion.saveOrUpdate(d36);
            
            idRespuesta.setId_tbrespuesta(64);
            Datos d37 = new Datos(at8, dp, idRespuesta,true);
            sesion.saveOrUpdate(d37);
            
            idRespuesta.setId_tbrespuesta(65);
            Datos d38 = new Datos(at9, dp, idRespuesta,true);
            sesion.saveOrUpdate(d38);
            
              idRespuesta.setId_tbrespuesta(66);
            Datos d39 = new Datos(observaciones, dp, idRespuesta,true);
            sesion.saveOrUpdate(d39);
            
            tx.commit();

        } catch (NumberFormatException e) {
            System.out.println("================ ERROR ACA =====================");
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        
    }
}
