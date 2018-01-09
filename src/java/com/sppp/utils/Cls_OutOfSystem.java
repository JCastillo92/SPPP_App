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
    private MailingMain enviarMailPassword= new MailingMain();
    
    
    
     public boolean findUsuarioEmail(String emailto,Long identification){
         boolean verdad=false;
        verdad=get_the_user(emailto,identification);
        return verdad;
    }
     
     
     private boolean get_the_user(String emailto,Long identification){
        boolean verdad;
            verdad = false;
        String pass="";
        int cont=0;
       String query="SELECT clave FROM tb_usuario "
                    + "WHERE correo = '"+emailto+"' "
                    + "AND id_usuario = "+identification+"";
       Cls_con con = new Cls_con();
       ResultSet resultSet=null;
       try {
             resultSet=con.Consulta(query);
			while(resultSet.next()){
				pass=resultSet.getString(1);
                                cont++;
			}
         } catch (Exception e) {
             verdad=false;
             e.getMessage();
         }
       
         try {
             if(cont>0){
            enviarMailPassword.mensajes(911, emailto, "Su clave es: >>>>>>>>> "+pass+" <<<<<<<<<<");
             verdad=true;
             }
         } catch (Exception e) {
             verdad=false;
             e.printStackTrace();
         }
       try {
	    	resultSet.close();
			con.getConexion().close();
		} catch (Exception e) {
			verdad=false;
		} 
         
         return verdad;
     }//end of method
    
}
