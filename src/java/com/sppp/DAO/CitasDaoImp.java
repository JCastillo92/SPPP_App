/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.VisitaTutor;
import com.sppp.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author KarenVanessaAchigGua
 */
public class CitasDaoImp implements CitasDao {

    
    public List<VisitaTutor> findAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        Transaction tx = null;
        List<VisitaTutor> listado = null;

        String sql = "FROM VisitaTutor";

        try {
            tx = sesion.beginTransaction();
              Query query = sesion.createQuery(sql);
          listado=query.list();
         //   listado = sesion.createQuery(sql).list();
//query.setInteger("id", id);
            tx.commit();
        } catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        return listado;
    }

  

}
