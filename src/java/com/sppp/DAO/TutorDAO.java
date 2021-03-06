/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.DetallePasantia;
import com.sppp.beans.Tutor;
import com.sppp.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jairo
 */
public class TutorDAO {
    //AQUI BUSCO LOS DOCENTES y la condicion es aquel que tenga menos visitas
        public Tutor findTutorVisita(){
        Tutor datoTutor = new Tutor();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        try{
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("FROM Tutor ORDER BY cant_visitas ASC");
            query.setMaxResults(1);//perimite hacer un LIMIT 1
            datoTutor = (Tutor) query.uniqueResult();
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
        return datoTutor;
    }
        
    public List<Long> cedulasTutor() {

        List<Long> cedulasTutores = new LinkedList<>();
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery("select t.cedula FROM Tutor t");
            cedulasTutores = query.list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) {

                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }

        return cedulasTutores;

    }
        
        
}
