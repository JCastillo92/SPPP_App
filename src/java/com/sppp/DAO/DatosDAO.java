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

    public void DatosDAO(Usuario user, Empresa emp, Encargado enc, Pasantia pa, DetallePasantia dp, List<String> resps) {

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

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sesion = sf.openSession();

        Transaction tx = null;
        Usuario usuario = null;
        try {
            tx = sesion.beginTransaction();

            //Datos d1 = new Datos("valor" (String),"idpasantia"(int), "idRespuesta"(int));
            idRespuesta.setId_tbrespuesta(1);
            Datos d1 = new Datos(pa.getTipo_ppp(), dp, idRespuesta);
            sesion.saveOrUpdate(d1);
            idRespuesta.setId_tbrespuesta(2);
            Datos d2 = new Datos(String.valueOf(pa.getCod_ppp()), dp, idRespuesta);
            sesion.saveOrUpdate(d2);
            idRespuesta.setId_tbrespuesta(3);
            Datos d3 = new Datos(emp.getNombre_empresa(), dp, idRespuesta);
            sesion.saveOrUpdate(d3);
            idRespuesta.setId_tbrespuesta(4);
            Datos d4 = new Datos(emp.getDireccion_empresa(), dp, idRespuesta);
            sesion.saveOrUpdate(d4);
            idRespuesta.setId_tbrespuesta(5);
            Datos d5 = new Datos(emp.getTelefono_empresa(), dp, idRespuesta);
            sesion.saveOrUpdate(d5);
            idRespuesta.setId_tbrespuesta(6);
            Datos d6 = new Datos(emp.getActividad_principal_empresa(), dp, idRespuesta);
            sesion.saveOrUpdate(d6);
            idRespuesta.setId_tbrespuesta(7);
            Datos d7 = new Datos(user.getApellido(), dp, idRespuesta);
            sesion.saveOrUpdate(d7);
            idRespuesta.setId_tbrespuesta(8);
            Datos d8 = new Datos(user.getNombre(), dp, idRespuesta);
            sesion.saveOrUpdate(d8);
            idRespuesta.setId_tbrespuesta(9);
            Datos d9 = new Datos(resps.get(0), dp, idRespuesta);
            sesion.saveOrUpdate(d9);
            idRespuesta.setId_tbrespuesta(10);
            Datos d10 = new Datos(String.valueOf(user.getEstudiante().getUltimoNivel()), dp, idRespuesta);
            sesion.saveOrUpdate(d10);
            idRespuesta.setId_tbrespuesta(11);
            Datos d11 = new Datos(resps.get(1), dp, idRespuesta);
            sesion.saveOrUpdate(d11);
            idRespuesta.setId_tbrespuesta(12);
            Datos d12 = new Datos(resps.get(2), dp, idRespuesta);
            sesion.saveOrUpdate(d2);
            idRespuesta.setId_tbrespuesta(13);
            Datos d13 = new Datos(String.valueOf(user.getEstudiante().getHorasPasantia()), dp, idRespuesta);
            sesion.saveOrUpdate(d13);
            idRespuesta.setId_tbrespuesta(14);
            Datos d14 = new Datos(String.valueOf(pa.getFechaInicio()), dp, idRespuesta);
            sesion.saveOrUpdate(d14);
            idRespuesta.setId_tbrespuesta(15);
            Datos d15 = new Datos(String.valueOf(pa.getFechaFin()), dp, idRespuesta);
            sesion.saveOrUpdate(d15);
            idRespuesta.setId_tbrespuesta(16);
            Datos d16 = new Datos(resps.get(3), dp, idRespuesta);
            sesion.saveOrUpdate(d16);
            idRespuesta.setId_tbrespuesta(17);
            Datos d17 = new Datos(resps.get(4), dp, idRespuesta);
            sesion.saveOrUpdate(d17);
            idRespuesta.setId_tbrespuesta(18);
            Datos d18 = new Datos(resps.get(5), dp, idRespuesta);
            sesion.saveOrUpdate(d18);
            idRespuesta.setId_tbrespuesta(19);
            Datos d19 = new Datos(enc.getNombre_encargado(), dp, idRespuesta);
            sesion.saveOrUpdate(d19);
            idRespuesta.setId_tbrespuesta(20);
            Datos d20 = new Datos(resps.get(6), dp, idRespuesta);
            sesion.saveOrUpdate(d20);

            idRespuesta.setId_tbrespuesta(21);//para_resultadosPrevistoActividad
            Datos d21 = new Datos(resps.get(7), dp, idRespuesta);//traigo del LIST<>
            sesion.saveOrUpdate(d21);

            idRespuesta.setId_tbrespuesta(22);//para_productosEntregablesPrevistosActividad
            Datos d22 = new Datos(resps.get(8), dp, idRespuesta);//traigo del LIST<>
            sesion.saveOrUpdate(d22);

            idRespuesta.setId_tbrespuesta(23);//para_nombreTutorAsignado
            Datos d23 = new Datos("DEFAUL VALUE JAJA", dp, idRespuesta);
            sesion.saveOrUpdate(d23);

            idRespuesta.setId_tbrespuesta(24);//para_apellidosNombresGerenteEmpresa
            Datos d24 = new Datos(emp.getNombre_gerente(), dp, idRespuesta);//nombregerenteempresa
            sesion.saveOrUpdate(d24);

            idRespuesta.setId_tbrespuesta(25);//para_cargoGerenteEmpresa
            Datos d25 = new Datos(resps.get(9), dp, idRespuesta);//traigo del LIST<>
            sesion.saveOrUpdate(d25);

            idRespuesta.setId_tbrespuesta(26);//para_apellidosNombresDelegadoUPS
            Datos d26 = new Datos(resps.get(10), dp, idRespuesta);//traigo del LIST<>
            sesion.saveOrUpdate(d26);

            idRespuesta.setId_tbrespuesta(27);//para_cargoDelegadoUPS
            Datos d27 = new Datos(resps.get(11), dp, idRespuesta);//traigo del LIST<>
            sesion.saveOrUpdate(d27);

            idRespuesta.setId_tbrespuesta(28);//para_telefonoNombresDelegadoUPS
            Datos d28 = new Datos(resps.get(12), dp, idRespuesta);//traigo del LIST<>
            sesion.saveOrUpdate(d28);

            idRespuesta.setId_tbrespuesta(29);//para_lugarFechaSuscripcion
            Datos d29 = new Datos(resps.get(13), dp, idRespuesta);//traigo del LIST<>
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

}
