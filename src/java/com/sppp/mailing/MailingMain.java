/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
https://www.youtube.com/watch?v=D-NYmDWiFjU
 */
package com.sppp.mailing;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Jairo
 * 
 */

public class MailingMain {
    String username = "spppsistemasups@gmail.com";
    String password = "@sistemasKJ2B";
    
    //Texto quemado que puede REPETIRSE
    private String ponnombreAPP="SPPP (Sistema de Pasantías y Prácticas Pre Profesionales). ";
    private String pondespedida="No usar este medio para realizar preguntas o envio de información. ";
    private String poningreso="Se requiere que ingrese al sistema con sus creadenciales y revise el estado de sus datos o documentos. ";
    
    
    public void mensajes(int tipo_mensaje, String AddRecipientDestination, String observaciones){
        String contentMessage="";
        String AddSubject="";//siempre deba existir un sujeto en CADA CASE
        switch(tipo_mensaje){
            //case para alumnos del 1 al 1000
            case 1:
               AddSubject="CORRECCIÓN DE DOCUMETACIÓN";
                contentMessage="Estimada/o estudiante, se ha revisado sus últimos cambios realizados en el "+ponnombreAPP+" "
                        +poningreso;
                break;
            case 2:
                AddSubject="APROVACION DE DOCUMENTACION E INFORMACION";
                contentMessage="Estimada/o estudiante, se ha revisado sus últimos cambios realizados en el "+ponnombreAPP+" "
                        + "Dicha información ha sido aprobada. "+poningreso+"";
                break;
            case 3:
                AddSubject="";
                contentMessage="";
                break;
            case 4:
                AddSubject="";
                contentMessage="";
                break;
                //Didiershito
                 case 5:
                AddSubject="FECHA DE VISITA " + ponnombreAPP;
                contentMessage= "Visita a realizar";
                break;
                 case 6:
                AddSubject="CANCELACIÓN DE VISITA " + ponnombreAPP;
                contentMessage="Visita a cancelar";
                break;
                case 7:
                AddSubject="CONFIRMACIÓN DE VISITA " + ponnombreAPP;
                contentMessage="Visita confirmada";
                break;
                case 8:
                AddSubject="VALIDACIÓN DE PASANTÍAS/PRÁCTICAS PREPROFESIONALES" + ponnombreAPP;
                contentMessage="Validación final";
                break;
                
                
                //CASE P A R A  D O C E N T E , A D I M I N S T R A T I V O S , T U T O R E S, SE C RE T A R I A
            case 1001:
                AddSubject="REVISIÓN INICIO PROCESO PASANTÍA";
                contentMessage="Existe nuevos alumnos que han inrgesado datos personales y de la empresa, los cuales "
                        + "se requiere revisar, validar y aprobar.";
                break;
            case 1002:
                AddSubject="REVISIÓN DE OFICIO Y CARTA DE ACEPTACIÓN";
                contentMessage="Existe documentos subidos (escaneados) a la plataforma, Oficio para la Empresa y Carta de Aceptación, listos para revisar y aprobar.";
                break;
            case 1003:
                AddSubject="REVISIÓN DE CARTA COMPROMISO";
                contentMessage="Existe documento subido (escaneado) a la plataforma, Carta de Compromisolistos, lista para revisar y aprobar.";
                break;    
                case 1004:
                AddSubject="REVISIÓN DE INICIAR PASANTÍA";
                contentMessage="Existe documento subido (escaneado) a la plataforma, Solicitud Inicio Pasantía/Práctica Pre-Profesional, lista para revisar y aprobar.";
                break;    
                default:
                    
                    break;
        }
        if(!observaciones.equals("vacio")){
            //envio de mensaje CON observaciones
            contentMessage=contentMessage+"\n"+"\nObservaciones realizadas: \n"+observaciones;
            deliverMail(AddRecipientDestination,AddSubject.toUpperCase(),contentMessage);
        }else{
            //envio de mensaje SIN observaciones
            deliverMail(AddRecipientDestination,AddSubject.toUpperCase(),contentMessage);
        }
        
    }//fin void mensajes
    
    
    
    private void deliverMail(String AddRecipientDestination, String AddSubject,String contentMessage){       
        try {
	        Properties props = System.getProperties();
	        props.setProperty("mail.transport.protocol", "smtp");
	        props.setProperty("mail.host", "smtp.gmail.com");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.port", "465");
	        props.put("mail.debug", "true");
	        props.put("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.socketFactory.fallback", "false");
	 
	        Session emailSession = Session.getInstance(props,new javax.mail.Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication("spppsistemasups@gmail.com","@sistemasKJ2B");
	        }});
	 
	        emailSession.setDebug(true);
	        Message message = new MimeMessage(emailSession);
	        message.setFrom(new InternetAddress(username));
	        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(AddRecipientDestination));
	        message.setSubject(AddSubject);
	        message.setText(contentMessage);
	 
	        Transport transport = emailSession.getTransport("smtps");
	        transport.connect("smtp.gmail.com", username, password);
	        transport.sendMessage(message, message.getAllRecipients());
	       } catch (MessagingException e) {
	    	  e.getMessage();
	       }
	    
    }//end of method deliverMail()
}//end of CLASS







/*
Nombre 
Ingenieria de sistemas UPS 
Apellido
Sede quito
Nombre usuario
spppsistemasups@gmail.com
contraseña
@sistemasKJ2B
fecha 26 /08/1993
telefono movil
+593983466689
direccion actual
jairdean@hotmail.com
ubicacion 
ecuador

*/
