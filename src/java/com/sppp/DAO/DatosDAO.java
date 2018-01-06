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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author EstJhonAlexanderCast
 */
public class DatosDAO {

    public void datosGuardar(Usuario user, Empresa emp, Encargado enc, Pasantia pa, DetallePasantia dp, List<String> resps) {

        Respuesta idRespuesta = new Respuesta();

        Datos d1000 = new Datos();
        // ------- PARA INSERTAR LA PREGUNTA -------
        d1000.setValor_datos("Hola");
        //Este ID debe ir cambiando para la pregunta 
        idRespuesta.setId_tbrespuesta(1);
        d1000.setRespuesta(idRespuesta);
        //Seteo el id de la detallePasantia
        d1000.setDetallePasantias(dp);
        // ------ FIN INSERTAR 1 PREGUNTA ----------
        
        //Asigno el tutor a la pasantia

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        Transaction tx = null;
        Usuario usuario = null;
        try {
            tx = sesion.beginTransaction();
            
            //Paso a guardar las horas pasantia
            sesion.update(user);
            sesion.update(pa);
            
            //Datos d1 = new Datos("valor" (String),"idpasantia"(int), "idRespuesta"(int));
            idRespuesta.setId_tbrespuesta(1);
            Datos d1 = new Datos(pa.getTipo_ppp(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d1);
            idRespuesta.setId_tbrespuesta(2);
            Datos d2 = new Datos(String.valueOf(pa.getCod_ppp()), dp, idRespuesta,true);
            sesion.saveOrUpdate(d2);
            idRespuesta.setId_tbrespuesta(3);
            Datos d3 = new Datos(emp.getNombre_empresa(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d3);
            idRespuesta.setId_tbrespuesta(4);
            Datos d4 = new Datos(emp.getDireccion_empresa(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d4);
            idRespuesta.setId_tbrespuesta(5);
            Datos d5 = new Datos(emp.getTelefono_empresa(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d5);
            idRespuesta.setId_tbrespuesta(6);
            Datos d6 = new Datos(emp.getActividad_principal_empresa(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d6);
            idRespuesta.setId_tbrespuesta(7);
            Datos d7 = new Datos(user.getApellido(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d7);
            idRespuesta.setId_tbrespuesta(8);
            Datos d8 = new Datos(user.getNombre(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d8);
            idRespuesta.setId_tbrespuesta(9);
            Datos d9 = new Datos(resps.get(0), dp, idRespuesta,true);
            sesion.saveOrUpdate(d9);
            idRespuesta.setId_tbrespuesta(10);
            Datos d10 = new Datos(String.valueOf(user.getEstudiante().getUltimoNivel()), dp, idRespuesta,true);
            sesion.saveOrUpdate(d10);
            idRespuesta.setId_tbrespuesta(11);
            Datos d11 = new Datos(resps.get(1), dp, idRespuesta,true);
            sesion.saveOrUpdate(d11);
            idRespuesta.setId_tbrespuesta(12);
            Datos d12 = new Datos(resps.get(2), dp, idRespuesta,true);
            sesion.saveOrUpdate(d12);
            idRespuesta.setId_tbrespuesta(13);
            Datos d13 = new Datos(String.valueOf(user.getEstudiante().getHorasPasantia()), dp, idRespuesta,true);
            sesion.saveOrUpdate(d13);
            idRespuesta.setId_tbrespuesta(14);
            Datos d14 = new Datos(String.valueOf(pa.getFechaInicio()), dp, idRespuesta,true);
            sesion.saveOrUpdate(d14);
            idRespuesta.setId_tbrespuesta(15);
            Datos d15 = new Datos(String.valueOf(pa.getFechaFin()), dp, idRespuesta,true);
            sesion.saveOrUpdate(d15);
            idRespuesta.setId_tbrespuesta(16);
            Datos d16 = new Datos(resps.get(3), dp, idRespuesta,true);
            sesion.saveOrUpdate(d16);
            idRespuesta.setId_tbrespuesta(17);
            Datos d17 = new Datos(resps.get(4), dp, idRespuesta,true);
            sesion.saveOrUpdate(d17);
            idRespuesta.setId_tbrespuesta(18);
            Datos d18 = new Datos(resps.get(5), dp, idRespuesta,true);
            sesion.saveOrUpdate(d18);
            idRespuesta.setId_tbrespuesta(19);
            Datos d19 = new Datos(enc.getNombre_encargado(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d19);
            idRespuesta.setId_tbrespuesta(20);
            Datos d20 = new Datos(resps.get(6), dp, idRespuesta,true);
            sesion.saveOrUpdate(d20);

            idRespuesta.setId_tbrespuesta(21);//para_resultadosPrevistoActividad
            Datos d21 = new Datos(resps.get(7), dp, idRespuesta,true);//traigo del LIST<>
            sesion.saveOrUpdate(d21);

            idRespuesta.setId_tbrespuesta(22);//para_productosEntregablesPrevistosActividad
            Datos d22 = new Datos(resps.get(8), dp, idRespuesta,true);//traigo del LIST<>
            sesion.saveOrUpdate(d22);

            idRespuesta.setId_tbrespuesta(23);//para_nombreTutorAsignado
            Datos d23 = new Datos(pa.getCed_tutor_asignado(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d23);

            idRespuesta.setId_tbrespuesta(24);//para_apellidosNombresGerenteEmpresa
            Datos d24 = new Datos(emp.getNombre_gerente(), dp, idRespuesta,true);//nombregerenteempresa
            sesion.saveOrUpdate(d24);

            idRespuesta.setId_tbrespuesta(25);//para_cargoGerenteEmpresa
            Datos d25 = new Datos(resps.get(9), dp, idRespuesta,true);//traigo del LIST<>
            sesion.saveOrUpdate(d25);

            idRespuesta.setId_tbrespuesta(26);//para_apellidosNombresDelegadoUPS
            Datos d26 = new Datos(resps.get(10), dp, idRespuesta,true);//traigo del LIST<>
            sesion.saveOrUpdate(d26);

            idRespuesta.setId_tbrespuesta(27);//para_cargoDelegadoUPS
            Datos d27 = new Datos(resps.get(11), dp, idRespuesta,true);//traigo del LIST<>
            sesion.saveOrUpdate(d27);

            idRespuesta.setId_tbrespuesta(28);//para_telefonoNombresDelegadoUPS
            Datos d28 = new Datos(resps.get(12), dp, idRespuesta,true);//traigo del LIST<>
            sesion.saveOrUpdate(d28);

            idRespuesta.setId_tbrespuesta(29);//para_lugarFechaSuscripcion
            Datos d29 = new Datos(resps.get(13), dp, idRespuesta,true);//traigo del LIST<>
            sesion.saveOrUpdate(d29);

            tx.commit();

        } catch (NumberFormatException e) {
            e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }

    }
    
    //METODO PARA TRAER TODOS LOS DATOS DE 1 ESTUDIANTE
    public List<Datos> datosPorDetallePasantia(int id){
        List<Datos> datosCartaC = new LinkedList<>();
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        Transaction tx = null;
        Usuario usuario = null;
        try {
            tx = sesion.beginTransaction();
            
            Query query = sesion.createQuery(" from Datos WHERE detallePasantias.idDetallePasantia = :id order by respuesta.id_tbrespuesta ");
            query.setInteger("id", id);
            
            datosCartaC = query.list();
            
            tx.commit();

        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("============== ERROR AL HACER LA LISTA =========");
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        
        
        return datosCartaC;
    }
    
    //METODO PARA TRAER TODOS LOS DATOS DE 1 ESTUDIANTE
    public void guardarValidacionCC(List<Datos> datosValidados){
        
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        Transaction tx = null;
        Usuario usuario = null;
        try {
            tx = sesion.beginTransaction();
            
            for (Iterator<Datos> iterator = datosValidados.iterator(); iterator.hasNext();) {
                Datos next = iterator.next();
                sesion.update(next);
            }
            
            tx.commit();

        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("============== ERROR AL GUARDAR DATOS VALIDADOS CC =========");
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        
        
    }
    
    public void guardarDatosBasicos(Usuario user, Empresa emp, Encargado enc, Pasantia pa, DetallePasantia dp){
        
        Respuesta idRespuesta = new Respuesta();
        
        //GUARDO LA DATA EN TABLA DATOS
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        Transaction tx = null;
        try {
            tx = sesion.beginTransaction();
            
            idRespuesta.setId_tbrespuesta(30);
            Datos d30 = new Datos(user.getNombre(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d30);
            
            idRespuesta.setId_tbrespuesta(31);
            Datos d31 = new Datos(user.getApellido(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d31);
            
            idRespuesta.setId_tbrespuesta(32);
            Datos d32 = new Datos(user.getTelefono(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d32);
            
            idRespuesta.setId_tbrespuesta(33);
            Datos d33 = new Datos(user.getCorreo(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d33);
            
            idRespuesta.setId_tbrespuesta(34);
            Datos d34 = new Datos(user.getEstudiante().getUltimoNivel()+"", dp, idRespuesta,true);
            sesion.saveOrUpdate(d34);
            
            idRespuesta.setId_tbrespuesta(35);
            Datos d35 = new Datos(user.getEstudiante().getActividadRealizar(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d35);
            
            idRespuesta.setId_tbrespuesta(36);
            Datos d36 = new Datos(pa.getTipo_ppp(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d36);
            
            idRespuesta.setId_tbrespuesta(37);
            Datos d37 = new Datos(pa.getFechaInicio().toString(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d37);
            
            idRespuesta.setId_tbrespuesta(38);
            Datos d38 = new Datos(pa.getFechaFin().toString(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d38);
            
            idRespuesta.setId_tbrespuesta(39);
            Datos d39 = new Datos(emp.getId_empresa()+"", dp, idRespuesta,true);
            sesion.saveOrUpdate(d39);
            
            idRespuesta.setId_tbrespuesta(40);
            Datos d40 = new Datos(emp.getNombre_empresa(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d40);
            
            idRespuesta.setId_tbrespuesta(41);
            Datos d41 = new Datos(emp.getNombre_gerente(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d41);
            
            idRespuesta.setId_tbrespuesta(42);
            Datos d42 = new Datos(emp.getTelefono_empresa(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d42);
            
            idRespuesta.setId_tbrespuesta(43);
            Datos d43 = new Datos(emp.getDireccion_empresa(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d43);
            
            idRespuesta.setId_tbrespuesta(44);
            Datos d44 = new Datos(emp.getActividad_principal_empresa(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d44);
            System.out.println(""); // NO BORRAR ESTE SOUT !!!
            idRespuesta.setId_tbrespuesta(45);
            Datos d45 = new Datos(enc.getCi_encargado()+"", dp, idRespuesta,true);
            sesion.saveOrUpdate(d45);
            
            idRespuesta.setId_tbrespuesta(46);
            Datos d46 = new Datos(enc.getNombre_encargado(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d46);
            
            idRespuesta.setId_tbrespuesta(47);
            Datos d47 = new Datos(enc.getCargo_encargado(), dp, idRespuesta,true);
            sesion.saveOrUpdate(d47);
            
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
    
    public void actualizarDatosBasicos(Usuario user, Empresa emp, Encargado enc, Pasantia pa, DetallePasantia dp){
        
        //Traigo los datos
        List<Datos> datosBasics = datosPorDetallePasantia(dp.getIdDetallePasantia());
        
        //Coloco el nuevo valor que el estudiante ingreso
       datosBasics.get(0).setValor_datos(user.getNombre());
       datosBasics.get(1).setValor_datos(user.getApellido());
       datosBasics.get(2).setValor_datos(user.getTelefono());
       datosBasics.get(3).setValor_datos(user.getCorreo());
       datosBasics.get(4).setValor_datos(user.getEstudiante().getUltimoNivel()+"");
       datosBasics.get(5).setValor_datos(user.getEstudiante().getActividadRealizar());
       datosBasics.get(6).setValor_datos(pa.getTipo_ppp());
       datosBasics.get(7).setValor_datos(pa.getFechaInicio().toString());
       datosBasics.get(8).setValor_datos(pa.getFechaFin().toString());
       datosBasics.get(9).setValor_datos(emp.getId_empresa()+"");
       datosBasics.get(10).setValor_datos(emp.getNombre_empresa());
       datosBasics.get(11).setValor_datos(emp.getNombre_gerente());
       datosBasics.get(12).setValor_datos(emp.getTelefono_empresa());
       datosBasics.get(13).setValor_datos(emp.getDireccion_empresa());
       datosBasics.get(14).setValor_datos(emp.getActividad_principal_empresa());
       datosBasics.get(15).setValor_datos(enc.getCi_encargado()+"");
       datosBasics.get(16).setValor_datos(enc.getNombre_encargado());
       datosBasics.get(17).setValor_datos(enc.getCargo_encargado());
       
       //Mando a guardar la lista
        guardarValidacionCC(datosBasics);
        
    }
    
    public void actualizarDatosCartaCompromiso(Usuario user, Empresa emp, Encargado enc, Pasantia pa, DetallePasantia dp, List<String> resps){
        
        //Traigo los datos
        List<Datos> datosCartaC = datosPorDetallePasantia(dp.getIdDetallePasantia());
        
        //Coloco los nuevos valores que el estudiante ingreso
        datosCartaC.get(11).setValor_datos(resps.get(2));
        datosCartaC.get(15).setValor_datos(resps.get(3));
        datosCartaC.get(16).setValor_datos(resps.get(4));
        datosCartaC.get(17).setValor_datos(resps.get(5));
        datosCartaC.get(19).setValor_datos(resps.get(6));
        datosCartaC.get(20).setValor_datos(resps.get(7));
        datosCartaC.get(21).setValor_datos(resps.get(8));
        
        //ojo al guardar el tutor
        datosCartaC.get(22).setValor_datos(pa.getCed_tutor_asignado().toString());
        
        guardarValidacionCC(datosCartaC);
        /*
        datosCartaC.get(8).setValor_datos();
        datosCartaC.get(9).setValor_datos();
        datosCartaC.get(10).setValor_datos();
        datosCartaC.get(11).setValor_datos();
        datosCartaC.get(12).setValor_datos();
        datosCartaC.get(13).setValor_datos();
        datosCartaC.get(14).setValor_datos();
        datosCartaC.get(15).setValor_datos();
        datosCartaC.get(16).setValor_datos();
        datosCartaC.get(17).setValor_datos();
        datosCartaC.get(18).setValor_datos();
        datosCartaC.get(19).setValor_datos();
        datosCartaC.get(20).setValor_datos();
        datosCartaC.get(21).setValor_datos();
        datosCartaC.get(22).setValor_datos();
        datosCartaC.get(23).setValor_datos();
        datosCartaC.get(24).setValor_datos();
        datosCartaC.get(25).setValor_datos();
        datosCartaC.get(26).setValor_datos();
        datosCartaC.get(27).setValor_datos();
        datosCartaC.get(28).setValor_datos();
        datosCartaC.get(29).setValor_datos();
        */
        
        
    }
    
    public boolean hayDatosDeDetallePasantia(long idDetallePasantia){
        
        boolean existe =  false;
        long numeroDatos = 0;
        
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        Transaction tx = null;
        Usuario usuario = null;
        try {
            tx = sesion.beginTransaction();
            
            Query query = sesion.createQuery("SELECT COUNT(*) FROM Datos D WHERE D.detallePasantias.idDetallePasantia = :id_pro");
            query.setLong("id_pro", idDetallePasantia);//fk de tb_proceso 14
            numeroDatos=(long) query.uniqueResult();  
            
            tx.commit();

        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("============== ERROR AL GUARDAR DATOS VALIDADOS CC =========");
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            //para cerrar seesion
            sesion.close();
        }
        
        if(numeroDatos > 0){
            existe = true;
        }
        
        return existe;
    }
    

}
