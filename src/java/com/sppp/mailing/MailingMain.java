/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sppp.mailing;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Jairo
 */
public class MailingMain {
    public void deliverMain(){
        String GetRecipientDestination=null,GetRecipientNick=null,LibraryPredeterminated=null;
		String username = "clubecologicoups@gmail.com";
	    String password = "est.ups.edu.ec";
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
	        message.setFrom(new InternetAddress("clubecologicoups@gmail.com"));
	        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(GetRecipientDestination));
	        message.setSubject("ClubEcológicoUps mensaje automático");
	        message.setText(LibraryPredeterminated);
	 
	        Transport transport = emailSession.getTransport("smtps");
	        transport.connect("smtp.gmail.com", username, password);
	        transport.sendMessage(message, message.getAllRecipients());
	       } catch (MessagingException e) {
	    	  e.getMessage();
	       }
    }//end of main
}
