package com.bean.compte;

import java.util.Map;

/**
 * @author <b>Maxime Pigeon</b> & <b>Annie Legault</b>
 * 
 * 
 */
public class Credentials {
	
	private int id;
	private String username, pwd;
	
	private Map<String, String> secretsQuestions;
	
	public Credentials(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
