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
 * @author EstJhonAlexanderCast
 */
public class DetallePasantiaDAO {

    public int findDetallePasantiaIdProcesoTrue(long id) {

        int numeroProceso=0;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        
        try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select id_proceso, cedula from tb_pasantia, tb_detalle_pasantia\n"
                    + "where  \n"
                    + "tb_pasantia.cod_ppp = tb_detalle_pasantia.cod_ppp and\n"
                    + "tb_pasantia.tipo_ppp = tb_detalle_pasantia.tipo_ppp and \n"
                    + "cedula = ? and tb_detalle_pasantia.estado = true;\n"
                    + "");

            List<Object[]> empData = query.setLong(0, id).list();
            for (Object[] row : empData) {
                numeroProceso = Integer.parseInt(row[0].toString());
                System.out.println(numeroProceso);
            }
            
            tx.commit();

        } catch (Exception e) {
            System.out.println("=================== ALGO SALIO MAL ==========================");
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        
        return numeroProceso;

    }

}
