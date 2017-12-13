package com.service;

import java.io.FileInputStream;
import java.util.Properties;

public class LireMailProperties {
	
	public static Properties getMailProperties(){
		
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("C:/java3/tpFinal_max_annie/properties/email.properties"));
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
