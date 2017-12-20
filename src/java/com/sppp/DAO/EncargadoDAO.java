/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Encargado;
import com.sppp.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jairo
 */
public class EncargadoDAO {
    public Encargado findEncargado(long id_encargado){
        //id_encargado NO ES LA CEDULA
        //buscar por id encargado y cedua est
        Encargado encar=new Encargado();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        
        try{
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from Encargado WHERE id_encargado = :id ");
            query.setLong("id", id_encargado);//NO ES LA CEDULA del encargado
            
            encar = (Encargado) query.uniqueResult();
            tx.commit();
        }catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            sesion.close();
        }
        return encar;

    }
}
