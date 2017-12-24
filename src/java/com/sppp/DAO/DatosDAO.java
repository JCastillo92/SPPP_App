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
import java.util.List;


/**
 *
 * @author EstJhonAlexanderCast
 */
public class DatosDAO {
    
    public void DatosDAO(Usuario user, Empresa emp, Encargado enc, Pasantia pa, DetallePasantia dp,List<String>resps){
        
        
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
        
        //Datos d1 = new Datos("valor" (String),"idpasantia"(int), "idRespuesta"(int));
        idRespuesta.setId_tbrespuesta(1);
        Datos d1 = new Datos(pa.getTipo_ppp(),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(2);
        Datos d2 = new Datos(String.valueOf(pa.getCod_ppp()),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(3);
        Datos d3 = new Datos(emp.getNombre_empresa(),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(4);
        Datos d4 = new Datos(emp.getDireccion_empresa(),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(5);
        Datos d5 = new Datos(emp.getTelefono_empresa(),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(6);
        Datos d6 = new Datos(emp.getActividad_principal_empresa(),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(7);
        Datos d7 = new Datos(user.getApellido(),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(8);
        Datos d8 = new Datos(user.getNombre(),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(9);
        Datos d9 = new Datos(resps.get(0),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(10);
        Datos d10 = new Datos(String.valueOf(user.getEstudiante().getUltimoNivel()),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(11);
        Datos d11 = new Datos(resps.get(1),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(12);
        Datos d12 = new Datos(resps.get(2),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(13);
        Datos d13 = new Datos(String.valueOf(user.getEstudiante().getHorasPasantia()),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(14);
        Datos d14 = new Datos(String.valueOf(pa.getFechaInicio()),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(15);
        Datos d15 = new Datos(String.valueOf(pa.getFechaFin()),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(16);
        Datos d16 = new Datos(resps.get(3),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(17);
        Datos d17 = new Datos(resps.get(4),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(18);
        Datos d18 = new Datos(resps.get(5),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(19);
        Datos d19 = new Datos(enc.getNombre_encargado(),dp,idRespuesta);
        idRespuesta.setId_tbrespuesta(20);
        Datos d20 = new Datos(resps.get(6),dp,idRespuesta);
        Datos d21 = new Datos();
        Datos d22 = new Datos();
        Datos d23 = new Datos();
        Datos d24 = new Datos();
        Datos d25 = new Datos();
        Datos d26 = new Datos();
        Datos d27 = new Datos();
        Datos d28 = new Datos();
        Datos d29 = new Datos();
        Datos d30 = new Datos();
        
        
        
        
        
    }
    
}
