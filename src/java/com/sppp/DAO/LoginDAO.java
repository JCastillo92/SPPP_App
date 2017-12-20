/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.DAO;


import com.sppp.beans.Usuario;
import com.sppp.classes.AlmacenamientoPDF;
import com.sppp.mailing.MailingMain;
import com.sppp.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author EstJhonAlexanderCast
 */
public class LoginDAO {
    
    public static Usuario validate(String user, String password){
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session sesion=sf.openSession();
        
        Transaction tx=null;
        Usuario usuario=null;
        try {
            tx = sesion.beginTransaction();

            MailingMain obj2 = new MailingMain();
            obj2.mensajes(1, "jairdean@hotmail.com", "Titulo mensaje");
            //obj.create_student_folder_first_time(123);
            AlmacenamientoPDF obj = new AlmacenamientoPDF();
            obj.create_student_folder_first_time(123);
            obj.guardado_archivo_pdf_creado(123, 101);
            obj.guardado_archivo_pdf_creado(123, 102);

            obj.guardado_archivo_pdf_creado(123, 104);


            /*
=======
            /*            MailingMain obj2=new MailingMain();
        obj2.deliverMain();
>>>>>>> origin/master
                
            
                      AlmacenamientoPDF obj=new AlmacenamientoPDF();
                      obj.create_student_folder_first_time(123);
                      obj.guardado_archivo_pdf_subido(123,1);
            int idformato = 1;
            Set<Preguntas> preguntas;
            List<Campo> campos = new ArrayList<>() ;
            Campo campo;
            Set<Respuesta> resp=null;
            List<String> respuestas=null;
            Query query2 = sesion.createQuery(" from Formato WHERE id_tbformato = :id");
            Formato formato = new Formato();
            //Cambio a Long
            query2.setLong("id", idformato);
            formato = (Formato) query2.uniqueResult();

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
            }*/

            System.out.println("FIN SECCION DE PRUEBAS");

            System.out.println("U: " + user + " P: " + password);
            Query query = sesion.createQuery(" from Usuario WHERE id_cedula = :id and clave = :password");
            Long usuarioI = Long.parseLong(user);

            //Cambio a Long
            query.setLong("id", usuarioI);
            query.setString("password", password);
            usuario = (Usuario) query.uniqueResult();
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
        return usuario;
    }
    
}
