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
        
        Datos d2 = new Datos();
        Datos d3 = new Datos();
        Datos d4 = new Datos();
        Datos d5 = new Datos();
        Datos d6 = new Datos();
        Datos d7 = new Datos();
        Datos d8 = new Datos();
        Datos d9 = new Datos();
        Datos d10 = new Datos();
        Datos d11 = new Datos();
        Datos d12 = new Datos();
        Datos d13 = new Datos();
        Datos d14 = new Datos();
        Datos d15 = new Datos();
        Datos d16 = new Datos();
        Datos d17 = new Datos();
        Datos d18 = new Datos();
        Datos d19 = new Datos();
        Datos d20 = new Datos();
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
