/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    private String username = "spppsistemasups@gmail.com";
    private String password = "@sistemasKJ2B";
    
    public void mensajes(int tipo_mensaje, String AddRecipientDestination,String AddSubject){
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
	        protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication("clubecologicoups@gmail.com","est.ups.edu.ec");
	        }});
	 
	        emailSession.setDebug(true);
	        Message message = new MimeMessage(emailSession);
	        message.setFrom(new InternetAddress("spppsistemasups@gmail.com"));
	        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(AddRecipientDestination));
	        message.setSubject(AddSubject);//tema, asunto del email
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