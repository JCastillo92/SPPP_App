/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.utils;

import com.sppp.mailing.MailingMain;
import java.sql.ResultSet;


/**
 *
 * @author Jairo
 */
public class Cls_OutOfSystem {
    
     public void findUsuarioEmail(String emailto,Long identification){
        MailingMain enviarMailPassword= new MailingMain();
        String pass="";
       String query="SELECT clave FROM tb_usuario "
                    + "WHERE correo = '"+emailto+"' "
                    + "AND id_usuario = "+identification+"";
       Cls_con con = new Cls_con();
       ResultSet resultSet=null;
       try {
             resultSet=con.Consulta(query);
			while(resultSet.next()){
				pass=resultSet.getString(1);
			}
         } catch (Exception e) {
             pass="NO SE HA PODIDO VALIDAR LOS DATOS PARA LA RECUPERACION DE CLAVE";
             e.getMessage();
         }
       try {
	    	resultSet.close();
			con.getConexion().close();
		} catch (Exception e) {
			// TODO: handle exception
		}
         try {
            enviarMailPassword.mensajes(911, emailto, "Su clave es: >>>>>>>>> "+pass+" <<<<<<<<<<");
         } catch (Exception e) {
             e.printStackTrace();
         }
        
    }
    
}
