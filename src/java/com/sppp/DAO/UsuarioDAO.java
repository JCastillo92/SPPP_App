/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Estudiante;
import com.sppp.beans.Usuario;
import com.sppp.mailing.MailingMain;
import com.sppp.utils.HibernateUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EstJhonAlexanderCast
 */
public class UsuarioDAO {
    
    public Usuario findUsuario(long user){
        
        Usuario usu = new Usuario();
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        
        try {
            tx = sesion.beginTransaction();
            Query query = sesion.createQuery(" from Usuario WHERE id_cedula = :id ");
            query.setLong("id", user);
            
            usu = (Usuario) query.uniqueResult();
            tx.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }
        finally{
            //para cerrar seesion
            sesion.close();
        }
        
        return usu;
    }
    
    
    public void updateUserPassword(Usuario userNewPass){
         SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();
        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            sesion.update(userNewPass);
            tx.commit();
        } catch (Exception e) {
            
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
    }
    
   
    
    public Map<String,Long> findAllUsuariosTutores(){
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Map<String,Long> map=new HashMap<>();
        Transaction tx=null;    
        
        //variables a pedir
        long cedula_tut=0;
        
        String nomapp="";
        List<Object[]> empData=null;
         try {
            tx = sesion.beginTransaction();
            SQLQuery query = sesion.createSQLQuery("select tb_usuario.id_usuario, tb_usuario.nombre, tb_usuario.apellido \n" +
"from tb_usuario \n" +
"where tb_usuario.id_perfil=3;");

                empData = query.list();
            for (Object[] row : empData) {
                //variables que retorna la consulta
                cedula_tut = Long.parseLong(row[0].toString());
                nomapp=row[1].toString()+" "+row[2].toString();
                map.put(nomapp,cedula_tut);
            }
            tx.commit();
        }catch (Exception e) {
            e.printStackTrace();
            if (tx != null){
                tx.rollback();
            }
        }finally{
            //para cerrar seesion
            sesion.close();
        }
        return map;
        
    }
}
