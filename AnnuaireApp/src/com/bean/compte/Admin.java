package com.bean.compte;

public class Admin extends Client {
	
	private static final String PREFIXE = "a";
	
	private Credentials credential;
	
	public Admin(String username, String password) {
		this.credential = new Credentials(PREFIXE + username, password);
	}

}
