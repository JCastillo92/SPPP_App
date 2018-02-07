/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.utils.HibernateUtil;
import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jairo
 */
public class EmailDAO {
     public String searchForEmailGestor() {

        String thisIsTheEmail="";
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;

        try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select correo "
                    + "from tb_usuario "
                    + "where id_perfil=2 "
                    + "limit 1;");
                    thisIsTheEmail=(String) query.uniqueResult();
            tx.commit();

        } catch (Exception e) {
            System.out.println("=================== ALGO SALIO MAL thisIsTheEmail ==========================");
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }

        return thisIsTheEmail;

    }
}
