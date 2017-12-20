/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;


import com.sppp.beans.Empresa;
import com.sppp.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Jairo
 */
public class EmpresaDAO {
    public Empresa findEmpresa(long ruc_empresa){
        Empresa empre=new Empresa();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        
        try{
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from Empresa WHERE id_empresa = :id ");
            query.setLong("id", ruc_empresa);
            
            empre = (Empresa) query.uniqueResult();
            tx.commit();
        }catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            sesion.close();
        }
        return empre;
    }
}
