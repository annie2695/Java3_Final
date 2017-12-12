package com.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MailService {
	
	private static Logger logger = LogManager.getLogger(MailService.class);
	
	public void sendMail(String from, String to, String subject, String message){
		try {
			logger.info("Début de l'envoi de mail");
			Properties props = LireMailProperties.getMailProperties();
			Authenticator auth = new SMTPAuthenticator(props.getProperty("mail.user"), props.getProperty("mail.password"));
			Session session = Session.getInstance(props, auth);
			
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(from));
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(message);
			Transport.send(mimeMessage);
			logger.info("Le mail a été envoyé");
		} 
		catch (Exception e) {
			logger.error("Il y a eu un problème avec l'envoi de mail");
		}
	}
	

private class SMTPAuthenticator extends Authenticator{
		
		private PasswordAuthentication authentication;
		
		public SMTPAuthenticator(String login, String password){
			authentication = new PasswordAuthentication(login, password);
		}
		
		protected PasswordAuthentication getPasswordAuthentication(){
			return authentication;
		}
	}
	
}
