/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;

import com.sppp.beans.Campo;
import com.sppp.beans.Estudiante;
import com.sppp.beans.Formato;
import com.sppp.beans.Perfil;
import com.sppp.beans.Preguntas;
import com.sppp.beans.Respuesta;
import com.sppp.beans.Usuario;
import com.sppp.utils.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EstJhonAlexanderCast
 */
public class CampoDAO {
    
    
    public List<Campo> obternerCampos(int idformato) {
        idformato=1;
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        Transaction tx=null;
        
        Set<Preguntas> preguntas=null;
        List<Campo> campos = new ArrayList<>();
        Campo campo;
        Set<Respuesta> resp = null;
        List<String> respuestas = null;

        try {
            tx = sesion.beginTransaction();

            Query query = sesion.createQuery(" from Formato WHERE id_tbformato = :id");
            Formato formato = new Formato();
            //Cambio a Long
            query.setLong("id", idformato);
            formato = (Formato) query.uniqueResult();

            preguntas = formato.getPreguntas();
            for (Iterator<Preguntas> iterator = preguntas.iterator(); iterator.hasNext();) {
                Preguntas next = iterator.next();
                resp = next.getRespuesta();
                for (Iterator<Respuesta> iterator1 = resp.iterator(); iterator1.hasNext();) {
                    Respuesta next1 = iterator1.next();
                    respuestas.add(next1.getDescripcion_resp());
                }
                campo = new Campo(next.getDescripcion(),next.getTipoPregunta().getTipo(),respuestas);
                campos.add(campo);
                System.out.println("Hola "+campo.getNombre()+" "+campo.getTipo());
            }
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
         
        return campos;
        
    }
    
}
