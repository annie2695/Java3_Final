package com.service;

import java.io.FileInputStream;
import java.util.Properties;

public class LireMailProperties {
	
	public static Properties getMailProperties(){
		
		Properties props = new Properties();
		try {/**
			props.load(new FileInputStream("d:/audi/email.properties"));
			props.setProperty("mail.host", props.getProperty("mail.host"));
			props.setProperty("mail.smtp.port", props.getProperty("mail.smtp.port"));
			props.setProperty("mail.smtp.auth", props.getProperty("mail.smtp.auth"));
			props.setProperty("mail.smtp.starttls.enable", props.getProperty("mail.smtp.starttls.enable"));
			props.setProperty("login", props.getProperty("login"));
			props.setProperty("password", props.getProperty("password"));
			*/
			
			props.load(new FileInputStream("H:/Programmation/git/Java3_Final/email.properties"));
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.smtp.host", "smtp.gmail.com");
			props.setProperty("mail.smtp.socketFactory.port", "465");
			props.setProperty("mail.smtp.port", "465");
			props.setProperty("mail.user", props.getProperty("login"));
			props.setProperty("mail.password", props.getProperty("password"));
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return props;
		
	}
	

}
