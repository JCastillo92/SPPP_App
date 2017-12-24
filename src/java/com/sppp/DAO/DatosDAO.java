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


/**
 *
 * @author EstJhonAlexanderCast
 */
public class DatosDAO {
    
    public void DatosDAO(Usuario user, Empresa emp, Encargado enc, Pasantia pa, DetallePasantia dp){
        
        Respuesta rTipo_ppp = new Respuesta();
        Respuesta rCod_ppp = new Respuesta();
        Respuesta rNombreEmpresa = new Respuesta();
        Respuesta rDireccionEmpresa = new Respuesta();
        Respuesta rTelefonoEmpresa = new Respuesta();
        
        Respuesta idRespuesta = new Respuesta();
        
        
        Datos d1 = new Datos();
        d1.setValor_datos("Hola");
        //Este ID debe ir cambiando para la pregunta 
        idRespuesta.setId_tbrespuesta(1);
        d1.setRespuesta(idRespuesta);
        //Seteo el id de la detallePasantia
        d1.setDetallePasantias(dp);
        

        /*Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();
        Respuesta  = new Respuesta();*/
        
        
        
        
         
        
        
    }
    
}
